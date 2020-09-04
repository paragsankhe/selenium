/*
1.Create firefoxprofile using FirefoxProfile() object 
2.set preferences for not asking save to disk with mime types (files which needs to be downloaded)
3.Set show when starting download false 
4. FirefoxOption object create and set profle 
5. Pass option in webdriver onstance 


*/


package downloadfiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadFilesFirefox {

	public static void main(String[] args) {
		
		
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/plain,application/pdf"); //MIME type 
		profile.setPreference("browser.download.manager.showWhenStarting",false); 
		profile.setPreference("pdfjs.disabled",true);  // only for pdf 
		
		FirefoxOptions option = new FirefoxOptions();
		option.setProfile(profile);
		
		
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(option);
		driver.get("http://demo.automationtesting.in/FileDownload.html");

		driver.findElement(By.xpath("//textarea[@id='textbox']")).sendKeys("sdadsad");
		driver.findElement(By.xpath("//button[@id='createTxt']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("link-to-download")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("Text file downloaded ");

		driver.findElement(By.xpath("//textarea[@id='pdfbox']")).sendKeys("sdadsad");
		driver.findElement(By.xpath("//button[@id='createPdf']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("pdf-link-to-download")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("PDF file downloaded ");

		driver.quit();

	}

}
