package datepickers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datepickerdemo1 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.phptravels.net");

		String day = "10";
		String month = "March";

		WebElement checkin = driver.findElement(By.xpath("//*[@id=\"checkin\"]"));

		checkin.click();
		Thread.sleep(2000);

		while (true) {

			WebElement titlecalender = driver
					.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[1]/nav/div[2]"));
			String Monthname = titlecalender.getText();
			System.out.print(Monthname);

			if (Monthname.contains(month)) {

				System.out.println("we are on january 20121 ");
				System.out.print(Monthname);

				WebElement date = driver.findElement(By
						.xpath("//div[@class='datepicker--cell datepicker--cell-day' and @data-date = '" + day + "']"));
				date.click();
				break;

			} else {

				WebElement arrow = driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[1]/nav/div[3]"));
				arrow.click();
			}
		}
		Thread.sleep(2000);
		driver.close();

	}

}
