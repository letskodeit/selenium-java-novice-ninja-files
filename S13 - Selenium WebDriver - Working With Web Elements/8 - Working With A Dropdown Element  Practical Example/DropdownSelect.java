package workingwithelements;

import java.util.concurrent.TimeUnit;
import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelect {
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
	public void testDropdown() throws Exception {
		driver.get(baseUrl);
		WebElement element = driver.findElement(By.id("carselect"));
		Select sel = new Select(element);
		
		Thread.sleep(2000);
		System.out.println("Select Benz by value");
		sel.selectByValue("benz");

		Thread.sleep(2000);
		System.out.println("Select Honda by index");
		sel.selectByIndex(2);
		
		Thread.sleep(2000);
		System.out.println("Select BMW by visible text");
		sel.selectByVisibleText("BMW");
		
		Thread.sleep(2000);
		System.out.println("Print the list of all options");
		List<WebElement> options = sel.getOptions();
		int size = options.size();
		
		for (int i=0; i<size; i++) {
			String optionName = options.get(i).getText();
			System.out.println(optionName);
		}
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
