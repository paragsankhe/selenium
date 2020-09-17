//cookies are created in browser to hold specific information of webapp /website 
// Created at client side 

/*1. Get all cookies               > driver.manage().getCookies();
2. Get size of cookies           > 
3. Print cookie name and values  >
4. Print cookie based on name    > driver.manage().getCookieNamed(arg0);
5. Delete specific cookie        > driver.manage().deleteCookie(arg0);
6. Delete all cookies            > driver.manage().deleteAllCookies(arg0);
7. Add cookie in browser         > driver.manage().addCookie(arg0);


*/

package cookiestest;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("cookies size is " + cookies.size()); // get size of cookies

		// print all cookie name and values
		for (Cookie cookie : cookies) {

			System.out.println("cookie name is " + cookie.getName() + ": " + "cookie value is " + cookie.getValue());
		}

		// print cookie based on name
		System.out.println("session id is " + driver.manage().getCookieNamed("session-id"));

		// Adding cookie in browser
		Cookie mycookie1 = new Cookie("Mycookiename", "12312313");
		driver.manage().addCookie(mycookie1);

		Set<Cookie> cookiesnew = driver.manage().getCookies();
		System.out.println("cookies size is " + cookiesnew.size());

		// print all cookie name and values
		for (Cookie cookie : cookiesnew) {

			System.out.println("cookie after adding new cookie " + cookie.getName() + ": " + "cookie value is "
					+ cookie.getValue());
		}
		System.out.println("cookies size is after adding " + cookiesnew.size()); // get size of cookies

		driver.manage().deleteCookieNamed("session-id");
		Set<Cookie> cookiesdeleted = driver.manage().getCookies();
		System.out.println("one cookie deleted and now size is " + cookiesdeleted.size());

		// print all cookie name and values
		for (Cookie cookie : cookiesdeleted) {

			System.out.println("cookie name is " + cookie.getName() + ": " + "cookie value is " + cookie.getValue());
		}

		// delete all cookies

		driver.manage().deleteAllCookies();
		Set<Cookie> cookiesdeletedall = driver.manage().getCookies();
		System.out.println("ALl deleted and size is " + cookiesdeletedall.size());

		Thread.sleep(5000);
		driver.quit();

	}

}
