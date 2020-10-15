/*Limitations of AutoIT 
1.Only windows automation  / Not for Mac and linux
2.Too many steps : download install. finder and editor , write a script then exe execute . 

Sikuli : Jar file 
use pattern class 
Easy to use / all environments 

*/

package sikuliFileuploadDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliFileupload {

	public static void main(String[] args) throws InterruptedException, FindFailed {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\Driversnew\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Thread.sleep(3000);

		Actions act = new Actions(driver);
		WebElement PIM = driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a/b"));
		WebElement AddEmployee = driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]"));

		act.moveToElement(PIM).click().build().perform();
		Thread.sleep(3000);
		try {
			act.moveToElement(AddEmployee).click().build().perform();
		} catch (StaleElementReferenceException e) {
			WebElement AddEmployeenew = driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]"));

			AddEmployeenew.click();
		}
		Thread.sleep(2000);
		System.out.println("choosefile not clickedddddd");

		try {
			act.moveToElement(driver.findElement(By.xpath("//*[@id=\"photofile\"]"))).click().build().perform();

			System.out.println("choosefileclickedddddd");
		} catch (InvalidArgumentException e) {

			driver.findElement(By.xpath("//*[@id=\"photofile\"]")).click();
		}
		Thread.sleep(2000);

		String Fileopenimagepath = "C:\\Users\\HAP\\git\\selenium\\Selenium\\SikuliImages\\Fileopen.PNG";
		String Openbtnimagepath = "C:\\Users\\HAP\\git\\selenium\\Selenium\\SikuliImages\\Openbtn.PNG";

		String Filetouploadpath = "C:\\Users\\HAP\\git\\selenium\\Selenium\\SikuliImages\\EmployeeImage.PNG";

		Screen s = new Screen();

		Pattern fileinputboxpattern = new Pattern(Fileopenimagepath);
		Pattern openbttnpattern = new Pattern(Openbtnimagepath);

		Thread.sleep(5000);

		s.wait(fileinputboxpattern, 20);
		s.type(fileinputboxpattern, Filetouploadpath);
		s.click(openbttnpattern);

		driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		driver.quit();

	}

}
