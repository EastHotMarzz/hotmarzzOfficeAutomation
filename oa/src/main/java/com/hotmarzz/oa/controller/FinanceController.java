package com.hotmarzz.oa.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.basic.dao.Expression;
import com.hotmarzz.basic.utils.JsonUtils;
import com.hotmarzz.basic.utils.StringUtils;
import com.hotmarzz.oa.anno.FormToken;
import com.hotmarzz.oa.buzz.FinanceBuzz;
import com.hotmarzz.oa.buzz.SchoolBuzz;
import com.hotmarzz.oa.dto.CampusWaterDto;
import com.hotmarzz.oa.dto.FinanceDto;
import com.hotmarzz.oa.pojo.CampusWater;
import com.hotmarzz.oa.pojo.Emp;
import com.hotmarzz.oa.pojo.FinSubjectDetail;
import com.hotmarzz.oa.pojo.Financial;
import com.hotmarzz.oa.pojo.SchoolDistrict;
import com.hotmarzz.oa.pojo.SubjectDetail;
import com.hotmarzz.oa.utils.ExcelUtil;
import com.hotmarzz.oa.utils.FormatDateUtil;
import com.hotmarzz.oa.utils.FormatNumberUtil;
import com.hotmarzz.oa.utils.SessionUtils;

@Controller
public class FinanceController {

	private Logger logger = LoggerFactory.getLogger(FinanceController.class);

	private FinanceBuzz finBuzz;
	private SchoolBuzz schoolBuzz;

	public FinanceBuzz getFinBuzz() {
		return finBuzz;
	}

	@Autowired
	public void setFinBuzz(FinanceBuzz finBuzz) {
		this.finBuzz = finBuzz;
	}
	
	public SchoolBuzz getSchoolBuzz() {
		return schoolBuzz;
	}
	@Autowired
	public void setSchoolBuzz(SchoolBuzz schoolBuzz) {
		this.schoolBuzz = schoolBuzz;
	}

	@RequestMapping(value = "fins.do", method = RequestMethod.GET)
	public String getWaterPage(Model model, CampusWater cw,HttpSession session) throws Exception {
		String now = FormatDateUtil.getCurrentYearAndMonthStr();
		String pre = FormatDateUtil.getCurrentYearAndPreMonthStr();
		FinanceDto fin = new FinanceDto();
		Emp loginEmp = (Emp) session.getAttribute(SessionUtils.LOGIN_EMP_KEY);
		// 当月总收入
		Double din = finBuzz.getSumIncome(now);
		// 当月总支出
		Double dout = finBuzz.getSumExpenditure(now);
		// 上月总收入
		Double pin = finBuzz.getSumIncome(pre);
		// 上月总支出
		Double pout = finBuzz.getSumExpenditure(pre);
		// 今年总收入
		Double sum = finBuzz.getCurrentYearWaterSum(loginEmp
				.getSchoolDistrict().getSchoolId());
		// 如果没有账单，则置零
		if (din == null || dout == null || pin == null || pout == null) {
			if (din == null) {
				din = 0.0;
			}
			if (dout == null) {
				dout = 0.0;
			}
			if (pin == null) {
				pin = 0.0;
			}
			if (pout == null) {
				pout = 0.0;
			}
			if (sum == null) {
				sum = 0.0;
			}
		}
		// 使用工具，截取到"分"
		fin.setSumIncome(FormatNumberUtil.formartTwoPoint(din));
		fin.setSumExpenditure(FormatNumberUtil.formartTwoPoint(dout));
		fin.setCurCount(FormatNumberUtil.formartTwoPoint(din - dout));
		fin.setPreCount(FormatNumberUtil.formartTwoPoint(pin - pout));
		fin.setSumCount(FormatNumberUtil.formartTwoPoint(sum));

		cw.setWaterType(0);

		model.addAttribute("subs", finBuzz.getSubsList());
		model.addAttribute("fin", fin);
		model.addAttribute("cw", cw);
		model.addAttribute("schs",schoolBuzz.getAll());
		return "financeResources/waters";
	}

