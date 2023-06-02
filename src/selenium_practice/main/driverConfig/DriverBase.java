package selenium_practice.main.driverConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverBase {
	public static WebDriver buildSetupDriver() {
		String pathGecko = "D:\\Program Files (x86)\\Eclipse\\selenium_practice\\src\\selenium_practice\\lib\\firefox\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", pathGecko);
		return (WebDriver) new FirefoxDriver();
	}
}
