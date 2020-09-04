//We can use AutoIT,Sikuli and webdriver itself: directly pass username password 
//inject username password in URL 

// http://username:passowrd@the-internet.herokuapp.com/basic_auth

//String.equals compares the two string 
// if (message == expmsg) will return false as its object reference and its not same 

package authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopup {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		Thread.sleep(3000);
		String message = driver.findElement(By.xpath("/html/body/div[2]/div/div/p")).getText();
		String expmsg = "Congratulations! You must have the proper credentials.";

		if (message.equals(expmsg)) {

			System.out.println("Authentication successful");
		}

		else {

			System.out.println("Authentication Not successful");
		}

		driver.close();
	}

}
