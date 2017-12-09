package com.hotmarzz.oa.utils;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import com.hotmarzz.oa.pojo.CampusWater;

public class ExcelUtil {
	private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);
	public static String NO_DEFINE = "no_define";//未定义的字段
    public static String DEFAULT_DATE_PATTERN="yyyy年MM月dd日";//默认日期格式
    //public static int DEFAULT_COLOUMN_WIDTH = 30;
    public static int MIN_COLUMN_WIDTH = 2000;
    /**
     * 导出Excel 97(.xls)格式 ，少量数据
     * @param title 标题行 
     * @param headMap 属性-列名
     * @param jsonArray 数据集
     * @param datePattern 日期格式，null则用默认日期格式
     * @param colWidth 列宽 默认 至少17个字节
     * @param out 输出流
     */
    public static HSSFWorkbook exportExcel(String title,Map<String, String> headMap,List<?> datas,String datePattern,int colWidth) {
        
    	if(datePattern==null) datePattern = DEFAULT_DATE_PATTERN;
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        workbook.createInformationProperties();
        workbook.getDocumentSummaryInformation().setCompany("*****公司");
        SummaryInformation si = workbook.getSummaryInformation();
        si.setAuthor("JACK");  //填加xls文件作者信息
        si.setApplicationName("导出程序"); //填加xls文件创建程序信息
        si.setLastAuthor("最后保存者信息"); //填加xls文件最后保存者信息
        si.setComments("JACK is a programmer!"); //填加xls文件作者信息
        si.setTitle("POI导出Excel"); //填加xls文件标题信息
        si.setSubject("POI导出Excel");//填加文件主题信息
        si.setCreateDateTime(new Date());
         //表头样式
        HSSFCellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 20);
        titleFont.setBoldweight((short) 700);
        titleStyle.setFont(titleFont);
        // 列头样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerStyle.setFont(headerFont);
        // 单元格样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        HSSFFont cellFont = workbook.createFont();
        cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        cellStyle.setFont(cellFont);
        // 生成一个(带标题)表格
        HSSFSheet sheet = workbook.createSheet();
        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
                0, 0, 0, (short) 4, 2, (short) 6, 5));
        // 设置注释内容
        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
        comment.setAuthor("JACK");
        //设置列宽
        //int minBytes = colWidth<DEFAULT_COLOUMN_WIDTH?DEFAULT_COLOUMN_WIDTH:colWidth;//至少字节数
        int[] arrColWidth = new int[headMap.size()];
        // 产生表格标题行,以及设置列宽
        String[] properties = new String[headMap.size()];
        String[] headers = new String[headMap.size()];
        int ii = 0;
        for (Iterator<String> iter = headMap.keySet().iterator(); iter
                .hasNext();) {
            String fieldName = iter.next();

            properties[ii] = fieldName;
            headers[ii] = fieldName;

//            int bytes = fieldName.getBytes().length;
//            arrColWidth[ii] =  bytes < minBytes ? minBytes : bytes;
//            sheet.setColumnWidth(ii,arrColWidth[ii]*256);
            ii++;
        }
        // 遍历集合数据，产生数据行
        int rowIndex = 0;
        for (Object obj : datas) {
            if(rowIndex == 65535 || rowIndex == 0){
                if ( rowIndex != 0 ) sheet = workbook.createSheet();//如果数据超过了，则在第二页显示

                HSSFRow titleRow = sheet.createRow(0);//表头 rowIndex=0
                titleRow.createCell(0).setCellValue(title);
                titleRow.getCell(0).setCellStyle(titleStyle);
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headMap.size() - 1));

                HSSFRow headerRow = sheet.createRow(1); //列头 rowIndex =1
                for(int i=0;i<headers.length;i++)
                {
                    headerRow.createCell(i).setCellValue(headers[i]);
                    headerRow.getCell(i).setCellStyle(headerStyle);

                }
                rowIndex = 2;//数据内容从 rowIndex=2开始
            }

            HSSFRow dataRow = sheet.createRow(rowIndex);
            for (int i = 0; i < properties.length; i++)
            {
                HSSFCell newCell = dataRow.createCell(i);
                BeanWrapper bw = new BeanWrapperImpl(obj);
                if(bw.isReadableProperty(properties[i])){
                	
                	Object o =  bw.getPropertyValue(properties[i]);
                	String cellValue = ""; 
                	if(o==null){
                		cellValue = "";
                	}else if(o instanceof Date){
                		logger.debug(o.toString());
                		cellValue = new SimpleDateFormat(datePattern).format(o);
                	}else if(o instanceof Float || o instanceof Double){
                		cellValue= new BigDecimal(o.toString()).setScale(2,BigDecimal.ROUND_HALF_UP).toString();
                	}else{
                		cellValue = o.toString();
                	}
                	
                	newCell.setCellValue(cellValue);
                	newCell.setCellStyle(cellStyle);
                }
               
            }
            rowIndex++;
        }
        
        // 自动调整宽度
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
            if(sheet.getColumnWidth(i)<MIN_COLUMN_WIDTH){
            	sheet.setColumnWidth(i, MIN_COLUMN_WIDTH);
            }
        }
        return workbook;
    }
    /**
     * 导出Excel 2007 OOXML (.xlsx)格式
     * @param title 标题行
     * @param headMap 属性-列头
     * @param jsonArray 数据集
     * @param datePattern 日期格式，传null值则默认 年月日
     * @param colWidth 列宽 默认 至少17个字节
     * @param out 输出流
     */
    public static SXSSFWorkbook exportExcelX(String title,Map<String, String> headMap,List<?> datas,String datePattern,int colWidth) {
        if(datePattern==null) datePattern = DEFAULT_DATE_PATTERN;
        // 声明一个工作薄
        SXSSFWorkbook workbook = new SXSSFWorkbook(1000);//缓存
        workbook.setCompressTempFiles(true);
         //表头样式
        CellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        Font titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 20);
        titleFont.setBoldweight((short) 700);
        titleStyle.setFont(titleFont);
        // 列头样式
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerStyle.setFont(headerFont);
        // 单元格样式
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        Font cellFont = workbook.createFont();
        cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        cellStyle.setFont(cellFont);
        // 生成一个(带标题)表格
        SXSSFSheet sheet = workbook.createSheet();
        // 产生表格标题行,以及设置列宽
        String[] properties = new String[headMap.size()];
        String[] headers = new String[headMap.size()];
        int ii = 0;
        for (Iterator<String> iter = headMap.keySet().iterator(); iter
                .hasNext();) {
            String fieldName = iter.next();

            properties[ii] = fieldName;
            headers[ii] = headMap.get(fieldName);
            ii++;
        }
        // 遍历集合数据，产生数据行
        int rowIndex = 0;
        for (Object obj : datas) {
            if(rowIndex == 65535 || rowIndex == 0){
                if ( rowIndex != 0 ) sheet = workbook.createSheet();//如果数据超过了，则在第二页显示

                SXSSFRow titleRow = sheet.createRow(0);//表头 rowIndex=0
                titleRow.createCell(0).setCellValue(title);
                titleRow.getCell(0).setCellStyle(titleStyle);
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headMap.size() - 1));

                SXSSFRow headerRow = sheet.createRow(1); //列头 rowIndex =1
                for(int i=0;i<headers.length;i++)
                {
                    headerRow.createCell(i).setCellValue(headers[i]);
                    headerRow.getCell(i).setCellStyle(headerStyle);

                }
                rowIndex = 2;//数据内容从 rowIndex=2开始
            }
            SXSSFRow dataRow = sheet.createRow(rowIndex);
            for (int i = 0; i < properties.length; i++)
            {
                SXSSFCell newCell = dataRow.createCell(i);
                
                BeanWrapper bw = new BeanWrapperImpl(obj);
                if(bw.isReadableProperty(properties[i])){
                	
                	Object o =  bw.getPropertyValue(properties[i]);
                	String cellValue = ""; 
                	if(o==null){
                		cellValue = "";
                	}else if(o instanceof Date){
                		cellValue = new SimpleDateFormat(datePattern).format(o);
                	}else if(o instanceof Float || o instanceof Double){
                		cellValue= new BigDecimal(o.toString()).setScale(2,BigDecimal.ROUND_HALF_UP).toString();
                	}else{
                		if("sex".equals(properties[i])){
                			String sex = o.toString();
                			if("0".equals(sex)){
                				cellValue = "男";
                			}else{
                				cellValue = "女";
                			}
                    	}else{
                    		cellValue = o.toString();
                    	}
                	}
                	
                	newCell.setCellValue(cellValue);
                	newCell.setCellStyle(cellStyle);
                }
            }
            rowIndex++;
        }
        // 自动调整宽度
        for (int i = 0; i < headers.length; i++) {
        	sheet.trackAllColumnsForAutoSizing();
            sheet.autoSizeColumn(i);
            if(sheet.getColumnWidth(i)<MIN_COLUMN_WIDTH){
            	sheet.setColumnWidth(i, MIN_COLUMN_WIDTH);
            }
        }
        return workbook;
    }
	
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
