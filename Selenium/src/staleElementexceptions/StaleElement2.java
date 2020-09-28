package staleElementexceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StaleElement2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://affiliate.flipkart.com/login");
		Thread.sleep(3000);

		WebElement email = driver.findElement(By.id("inputEmail"));
		WebElement password = driver.findElement(By.id("inputPassword"));
		
		email.sendKeys("asdadasd");
		password.sendKeys("passwrd");
		
		driver.navigate().refresh();
		
		
		try {
		email.sendKeys("asdadasd");
		password.sendKeys("passwrd");
		}catch(StaleElementReferenceException e) {
			
			 email = driver.findElement(By.id("inputEmail"));
			 password = driver.findElement(By.id("inputPassword"));
			email.sendKeys("asdadasd");
			password.sendKeys("passwrd");
			
		}
		System.out.println("again clicked");
		driver.close();

	}

}
