package actionclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		Actions act = new Actions(driver);
		WebElement source = driver.findElement(By.id("box1"));
		WebElement target = driver.findElement(By.id("box101"));
		
		act.clickAndHold(source).moveToElement(target).release().build().perform();
		Thread.sleep(3000);
		WebElement source2 = driver.findElement(By.id("box3"));
		WebElement target2 = driver.findElement(By.id("box106"));
		act.dragAndDrop(source2, target2).build().perform();
		driver.close();
	}

}
