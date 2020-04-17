package basicweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByNameDemo {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		String baseURL = httpslearn.letskodeit.comppractice;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		driver.findElement(By.name(enter-name)).sendKeys(Automation);
	}
}