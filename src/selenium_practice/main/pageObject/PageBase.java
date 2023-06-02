package selenium_practice.main.pageObject;

import org.openqa.selenium.WebDriver;

public class PageBase {
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		return this.driver.getTitle();
	}

	public void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
