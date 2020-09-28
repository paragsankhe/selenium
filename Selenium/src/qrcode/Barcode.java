package qrcode;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class Barcode {

	public static void main(String[] args) throws InterruptedException, IOException, NotFoundException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		Thread.sleep(3000);
		String barCodeurl = driver.findElement(By.xpath("//*[@id=\"HTML12\"]/div[1]/img[1]")).getAttribute("src");

		URL url = new URL(barCodeurl);

		BufferedImage bufferedimg = ImageIO.read(url);
		LuminanceSource luminancesource = new BufferedImageLuminanceSource(bufferedimg);

		BinaryBitmap binarybitmap = new BinaryBitmap(new HybridBinarizer(luminancesource));
		Result result = new MultiFormatReader().decode(binarybitmap);

		System.out.println(result.getText());

		driver.close();

	}

}
