/**
 * 
 */
package googlesearch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys("java");
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']/li/descendant::div[@class='sbl1']"));
		
		System.out.println(list.size());
		for (WebElement we : list) {
			
			System.out.println(we.getText());
			String actualresult = we.getText();
			if(actualresult.contains("java interview questions")) {
				
				we.click();
				Thread.sleep(2000);
				break;
			}
			
		}
		driver.quit();
	}

}
