package com.hotmarzz.oa.buzz;

import java.util.List;

import com.hotmarzz.oa.dto.CampusWaterDto;
import com.hotmarzz.oa.pojo.CampusWater;
import com.hotmarzz.oa.pojo.FinSubject;
import com.hotmarzz.oa.pojo.FinSubjectDetail;
import com.hotmarzz.oa.pojo.Financial;
import com.hotmarzz.oa.pojo.Subject;
import com.hotmarzz.oa.pojo.SubjectDetail;

public interface FinanceBuzz {

	/**
	 * 获取所有科目
	 * @return
	 * @throws Exception
	 */
	List<Subject> getSubsList() throws Exception;
	
	/**
	 * 获取对应的明细科目
	 * @return
	 * @throws Exception
	 */
	List<SubjectDetail> getSubDetailsList(Long subId) throws Exception;
	/**
	 * 获取总收入
	 * @return
	 * @throws Exception
	 */
	Double getSumIncome(String formatDate) throws Exception;
	/**
	 * 获取总支出
	 * @return
	 * @throws Exception
	 */
	Double getSumExpenditure(String formatDate) throws Exception;
	/**
	 * 分页获取校区流水信息
	 * @param cw
	 * @return
	 * @throws Exception
	 */
	CampusWater getList(CampusWater cw) throws Exception;
	/**
	 * 导出excel
	 * @param cw
	 * @return
	 * @throws Exception
	 */
	List<CampusWater> getExpList(CampusWater cw) throws Exception;
	/**
	 * 删除流水信息
	 * @param fid
	 * @throws Exception
	 */
	void delete(Long fid) throws Exception;
	/**
	 * 流水添加
	 * @param cw
	 * @throws Exception
	 */
	void add(CampusWaterDto cw) throws Exception;
	/**
	 * 根据ID获取流水信息
	 * @param wid
	 * @return
	 * @throws Exception
	 */
	CampusWater getById(Long wid) throws Exception;
	/**
	 * 修改流水信息
	 * @param cwd
	 * @throws Exception
	 */
	void update(CampusWaterDto cwd) throws Exception;
	/**
	 * 获取今年的总收入
	 * @return
	 * @throws Exception
	 */
	Double getCurrentYearWaterSum(Long schoolId) throws Exception;
	/**
	 * 获取财务申请的科目
	 * @return
	 * @throws Exception
	 */
	List<FinSubject> getFinSubsList() throws Exception;
	/**
	 * 获取财务申请的科目明细
	 * @param subId
	 * @return
	 * @throws Exception
	 */
	List<FinSubjectDetail> getFinSubDetailsList(Long subId) throws Exception;
	
	void addFin(Financial fin) throws Exception;
	/**
	 * 修改对应流水的票据内容
	 * @param id
	 * @param billpath
	 * @throws Exception
	 */
	void updateBillPath(CampusWater cw) throws Exception;
	/**
	 * 获取当前的流水票据内容
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String getCurrentBillPath(Long id) throws Exception;
}
