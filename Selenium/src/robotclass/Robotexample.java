/*Why Robot class?
- To use keyboard or mouse in tests to interact with Os download popup,print popup,alerts etc 
- webdriver cant handle OS level popups 
- Robot class are in built Java APIs 
- Other optios are Autoit
- eg robot.keyPress(KeyEvent.VK_DOWN) eg robot.keyPress(KeyEvent.VK_ENTER)

keyPress(): Example: robot.keyPress(KeyEvent.VK_DOWN) : This method with press down arrow key of Keyboard
mousePress() : Example : robot.mousePress(InputEvent.BUTTON3_DOWN_MASK) : This method will press the right click of your mouse.
mouseMove() : Example: robot.mouseMove(point.getX(), point.getY()) : This will move mouse pointer to the specified X and Y coordinates.
keyRelease() : Example: robot.keyRelease(KeyEvent.VK_DOWN) : This method with release down arrow key of Keyboard
mouseRelease() : Example: robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK) : This method will release the right click of your mouse

*/
package robotclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Robotexample {

	public static void main(String[] args) throws AWTException, InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://demo.automationtesting.in/FileDownload.html");

		driver.findElement(By.xpath("//textarea[@id='textbox']")).sendKeys("sdadsad");
		driver.findElement(By.xpath("//button[@id='createTxt']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("link-to-download")).click();
		Robot robot = new Robot();
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		System.out.println("down pressed");
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		System.out.println("Tabs pressed 3 times");
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		System.out.println("Enter pressed");
		Thread.sleep(4000);
		driver.close();

	}

}
