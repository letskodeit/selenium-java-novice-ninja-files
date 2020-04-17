package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestingSteps {
	static WebDriver driver;
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() {
		driver = new FirefoxDriver();
		String baseURL = "http://www.letskodeit.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		driver.get(baseURL);
	}

	@When("^User enters Username and Password$")
	public void user_enters_Username_and_Password() {
		WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
		signupLink.click();		
		WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
		loginLink.click();
		WebElement emailField = driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
		emailField.sendKeys("test@email.com");
		WebElement passwordField = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
		passwordField.sendKeys("abcabc");
	}

	@When("^Clicks Go button$")
	public void clicks_Go_button() throws InterruptedException {
		WebElement goButton = driver.findElement(By.id("memberLoginDialogsubmitButton"));
		goButton.click();
		
		Thread.sleep(3000);
	}

	@Then("^He can visit the practice page$")
	public void he_can_visit_the_practice_page() {
		WebElement practicePage = driver.findElement(By.id("DrpDwnMn06bg"));
		practicePage.click();
	}

	@Then("^A message is displayed$")
	public void a_message_is_displayed() {
		System.out.println("Login Successful");
	}

}
