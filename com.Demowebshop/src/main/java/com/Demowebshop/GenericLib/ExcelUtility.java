package com.Demowebshop.GenericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Ankita
 *
 */

public class ExcelUtility {

	/*
	 * this method will read the data from excel file
	 * @ String excelPath
	 * @ String sheetName
	 * @ int rowNo
	 * @ int cellNo
	 */
	
	public String readDataFromExcel(String excelPath,String sheetName,int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream f = new FileInputStream(excelPath);
		Workbook book = WorkbookFactory.create(f);
		Sheet sheet = book.getSheet(sheetName);
		return sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
	}
	
	
	/*
	 * this method will write the data to excel file
	 * @ String excelPath
	 * @ String sheetName
	 * @ String email
	 * @ String password
	 */
	
	public void writeLoginDetailsToExcel(String excelPath, String sheetName, String email, String password) throws EncryptedDocumentException, IOException
	{
		FileInputStream f = new FileInputStream(excelPath);
		Workbook book = WorkbookFactory.create(f);
		Sheet sheet = book.getSheet(sheetName);
		
		//Step 1 : To check if row is created. If not, then create row.
		Row row = sheet.getRow(1);
		 if (row == null) {
            row = sheet.createRow(1);
		 }
		
		//Step 2 : To set the email
		Cell cell1 = row.createCell(0);
		cell1.setCellValue(email);
		
		//Step 3 : To set the password
		Cell cell2 = row.createCell(1);
		cell2.setCellValue(password);
		
		FileOutputStream f1 = new FileOutputStream(excelPath);
		book.write(f1);
		book.close();
		
		System.out.println("Sent success");
	}
	
}
