package interviewquestions;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NoSuchElementDemo {

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/atomar/Documents/workspace_personal/libs/chromedriver");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://learn.letskodeit.com";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		// 1. Timing Issues
		driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
		//WebElement emailField = driver.findElement(By.id("user_email"));
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement emailField = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
		emailField.sendKeys("testing");
		
		// 2. Incorrect locator or type of locator
		driver.findElement(By.xpath("//a[contains(@href,'/sign_in')]")).click();
		
		// 3. Element is in iFrame
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.switchTo().frame("courses-iframe");
		driver.findElement(By.id("search-courses")).sendKeys("Java");
		driver.switchTo().defaultContent();
	}
}