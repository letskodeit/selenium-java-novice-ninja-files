package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindByTagName {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		driver = new FirefoxDriver();
		
		String baseURL = "http://demostore.x-cart.com/";
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		driver.findElement(By.tagName("a")).click();
		
		// id - fastest
		// name
		// classname
		// xpath
		// linktext
		// partial link text
		// tagname
		// css selector
	}
}