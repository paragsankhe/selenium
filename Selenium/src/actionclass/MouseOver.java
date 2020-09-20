/*dfgd
 * 
 * Action class : 
- handling special mouse events 
- It contains Actions and Action classes that are needed executing these events 

clickAndHold() --- click (without releasing) at current mouse loaction
contextClick() --- context click at current mouse loaction --Right click
doubleClick() ---- double click at current mouse loaction
dragAndDrop element by source,target) ---- clickAndhold > moveToElement > release();
dragAndDropBy(source, x-offset,y-offset)------ moves as per x and y offsets and then release 
moveToElement(toElement) ---- move the mouse to middle of element 
release() ------releaes mouse 

*/

package actionclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOver {

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

		// Mouse hover on admin >> usermanagemant >>click on users
		Actions act = new Actions(driver);
		WebElement admin = driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']"));
		WebElement usermanagemet = driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']"));
		WebElement user = driver.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers']"));

		/*
		 * act.moveToElement(admin).build().perform();
		 * act.moveToElement(usermanagemet).build().perform();
		 * act.moveToElement(usermanagemet).click().build().perform();
		 */
		act.moveToElement(admin).moveToElement(usermanagemet).moveToElement(usermanagemet).click().build().perform();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		Thread.sleep(3000);

		driver.quit();

	}

}
