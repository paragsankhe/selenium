package dataDrivenCases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataInExcel {

	public static void main(String[] args) throws IOException {
		
		
		// it will create new or override existing file. 
		FileOutputStream file = new FileOutputStream("C://Users//HAP//Desktop//Tools//Automation//writedata.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");
		
		
		for (int i =0;i<4;i++) {
			
			XSSFRow row = sheet.createRow(i);
			
			for (int j=0;j<3;j++) {
				
				XSSFCell cell = row.createCell(j);
				cell.setCellValue("I will be in dream11");
			}
		}
		
		workbook.write(file);
		file.close();
		System.out.println("Data Written succesfully............");

	}

}