	@RequestMapping(value = "getSubDetailsList/{subId}.do", method = RequestMethod.POST)
	@ResponseBody
	public String getSubDetailsList(@PathVariable("subId") Long subId)
			throws Exception {
		List<SubjectDetail> subDetails = finBuzz.getSubDetailsList(subId);
		return JsonUtils.bean2Json(subDetails);
	}

	@RequestMapping(value = "getFinSubDetailsList/{subId}.do", method = RequestMethod.POST)
	@ResponseBody
	public String getFinSubDetailsList(@PathVariable("subId") Long subId)
			throws Exception {
		List<FinSubjectDetail> subDetails = finBuzz.getFinSubDetailsList(subId);
		return JsonUtils.bean2Json(subDetails);
	}

	@RequestMapping(value = "getFinList.do", method = RequestMethod.POST)
	@ResponseBody
	public String getFinList(@RequestBody CampusWater cw) throws Exception {
		Map<String, Object> queryParams = cw.getQueryParams();

		if (queryParams.containsKey("waterType")
				&& StringUtils
						.isNotEmpty((String) queryParams.get("waterType"))) {
			cw.putCondition("waterType", Expression.OP_EQ,
					queryParams.get("waterType"));
		}
		if (queryParams.containsKey("startDate")
				&& StringUtils
						.isNotEmpty((String) queryParams.get("startDate"))) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			cw.setStartDate(sdf.parse((String) queryParams.get("startDate")));
		}
		if (queryParams.containsKey("endDate")
				&& StringUtils.isNotEmpty((String) queryParams.get("endDate"))) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			cw.setEndDate(sdf.parse((String) queryParams.get("endDate")));
		}
		
		if (queryParams.containsKey("createUser")
				&& StringUtils.isNotEmpty((String) queryParams.get("createUser"))) {
			cw.putCondition("cw.createUser", Expression.OP_LIKE,
						"%"+queryParams.get("createUser")+"%");
		}
		
		if (queryParams.containsKey("subId")
				&& StringUtils.isNotEmpty((String) queryParams.get("subId"))) {
			if (!"0".equals((String) queryParams.get("subId"))) {
				cw.putCondition("cw.subjectid", Expression.OP_EQ,
						queryParams.get("subId"));
			}
		}
		if (queryParams.containsKey("subDetailId")
				&& StringUtils.isNotEmpty((String) queryParams
						.get("subDetailId"))) {
			if (!"0".equals((String) queryParams.get("subDetailId"))) {
				cw.putCondition("cw.subjectdetailid", Expression.OP_EQ,
						queryParams.get("subDetailId"));
			}
		}
		if (queryParams.containsKey("schoolId")
				&& StringUtils.isNotEmpty((String) queryParams
						.get("schoolId"))) {
			if (!"0".equals((String) queryParams.get("schoolId"))) {
				cw.putCondition("cw.schoolId", Expression.OP_EQ,
						queryParams.get("schoolId"));
			}
		}
		cw.addOrders("waterdate", "desc");
		CampusWater cwResult = finBuzz.getList(new CampusWaterDto(cw));
		return JsonUtils.bean2Json(cwResult);
	}

	@RequestMapping(value = "fin/{fid}.do", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable("fid") Long fid) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		finBuzz.delete(fid);

		result.put("flag", true);
		result.put("msg", "success");

		return JsonUtils.bean2Json(result);
	}
	
	@FormToken(save=true)
	@RequestMapping(value = "water.do", method = RequestMethod.GET)
	public String addFilling(Model model, HttpSession session) throws Exception {
		CampusWaterDto cw = new CampusWaterDto();
		cw.setSchoolId(((Emp) (session.getAttribute(SessionUtils.LOGIN_EMP_KEY)))
				.getSchoolDistrict());
		model.addAttribute("waterForm", cw);
		model.addAttribute("subs", finBuzz.getSubsList());
		model.addAttribute("subDetails", finBuzz.getSubDetailsList(1l));
		return "financeResources/water";
	}
	
	@FormToken(remove=true)
	@RequestMapping(value = "water.do", method = RequestMethod.POST)
	@ResponseBody
	public String add(@RequestBody CampusWaterDto cw) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		finBuzz.add(cw);
		result.put("flag", true);
		result.put("msg", "添加成功");
		return JsonUtils.bean2Json(result);
	}

	@RequestMapping(value = "fin/{fid}.do", method = RequestMethod.GET)
	public String getById(@PathVariable("fid") Long fid, Model model)
			throws Exception {
		CampusWater cw = finBuzz.getById(fid);
		CampusWaterDto cwd = new CampusWaterDto(cw);
		model.addAttribute("waterForm", cwd);
		model.addAttribute("subs", finBuzz.getSubsList());
		model.addAttribute("subDetails",
				finBuzz.getSubDetailsList(cwd.getSubIdDto()));
		return "financeResources/water";
	}
	
	@RequestMapping(value = "water.do", method = RequestMethod.PUT)
	@ResponseBody
	public String update(@RequestBody CampusWaterDto cwd) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		finBuzz.update(cwd);
		result.put("flag", true);
		result.put("msg", "修改成功");
		return JsonUtils.bean2Json(result);
	}

	// ------------------------------------------以上是校区流水的模块--------------------------------------------------
	@RequestMapping(value = "financial.do", method = RequestMethod.PUT)
	@ResponseBody
	public String updateFin(@RequestBody Financial fin) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		finBuzz.updateFin(fin);
		result.put("flag", true);
		result.put("msg", "修改成功");
		return JsonUtils.bean2Json(result);
	}
	
	@RequestMapping(value = "financial/{fid}.do", method = RequestMethod.GET)
	public String getFinById(@PathVariable("fid") Long fid, Model model)
			throws Exception {
		Financial fin = finBuzz.getFinById(fid);
		fin.setFinSubDetIdDto(fin.getFinSubDetId().getFinSubDetailId());
		model.addAttribute("finemps", finBuzz.getFinEmps());
		model.addAttribute("finForm", fin);
		model.addAttribute("subs", finBuzz.getFinSubsList());
		model.addAttribute("subDetails",
				finBuzz.getFinSubDetailsList(fin.getFinSubjectId().getFinSubjectId()));
		return "financeResources/fin";
	}
	
	@RequestMapping(value = "financial/{fid}.do", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteFin(@PathVariable("fid") Long fid) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		finBuzz.deleteFin(fid);
		result.put("flag", true);
		result.put("msg", "success");

		return JsonUtils.bean2Json(result);
	}
	
	@RequestMapping(value = "financial.do", method = RequestMethod.GET)
	public String getFinPage(Model model,BaseQuery bq) throws Exception {
		model.addAttribute("fins", bq);
		return "financeResources/fins";
	}
	//获取所有流水
	@RequestMapping(value="getFinsList.do",method=RequestMethod.POST)
	@ResponseBody
	public String getFinsList(@RequestBody BaseQuery bq) throws Exception{
		Map<String, Object> queryParams = bq.getQueryParams();
		if (queryParams.containsKey("applyUser")
				&& StringUtils.isNotEmpty((String) queryParams.get("applyUser"))) {
			bq.putCondition("applyUser", Expression.OP_LIKE,
					"%" + queryParams.get("applyUser") + "%");
		}
		if (queryParams.containsKey("finStatus")
				&& StringUtils.isNotEmpty((String) queryParams.get("finStatus"))) {
			bq.putCondition("finStatus", Expression.OP_EQ,
					queryParams.get("finStatus"));
		}
		
		BaseQuery bqResult = finBuzz.getFinsList(bq);
		return JsonUtils.bean2Json(bqResult);
	}
	
	//跳转添加页面
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String getFinancialPage(Model model, HttpSession session) throws Exception {
		Financial f = new Financial();
		model.addAttribute("finemps", finBuzz.getFinEmps());
		model.addAttribute("finForm", f);
		model.addAttribute("subs", finBuzz.getFinSubsList());
		model.addAttribute("subDetails", finBuzz.getFinSubDetailsList(1l));
		return "financeResources/fin";
	}

	//添加财务申请
	@RequestMapping(value = "financial.do", method = RequestMethod.POST)
	@ResponseBody
	public String addFin(@RequestBody Financial fin) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		finBuzz.addFin(fin);
		result.put("flag", true);
		result.put("msg", "添加成功");
		return JsonUtils.bean2Json(result);
	}

	@RequestMapping(value = "exp.do", method = RequestMethod.GET)
	@ResponseBody
	public String exp() throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		List<CampusWater> cws = finBuzz.getExpList(new CampusWater());
		// 导出
		ExcelUtil.exp(cws);

		result.put("flag", true);
		result.put("msg", "导出成功！请看目录：C:\\financial.xls");
		return JsonUtils.bean2Json(result);
	}

	// 文件上传
	@RequestMapping(value = "myfileupload/{id}.do")
	@ResponseBody
	public String myfile(@PathVariable("id") long id,
			@RequestParam MultipartFile[] myfiles, HttpServletRequest request)
			throws Exception {
		String realPath = request.getSession().getServletContext()
				.getRealPath("/upload");
		String originalFilename = null;
		for (MultipartFile myfile : myfiles) {
			if (myfile.isEmpty()) {
				return "请选择文件后上传";
			} else {
				// uuid修改文件名
				UUID uuid = UUID.randomUUID();
				originalFilename = myfile.getOriginalFilename();
				// 判断是否有中文？
				Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
				Matcher m = p.matcher(originalFilename);
				if (m.find()) {
					originalFilename = "zw";
				}
				// 查看现在billpath
				String billpath = finBuzz.getCurrentBillPath(id);

				CampusWater cw = new CampusWater();
				cw.setWaterId(id);
				// 改billPath
				if (billpath == null || "".equals(billpath.trim())) {
					cw.setBillPath(uuid + "_" + originalFilename);
				} else {
					cw.setBillPath(uuid + "_" + originalFilename + ";"
							+ billpath);
				}
				try {
					// 复制文件
					FileUtils.copyInputStreamToFile(myfile.getInputStream(),
							new File(realPath, uuid + "_" + originalFilename));
					// 如果没问题再改票据
					finBuzz.updateBillPath(cw);
				} catch (IOException e) {
					e.printStackTrace();
					return "文件上传失败，请重试";
				}
			}
		}
		return "ok";
	}
	
	//---------------------------------
	@RequestMapping(value = "sp/{fid}.do", method = RequestMethod.GET)
	public String gotoSP(@PathVariable("fid") Long fid, Model model)
			throws Exception {
		Financial fin = finBuzz.getFinById(fid);
		fin.setFinSubDetIdDto(fin.getFinSubDetId().getFinSubDetailId());
		model.addAttribute("finForm", fin);
		model.addAttribute("subs", finBuzz.getFinSubsList());
		model.addAttribute("subDetails",
				finBuzz.getFinSubDetailsList(fin.getFinSubjectId().getFinSubjectId()));
		return "financeResources/sp";
	}
	@RequestMapping(value = "sp.do", method = RequestMethod.PUT)
	@ResponseBody
	public String updateSP(@RequestBody Financial fin) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		finBuzz.updateSP(fin);
		result.put("flag", true);
		result.put("msg", "审批成功");
		return JsonUtils.bean2Json(result);
	}
	//=======
	@RequestMapping(value = "zbbk/{fid}.do", method = RequestMethod.GET)
	public String gotoBK(@PathVariable("fid") Long fid, Model model)
			throws Exception {
		Financial fin = finBuzz.getFinById(fid);
		model.addAttribute("finForm", fin);
		return "financeResources/zbbk";
	}
	@RequestMapping(value = "zbbk.do", method = RequestMethod.PUT)
	@ResponseBody
	public String updateBK(@RequestBody Financial fin) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		finBuzz.updateBK(fin);
		result.put("flag", true);
		result.put("msg", "拨款成功");
		return JsonUtils.bean2Json(result);
	}
}
