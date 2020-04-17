package keypress;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPressDemo3 {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", 
				"/Users/atomar/Documents/workspace_personal/libs/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "https://letskodeit.teachable.com/p/practice";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testKeyPress() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}
}