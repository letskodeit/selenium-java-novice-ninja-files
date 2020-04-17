package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverMac {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/atomar/Documents/workspace_personal/libs/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		String baseURL = "http://learn.letskodeit.com";
		driver.get(baseURL);
		
	}
}