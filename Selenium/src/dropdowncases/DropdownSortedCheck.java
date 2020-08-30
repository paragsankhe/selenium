/*Verifying if all elements in dropdown are sorted or not 

Logic :
	1.Create two lists (original and temp)
	2.Store all values of dropdown in both lists 
	3.Sort templist 
	4.Compare origlist and templist
	
	Note: Dont assign temp to origlist , as if temp is sorted then origlist also gets sorted . 
*/

package dropdowncases;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownSortedCheck {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.id("animals")); // identify and store dropdwn webelement.
		Select animaldropdown = new Select(element); // Create Select object for dropdown elements

		List origlist = new ArrayList(); // create original list
		List templist = new ArrayList();

		List<WebElement> options = animaldropdown.getOptions(); // store all dropdwn options webelements in list

		for (WebElement i : options) { // add all values in original list

			origlist.add(i.getText());
			templist.add(i.getText());

		}
		System.out.println("Original before sort List is");
		System.out.println(origlist);
		System.out.println("Temp List before sort is");
		System.out.println(templist);

		driver.close();

		Collections.sort(templist);

		System.out.println("Original After sort List is");
		System.out.println(origlist);
		System.out.println("Temp List After sort is");
		System.out.println(templist);

		if (origlist == templist) {

			System.out.println("Dropdown is sorted");
		}

		else {

			System.out.println("Dropdown is not sorted");
		}

	}

}
