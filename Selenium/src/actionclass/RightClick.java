package actionclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		Actions act = new Actions(driver);
		WebElement clickMe = driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));
		
		WebElement cut = driver.findElement(By.xpath("/html/body/ul/li[2]/span"));
		
		act.contextClick(clickMe).build().perform();
		cut.click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
        Thread.sleep(3000);
driver.close();
	}

}
