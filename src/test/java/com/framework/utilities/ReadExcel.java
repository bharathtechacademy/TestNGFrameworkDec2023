package com.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static String [][] readData(String workbook, String sheet){
		String [][] data = null;
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+workbook); 
			XSSFWorkbook wb = new XSSFWorkbook(fis); //Read Excel
			XSSFSheet sh = wb.getSheet(sheet); //Get the specific sheet from Excel workbook
			int totalRows = sh.getPhysicalNumberOfRows();
			int totalCols = sh.getRow(0).getPhysicalNumberOfCells();
			data = new String [totalRows][totalCols];
			
			for(int r=1; r < totalRows ; r++) {
				for(int c=0; c<totalCols ; c++) {
					data[r-1][c] = sh.getRow(r).getCell(c).getStringCellValue();
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return data;		
	}
}
