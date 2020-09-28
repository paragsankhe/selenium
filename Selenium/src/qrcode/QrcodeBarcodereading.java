/*Import zxing jar

*/

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

public class QrcodeBarcodereading {

	public static void main(String[] args) throws IOException, NotFoundException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HAP\\git\\selenium\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		Thread.sleep(3000);
		String qcCodeurl = driver.findElement(By.xpath("//*[@id=\"HTML4\"]/div[1]/img")).getAttribute("src");

		URL url = new URL(qcCodeurl);

		BufferedImage bufferedimg = ImageIO.read(url);
		LuminanceSource luminancesource = new BufferedImageLuminanceSource(bufferedimg);

		BinaryBitmap binarybitmap = new BinaryBitmap(new HybridBinarizer(luminancesource));
		Result result = new MultiFormatReader().decode(binarybitmap);

		System.out.println(result.getText());

		driver.close();

	}

}
