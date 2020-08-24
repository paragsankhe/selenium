package dataDrivenCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
	
		
		FileInputStream file = new FileInputStream("C://Users//HAP//Desktop//Tools//Automation//myemployee.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
	//	XSSFSheet sheet = workbook.getSheet("getProduct_tomato"); // sheetname 
		XSSFSheet sheet = workbook.getSheetAt(0); 
		
		int rowcount = sheet.getLastRowNum(); //get row count 
		
		int columncount = sheet.getRow(0).getLastCellNum();
		
		//System.out.println(rowcount);
	//	System.out.println(columncount);
		
		for (int i=0;i<rowcount;i++) {
			
		XSSFRow currentrow= sheet.getRow(i); // focus on current row 
		
		for (int j=0;j<columncount;j++) {
			
			String value = currentrow.getCell(j).toString(); // get value from cell
			System.out.print(" "+value);
		}
		System.out.println(" ");
		}

	}

}
