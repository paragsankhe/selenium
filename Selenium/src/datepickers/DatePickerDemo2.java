package datepickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com");

		String day = "10";
		String month = "March";
		
		WebElement checkin = driver.findElement(By.xpath("//div[@class='fsw_inputBox dates inactiveWidget']"));

		checkin.click();
		Thread.sleep(2000);
		
		WebElement titlecalender = driver
				.findElement(By.xpath("//div[@class='DayPicker-Caption']"));
		String Monthname = titlecalender.getText();
		System.out.print(Monthname);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
