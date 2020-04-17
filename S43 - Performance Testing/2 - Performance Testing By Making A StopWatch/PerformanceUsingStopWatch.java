package tutorialselenium;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageclasses.SearchPageFactory;
import utilities.Constants;
import utilities.ExcelUtility;

public class PerformanceUsingStopWatch {
	
	private WebDriver driver;
	private String baseUrl;
	SearchPageFactory searchPage;
	static Logger log = Logger.getLogger(PerformanceUsingStopWatch.class);
	StopWatch watch = new StopWatch();
	
	@BeforeClass
	public void beforeClass() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
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
	public void searchFlight() throws Exception {
		watch.start();
		driver.get(baseUrl);
		searchPage.clickFlightsTab();
		searchPage.setOriginCity("New York");
		searchPage.setDestinationCity("San Francisco");
		searchPage.setDepartureDate("10/28/2015");
		searchPage.setReturnDate("10/31/2015");
		double seconds = (double)watch.getTime() / 1000.0;
		watch.reset();
		log.info("**********************************************");
		log.info("Time taken to exeute this method was: " + seconds + " seconds");
		ExcelUtility.setCellData("Flight Page", 1, 0);
		ExcelUtility.setCellData(seconds, 1, 1);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}