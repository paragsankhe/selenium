/*How to find broken links : - dead link on web page :

	1.Incorrect URL entered by owner 
	2.Destination website removed the linked webpage (404 error
    3.Destn website permanently removed or no longer exists
   
    
    http://newtours.demoaut.com/
    
    
    Logic :
    1.Open web page,use sleep and wait to completely load the web page 
    2.capture and store all links webelement objects in List object,links with "a" tag
    3. Get URL in string format of each link by using href attribute 
    4. pass url to URL object of URL class
    5. Create a URL connection using HttpURLconnection : using URL object
    6. Get connection response code 
    7. Check if its above 400 then its broken link , else link is valid 
    
    
*/

package linkTestcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.haptik.ai");
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(5000);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are " + links.size());
		
		
		int invalidlinkscount = 0;
		int validlinkcount = 0 ;

		for (int i = 0; i < links.size(); i++) {

			String url = links.get(i).getAttribute("href");

			URL linkurl = new URL(url);

			// create connection using URL object
			HttpURLConnection httpConn = (HttpURLConnection) linkurl.openConnection();
			Thread.sleep(2000);
			// establish connection
			httpConn.connect();
			int respcode = httpConn.getResponseCode();

			if (respcode > 400) {

				System.out.println("Response code for " + url + respcode + "invalid link");
				invalidlinkscount++;
			}

			else {

				System.out.println("Response code for " + url + respcode + "valid link");
				validlinkcount++;
			}

			System.out.println("Valid links are " + validlinkcount);
			System.out.println("Valid links are " + invalidlinkscount);

		}

		driver.close();

	}

}
