package webtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Thread.sleep(3000);

		WebElement PIM = driver.findElement(By.id("menu_pim_viewPimModule"));
		PIM.click();
		WebElement employeelist = driver.findElement(By.id("menu_pim_viewEmployeeList"));
		employeelist.click();

		// find num of rows
		int numrows = driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr")).size();
		System.out.println("Num of rows " + numrows);

		// find num of columns
		int numcols = driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td")).size();
		System.out.println("Num of cols " + numcols);

		// print all first and lastnames data

		for (int i = 1; i <= numrows; i++) {

			System.out.print(
					driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[" + i + "]/td[3]/a")).getText());
			System.out.print(
					driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[" + i + "]/td[4]/a")).getText());
			System.out.println("  ");
			System.out.println();

		}
		
		driver.close();

	}

}
