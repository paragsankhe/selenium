package sikuliFileuploadDownload;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownload {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\Driversnew\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/FileDownload.html");

		driver.findElement(By.xpath("//textarea[@id='textbox']")).sendKeys("sdadsad");
		driver.findElement(By.xpath("//button[@id='createTxt']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("link-to-download")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(4000);

		if (isFileExist("C:\\Users\\HAP\\Downloads\\info.txt")) {

			System.out.println("File downloaded and exist on location");
		} else {

			System.out.println("File Not exist on location");
		}

		driver.findElement(By.xpath("//textarea[@id='pdfbox']")).sendKeys("sdadsad");
		driver.findElement(By.xpath("//button[@id='createPdf']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("pdf-link-to-download")).click();
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		if (isFileExist("C:\\Users\\HAP\\Downloads\\info.pdf")) {

			System.out.println("File downloaded and exist on location");
		} else {

			System.out.println("File Not exist on location");
		}

		driver.close();

	}

	static boolean isFileExist(String path) {

		File f = new File(path);
		if (f.exists()) {

			return true;
		} else {

			return false;
		}
	}

}
