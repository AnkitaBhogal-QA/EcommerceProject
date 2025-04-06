package com.Demowebshop.GenericLib;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

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
	
}
