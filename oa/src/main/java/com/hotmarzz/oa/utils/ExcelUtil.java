package com.hotmarzz.oa.utils;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.hotmarzz.oa.pojo.CampusWater;

public class ExcelUtil {

	public static void exp(List<CampusWater> cws) throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("财务表");
		sheet.setColumnWidth(2, 3500);
		sheet.setColumnWidth(4, 3500);
		sheet.setColumnWidth(5, 3500);
		sheet.setColumnWidth(6, 5000);
		sheet.setColumnWidth(7, 3500);
		
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		HSSFFont font = wb.createFont();    
		font.setFontName("黑体");    
		font.setFontHeightInPoints((short) 16);
		cellStyle.setFont(font);
		
		HSSFCellStyle cellStyle1 = wb.createCellStyle();
		cellStyle1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		HSSFFont font1 = wb.createFont();    
		font1.setFontName("黑体");    
		font1.setFontHeightInPoints((short) 11);
		cellStyle1.setFont(font1);
		
		
		HSSFRow row = sheet.createRow(0);
		row.setHeight((short) 1000);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("东方黑马" + cws.get(0).getSchoolId().getSchoolName()
				+ "校区流水");
		cell.setCellStyle(cellStyle);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));
		//第二行（提示信息行）
		HSSFRow rowinfo = sheet.createRow(1);
		rowinfo.createCell(0).setCellValue("校区");
		rowinfo.createCell(1).setCellValue("科目");
		rowinfo.createCell(2).setCellValue("科目明细");
		rowinfo.createCell(3).setCellValue("收支");
		rowinfo.createCell(4).setCellValue("流水批次");
		rowinfo.createCell(5).setCellValue("流水金额");
		rowinfo.createCell(6).setCellValue("备注");
		rowinfo.createCell(7).setCellValue("流水日期");
		rowinfo.createCell(8).setCellValue("经手人");
		rowinfo.setHeight((short) 500);
		for(int i=0;i<9;i++){
			rowinfo.getCell(i).setCellStyle(cellStyle1);
		}
		
		int i = 1;
		HSSFRow row1 = null;
		for (CampusWater c : cws) {
			i++;
			row1 = sheet.createRow(i);
			// 校区
			HSSFCell c0 = row1.createCell(0);
			c0.setCellValue(c.getSchoolId().getSchoolName());
			// 科目
			HSSFCell c1 = row1.createCell(1);
			c1.setCellValue(c.getSubId().getSubjectName());
			// 科目明细
			HSSFCell c2 = row1.createCell(2);
			c2.setCellValue(c.getSubDetailId().getSubjectDetailName());
			// 支出0/收入1
			HSSFCell c3 = row1.createCell(3);
			c3.setCellValue(c.getWaterType() == 0 ? "支出" : "收入");
			// 流水批次
			HSSFCell c4 = row1.createCell(4);
			c4.setCellValue(c.getWaterBanch());
			// 流水金额
			HSSFCell c5 = row1.createCell(5);
			c5.setCellValue(c.getWaterSum());
			// 备注
			HSSFCell c6 = row1.createCell(6);
			c6.setCellValue(c.getRemark());
			// 流水日期
			HSSFCell c7 = row1.createCell(7);
			c7.setCellValue(c.getWaterDate());
			// 经手人
			HSSFCell c8 = row1.createCell(8);
			c8.setCellValue(c.getBrokerage());
		}

		// 输出Excel文件
		FileOutputStream output = new FileOutputStream("c:\\financial.xls");
		wb.write(output);
		output.flush();
		output.close();
		wb.close();
	}

}
