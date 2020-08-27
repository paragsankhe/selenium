package dataDrivenCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MoneyControlCalculator {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true");

		FileInputStream file = new FileInputStream(
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\ExcelSheets\\MoneyControlData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int rowcount = sheet.getLastRowNum();
		System.out.println(rowcount);
		// int coulcount = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <= rowcount; i++) {

			XSSFRow currentrow = sheet.getRow(i);
			XSSFCell principlecell = currentrow.getCell(0);
			int principle = (int) principlecell.getNumericCellValue();

			XSSFCell roicell = currentrow.getCell(1);
			int roi = (int) roicell.getNumericCellValue();

			XSSFCell tenurecell = currentrow.getCell(2);
			int tenure = (int) tenurecell.getNumericCellValue();

			XSSFCell mvaluecell = currentrow.getCell(4);
			int mvalue = (int) mvaluecell.getNumericCellValue();

			driver.findElement(By.id("principal")).sendKeys(String.valueOf(principle));
			driver.findElement(By.id("interest")).sendKeys(String.valueOf(roi));
			driver.findElement(By.id("tenure")).sendKeys(String.valueOf(tenure));

			Select selectperiod = new Select(driver.findElement(By.id("tenurePeriod")));
			selectperiod.selectByValue("1");

			Select selectfreq = new Select(driver.findElement(By.id("frequency")));
			selectfreq.selectByValue("0");

			driver.findElement(
					By.xpath("//img[@src='https://img-d02.moneycontrol.co.in/images/mf_revamp/btn_calcutate.gif']"))
					.click();

			String actualmvalue = driver.findElement(By.xpath("//*[@id='resp_matval']/strong")).getText();

			if (Double.parseDouble(actualmvalue) == mvalue) {

				System.out.println("Test passed");
			}

			else {

				System.out.println("Test Failed");
				System.out.println("actualmvalue is" + actualmvalue);
				System.out.println("got mvalue is " + mvalue);
			}

			driver.findElement(By.xpath("//*[@id=\'fdMatVal\']/div[2]/a[2]/img")).click();

		}

		driver.close();
		driver.quit();

	}

}
