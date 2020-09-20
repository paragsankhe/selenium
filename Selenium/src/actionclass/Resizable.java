package actionclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Resizable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://strml.github.io/react-resizable/examples/1.html");

		Actions act = new Actions(driver);

	WebElement slider = driver.findElement(By.xpath("//*[@id=\'content\']/div/div/div[1]/span[2]"));
	
	act.moveToElement(slider).dragAndDropBy(slider, 0, 20).build().perform();
	Thread.sleep(3000);
	driver.quit();

	}

}
