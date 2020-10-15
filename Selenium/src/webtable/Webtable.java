/*
table
- tbody
 -tr
  - th
  -th
  -th
 -tr
  -td
  -td
  -td
 -tr
 
 number of tr == number of rows 
 number of th Or td = number of columns 
 
 use for loop to get all data element from 2nd rows and all columns
 
 orange hrm >> user mangmt >> users 
 Check enabled users count
 
*/

package webtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable {

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

		WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
		admin.click();
		WebElement usermanagement = driver.findElement(By.id("menu_admin_UserManagement"));
		usermanagement.click();
		WebElement users = driver.findElement(By.id("menu_admin_viewSystemUsers"));
		users.click();

		// find num of rows
		int numrows = driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr")).size();
		System.out.println("Num of rows " + numrows);

		// find num of columns
		int numcols = driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td")).size();
		System.out.println("Num of cols " + numcols);

		// print all usernames data

		for (int i = 1; i <= numrows; i++) {

			System.out.println(
					driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[" + i + "]/td[2]/a")).getText());

		}

		int statuscount = 0;

		for (int i = 1; i <= numrows; i++) {

			String status = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[" + i + "]/td[5]"))
					.getText();
			if (status.equalsIgnoreCase("enabled")) {

				statuscount++;
			}

		}
		System.out.println("Enabled employes count is " + statuscount);
		driver.close();

	}

}
