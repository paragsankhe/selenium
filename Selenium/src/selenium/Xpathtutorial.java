package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpathtutorial {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HAP\\Desktop\\Tools\\Automation\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com");
	driver.findElementByXPath("//*[@class='inputtext _58mg _5dba _2ph-']//following::input[0]").sendKeys("psankhe777@gmail.com");
		Thread.sleep(2000);
		driver.close();
	}


}
