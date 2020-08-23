package webDriverCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalCommands {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='pass']"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
		WebElement createAccountbtn = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		
		System.out.println(emailField.isDisplayed());         // returns true or false 
		System.out.println(passwordField.isDisplayed());
		System.out.println(emailField.isEnabled());
		System.out.println(passwordField.isEnabled());
				
	if (emailField.isDisplayed() && emailField.isEnabled() ) {
		
		emailField.sendKeys("psankhe777@gmail.com");
	}
	
	if (passwordField.isDisplayed() && passwordField.isEnabled() ) {
		
		passwordField.sendKeys("mypassword");
	}
		
	createAccountbtn.click();
	//	loginButton.click();
	//	driver.close();
	}
}
