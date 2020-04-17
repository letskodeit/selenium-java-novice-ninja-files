package browserprofiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class ProfilesDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", 
				"/Users/atomar/Documents/workspace_personal/libs/geckodriver");
		String baseURL = "http://www.letskodeit.com";
		WebDriver driver;
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile fxProfile = profile.getProfile("automationprofile");
		
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(fxProfile);
		
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}
}