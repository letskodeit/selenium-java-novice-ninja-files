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

public class MultipleSelect {
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
	public void testMultiSelect() throws Exception {
		driver.get(baseUrl);
		WebElement element = driver.findElement(By.id("multiple-select-example"));
		Select sel = new Select(element);
		
		Thread.sleep(2000);
		System.out.println("Select orange by value");
		sel.selectByValue("orange");
		
		Thread.sleep(2000);
		System.out.println("De-select orange by value");
		sel.deselectByValue("orange");
		
		Thread.sleep(2000);
		System.out.println("Select peach by index");
		sel.selectByIndex(2);
		
		Thread.sleep(2000);
		System.out.println("Select Apple by visible text");
		sel.selectByVisibleText("Apple");
		
		Thread.sleep(2000);
		System.out.println("Print all selected options");
		List<WebElement> selectedOptions = sel.getAllSelectedOptions();
		for (WebElement option : selectedOptions) {
			System.out.println(option.getText());
		}
		
		Thread.sleep(2000);
		System.out.println("De-select all selected options");
		sel.deselectAll();
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}