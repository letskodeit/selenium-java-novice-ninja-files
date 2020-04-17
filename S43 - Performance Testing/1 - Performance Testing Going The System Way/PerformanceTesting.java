package performance;

import org.testng.annotations.Test;

import pageclasses.SearchPageFactory;
//import utilities.Constants;
//import utilities.ExcelUtility;

import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import java.lang.reflect.Method;

public class PerformanceTesting {
	long startTime;
	long endTime;
	long duration;
	double seconds;
	
	private WebDriver driver;
	private String baseUrl;
	SearchPageFactory searchPage;
	static Logger log = Logger.getLogger(PerformanceTesting.class);

	@BeforeClass
	public void beforeClass() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.gecko.driver", 
				"/Users/atomar/Documents/workspace_personal/selenium/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
		searchPage = new SearchPageFactory(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Tell the code about the location of Excel file
		ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "Sheet1");
	}

	@Test
	public void searchFlight(Method name) throws Exception {
		startTime = System.nanoTime();
		driver.get(baseUrl);
		searchPage.clickFlightsTab();
		searchPage.setOriginCity("New York");
		searchPage.setDestinationCity("San Francisco");
		searchPage.setDepartureDate("10/28/2015");
		searchPage.setReturnDate("10/31/2015");
		endTime = System.nanoTime();
		duration = endTime - startTime;
		seconds = (double)duration / 1000000000.0;
		log.info("*****************************************");
		log.info("Time taken to execute this method: " + seconds + " seconds");
		// When you create the excel file, you should create row and type Flights Page in the row you are trying to write
		// If there is nothing in the row, the code will fail
		ExcelUtility.setCellData("Flights Page", 1, 0);
		ExcelUtility.setCellData(seconds, 1, 1);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}