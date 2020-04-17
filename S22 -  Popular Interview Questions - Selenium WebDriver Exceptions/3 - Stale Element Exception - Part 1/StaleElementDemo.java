package interviewquestions;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementDemo {
	
	@Test
	public void testMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/atomar/Documents/workspace_personal/libs/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://learn.letskodeit.com/p/practice");
		
		driver.get(driver.getCurrentUrl());
		WebElement checkboxElement = driver.findElement(By.id("bmwcheck"));
		checkboxElement.click();
	}
}