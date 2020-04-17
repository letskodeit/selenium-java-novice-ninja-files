package systeminteraction;

import org.testng.annotations.Test;

import tutorialselenium.EnterPassword;

import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class FileUpload {
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "https://www.gmail.com/";

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
		EnterPassword.enterPassword(driver); // Delete this line
		driver.findElement(By.id("signIn")).click();
		driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
		driver.findElement(By.xpath("//div[@class='wO nr l1']//textarea")).sendKeys("letskodeit@gmail.com");
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Test File Upload");
		WebElement fileInput = driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']"));
		fileInput.click();

		String filePath = "//Users//atomar//Desktop//testfile.txt";
		StringSelection stringSelection= new StringSelection(filePath);
		//Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Robot robot = new Robot();
		// Cmd + Tab
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(2000);
		// Goto Window
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_G);
		// Paste the clipboard value
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_V);
		// Hit Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[text()='Send']")).click();
	}

	@AfterClass
	public void afterClass() {
	}

}
