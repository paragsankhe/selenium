/* 
 * Stale element : Old, stale 
 * Page refresh,navigation,ajax call >>DOM changes >>
 * 
 * How to handle 
 * Try catch >> in catch block again find element and click it 

 * 
*/

package staleElementexceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StaleElement1navigation {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		Thread.sleep(3000);

		WebElement gmail = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div[1]/div[1]/a"));
		gmail.click();
		Thread.sleep(3000);
		driver.navigate().back();

		try {
			gmail.click();

		} catch (StaleElementReferenceException e) {

			gmail = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div[1]/div[1]/a"));
			gmail.click();
		}

		driver.close();

	}

}
