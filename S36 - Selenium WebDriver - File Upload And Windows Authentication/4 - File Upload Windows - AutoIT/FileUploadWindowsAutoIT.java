package tutorialselenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import tutorialselenium.EnterPassword;

public class FileUploadWindowsAutoIT {
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		baseUrl = "https://www.gmail.com/";
		driver = new FirefoxDriver();;

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@Test
	public void fileUpload() throws AWTException, InterruptedException, IOException {
		driver.findElement(By.id("Email")).sendKeys("letskodeit");
		driver.findElement(By.id("next")).click();
		// driver.findElement(By.id("Passwd")).sendKeys(""); // Enter your password
		EnterPassword.enterPassword(driver); // Comment this
		driver.findElement(By.id("signIn")).click();
		driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
		driver.findElement(By.xpath("//div[@class='wO nr l1']//textarea")).sendKeys("letskodeit@gmail.com");
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Test File Upload");
		WebElement fileInput = driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']"));
		fileInput.click();
		Thread.sleep(2000);
		
		Runtime.getRuntime().exec("C:\\Users\\Anil Tomar\\workspace\\SeleniumWD2Tutorial\\scripts\\fileupload.exe");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[text()='Send']")).click();
	}

	@AfterClass
	public void afterClass() {
	}
}