package usefulmethods;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {
	WebDriver driver;
	
	public GenericMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(String locator, String type) {
		type = type.toLowerCase();
		if (type.equals("id")) {
			System.out.println("Element found with id: " + locator);
			return driver.findElement(By.id(locator));
		}
		else if (type.equals("name")) {
			System.out.println("Element found with name: " + locator);
			return driver.findElement(By.name(locator));
		}
		else if (type.equals("xpath")) {
			System.out.println("Element found with xpath: " + locator);
			return driver.findElement(By.xpath(locator));
		}
		else if (type.equals("css")) {
			System.out.println("Element found with css: " + locator);
			return driver.findElement(By.cssSelector(locator));
		}
		else if (type.equals("classname")) {
			System.out.println("Element found with classname: " + locator);
			return driver.findElement(By.className(locator));
		}
		else if (type.equals("tagname")) {
			System.out.println("Element found with tagname: " + locator);
			return driver.findElement(By.tagName(locator));
		}
		else if (type.equals("linktext")) {
			System.out.println("Element found with link text: " + locator);
			return driver.findElement(By.linkText(locator));
		}
		else if (type.equals("partiallinktext")) {
			System.out.println("Element found with partial link text: " + locator);
			return driver.findElement(By.partialLinkText(locator));
		}
		else {
			System.out.println("Locator type not supported");
			return null;
		}
	}
	
	public List<WebElement> getElementList(String locator, String type) {
		type = type.toLowerCase();
		List<WebElement> elementList = new ArrayList<WebElement>();
		if (type.equals("id")) {
			elementList = driver.findElements(By.id(locator));
		}
		else if (type.equals("name")) {
			elementList = driver.findElements(By.name(locator));
		}
		else if (type.equals("xpath")) {
			elementList = driver.findElements(By.xpath(locator));
		}
		else if (type.equals("css")) {
			elementList = driver.findElements(By.cssSelector(locator));
		}
		else if (type.equals("classname")) {
			elementList = driver.findElements(By.className(locator));
		}
		else if (type.equals("tagname")) {
			elementList = driver.findElements(By.tagName(locator));
		}
		else if (type.equals("linktext")) {
			elementList = driver.findElements(By.linkText(locator));
		}
		else if (type.equals("partiallinktext")) {
			elementList = driver.findElements(By.partialLinkText(locator));
		}
		else {
			System.out.println("Locator type not supported");
		}
		if (elementList.isEmpty()) {
			System.out.println("Element not found with " + type +": " + locator);
			
		} else {
			System.out.println("Element found with " + type +": " + locator);
		}
		return elementList;
	}

	public boolean isElementPresent(String locator, String type) {
		List<WebElement> elementList = getElementList(locator, type);
		
		int size = elementList.size();
		
		if (size > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public WebElement waitForElement(By locator, int timeout) {
		WebElement element = null;
		try {
			System.out.println("Waiting for max:: " + timeout + " seconds for element to be available");
			
			WebDriverWait wait = new WebDriverWait(driver, 3);
			element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("Element appeared on the web page");	
		} catch(Exception e) {
			System.out.println("Element not appeared on the web page");
		}
		return element;
	}
	
	public void clickWhenReady(By locator, int timeout) {
		try {
			WebElement element = null;
			System.out.println("Waiting for max:: " + timeout + " seconds for element to be clickable");
			
			WebDriverWait wait = new WebDriverWait(driver, 3);
			element = wait.until(
					ExpectedConditions.elementToBeClickable(locator));
			element.click();
			System.out.println("Element clicked on the web page");	
		} catch(Exception e) {
			System.out.println("Element not appeared on the web page");
		}
	}

}