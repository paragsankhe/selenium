package dataDrivenCases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataExcel2 {

	public static void main(String[] args) throws IOException {

		// it will create new or override existing file.
		FileOutputStream file = new FileOutputStream("C://Users//HAP//Desktop//Tools//Automation//writedata2.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");

		for (int i = 0; i < 4; i++) {

			XSSFRow row = sheet.createRow(i);

			XSSFCell useridcell = row.createCell(0);
			useridcell.setCellValue("UserID");

			XSSFCell username = row.createCell(1);
			username.setCellValue("UserNmae");

			XSSFCell intrate = row.createCell(2);
			intrate.setCellValue("Interets rate");

		}

		workbook.write(file);
		file.close();
		System.out.println("Data Written succesfully............");

	}

}
