package javascriptexecution;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptClick {
	private WebDriver driver;
	private JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", 
				"/Users/atomar/Documents/workspace_personal/libs/geckodriver");
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
//	@Test
//	public void testJSClick1() throws Exception {
//		driver.get("https://letskodeit.teachable.com/pages/practice");
//		Thread.sleep(3000);
//		
//		WebElement checkBoxElement = driver.findElement(By.id("bmwcheck"));
//		js.executeScript("arguments[0].click();", checkBoxElement);
//	}
	
	@Test
	public void testJSClick2() throws Exception {
		driver.get("https://www.retailmenot.com/");
		driver.findElement(By.xpath("//div[text()='Log In / Sign up']")).click();
		Thread.sleep(3000);
		
		WebElement checkBoxElement = driver.findElement(By.id("subscribe"));
		System.out.println("Displayed: " + checkBoxElement.isDisplayed());
		System.out.println("Selected: " + checkBoxElement.isSelected());
		
		//checkBoxElement.click();
		js.executeScript("arguments[0].click();", checkBoxElement);
	}
	
	
	
	@After
	public void tearDown() throws Exception {
	}
}