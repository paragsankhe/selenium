/*

Scite.exe >>>editor 
AutoItInfo64.exe >>finder 


Useful to automate windows based elements 
ControlFocus("title","text","controlID") //Sets input focus to given control on window 
ControlSetText("title","text","controlID", "File path of upload ") //Sets text of control
ControlClick("title","text","controlID") //Sends mouseClick command 


class + instance = controlID
*/

package autoITexample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class AutoItFileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
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

		Actions act = new Actions(driver);
		WebElement PIM = driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a/b"));
		WebElement AddEmployee = driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]"));

		act.moveToElement(PIM).click().build().perform();
		Thread.sleep(3000);
		try {
		act.moveToElement(AddEmployee).click().build().perform();
		}catch(StaleElementReferenceException e) {
			WebElement AddEmployeenew = driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]"));

			AddEmployeenew.click();
		}
		Thread.sleep(2000);
		System.out.println("choosefile not clickedddddd");
		
		try {
			act.moveToElement(driver.findElement(By.xpath("//*[@id=\"photofile\"]"))).click().build().perform();
		
		System.out.println("choosefileclickedddddd");
		}catch (InvalidArgumentException e) {
			
			driver.findElement(By.xpath("//*[@id=\"photofile\"]")).click();
		}
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\HAP\\Desktop\\fileupload.exe");
		
		driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		driver.quit();

	}

}
