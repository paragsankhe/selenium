package downloadfiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadfilesonChrome {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
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
		System.out.println("Text file downloaded ");

		driver.close();

	}

}
