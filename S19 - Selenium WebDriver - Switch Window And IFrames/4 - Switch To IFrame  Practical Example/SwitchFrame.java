package switchto;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchFrame {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws InterruptedException {
		Thread.sleep(3000);
		// Switch to frame by Id
		driver.switchTo().frame("courses-iframe");
		// Switch to frame by name
		//driver.switchTo().frame("iframe-name");
		// Switch to frame by numbers
		//driver.switchTo().frame(0);
		
		WebElement searchBox = driver.findElement(By.id("search-courses"));
		searchBox.sendKeys("python");
		
		driver.switchTo().defaultContent();
		Thread.sleep(6000);
		driver.findElement(By.id("name")).sendKeys("Test Successful");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(10000);
		driver.quit();
	}
}
