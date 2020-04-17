package systeminteraction;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class WindowsAuthentication {
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		// baseUrl = "http://engprod-charter.net";
		baseUrl = "http://rsyspedia.india.rsystems.com";
		driver = new FirefoxDriver();
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void handleAuthenticationon() throws AWTException, InterruptedException, IOException {
		Runtime.getRuntime().exec("C:\\Users\\Anil Tomar\\workspace\\SeleniumWD2Tutorial\\scripts\\WindowsAuthentication.exe");
		driver.get(baseUrl);
	}

	@AfterClass
	public void afterClass() {
	}

}