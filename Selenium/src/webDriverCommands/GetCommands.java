/*ddasdas

WebDriver Get commands :

Get commands : 
1. get()   // open url in browser 
2. getTitle() 
3. getPageSource()
4. getCurrentURL()
5. getText()  // get text of webelement 

Browser commands : 
1. close()       // close ONLY current window/browser 
2. quit()        // close all windows // all instances 


*/

package webDriverCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCommands {
	

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		System.out.println(driver.getTitle()); // get title of page
		System.out.println(driver.getCurrentUrl()); // get url of page
	//	System.out.println(driver.getPageSource()); 
		System.out.println(driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']")).getText());
		System.out.println();
		driver.close();

	}

}
