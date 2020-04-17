package tutorialselenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import tutorialselenium.EnterPassword;

public class FileUploadWindows {
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
	public void fileUpload() throws AWTException, InterruptedException {
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
		
		StringSelection ss = new StringSelection("C:\\Users\\Anil Tomar\\Desktop\\testfile.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		// Ctrl + v
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath("//div[text()='Send']")).click();
	}

	@AfterClass
	public void afterClass() {
	}

}