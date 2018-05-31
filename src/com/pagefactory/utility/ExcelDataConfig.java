package com.pagefactory.utility;  

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ExcelDataConfig(String excelPath)
	{
		try
		{
			File src = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public String signIn(int sheetNumber, int row, int cloumn)
	{
		sheet1 = wb.getSheetAt(sheetNumber);
		String data = sheet1.getRow(row).getCell(cloumn).getStringCellValue();
		return data;
	}
}