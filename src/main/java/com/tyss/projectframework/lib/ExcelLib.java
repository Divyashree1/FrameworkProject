package com.tyss.projectframework.lib;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
public static String getdata(String sheet,int row,int cell,String filepath) {
	String val="";
	try {
		FileInputStream fin=new FileInputStream(filepath);
		Workbook wb= WorkbookFactory.create(fin);
		Cell c=wb.getSheet(sheet).getRow(row).getCell(cell);
		val=c.getStringCellValue();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return val;
}
}
