package selenium_practice.main.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import selenium_practice.main.pageObject.VibloPage;

public class VibloPageTest {
	VibloPage vibloPage = null;

	@BeforeSuite
	public void initializeDriver() throws Exception {
		vibloPage = new VibloPage();
	}

	@AfterSuite
	public void closeBrowser() {
		vibloPage.quitDriver();
	}

	@Test
	public void checkLoginTitle() {
		Assert.assertEquals(vibloPage.getTitle(), "Viblo - Login");
	}

	@Test(priority = 1)
	public void checkRequiredBothField() {
		vibloPage.clickBtn(vibloPage.getLoginBtn());
		WebDriverWait wait = new WebDriverWait(vibloPage.getDriver(), 2);
		List<WebElement> errors = vibloPage.getInputErrors();
		wait.until(ExpectedConditions.visibilityOfAllElements(errors));
		Assert.assertEquals(errors.size(), 2);
		Assert.assertEquals(errors.get(0).getText(), "Tên người dùng/email là bắt buộc");
		Assert.assertEquals(errors.get(1).getText(), "Mật khẩu là bắt buộc");
	}

	@Test(priority = 2)
	public void checkRequiredPassword() {
		vibloPage.sendInputValue(vibloPage.getEmailInput(), "nguyen.huu.tuan-b@sun-asterisk.com");
		vibloPage.clickBtn(vibloPage.getLoginBtn());
		WebDriverWait wait = new WebDriverWait(vibloPage.getDriver(), 2);
		List<WebElement> errors = vibloPage.getInputErrors();
		wait.until(ExpectedConditions.visibilityOfAllElements(errors));
		Assert.assertEquals(errors.size(), 1);
		Assert.assertEquals(errors.get(0).getText(), "Mật khẩu là bắt buộc");
	}

	@Test(priority = 3)
	public void checkRequiredEmail() {
		vibloPage.clearInput(vibloPage.getEmailInput());
		vibloPage.sendInputValue(vibloPage.getPasswordInput(), "Aa@123456");
		vibloPage.clickBtn(vibloPage.getLoginBtn());
		WebDriverWait wait = new WebDriverWait(vibloPage.getDriver(), 2);
		List<WebElement> errors = vibloPage.getInputErrors();
		wait.until(ExpectedConditions.visibilityOfAllElements(errors));
		Assert.assertEquals(errors.size(), 1);
		Assert.assertEquals(errors.get(0).getText(), "Tên người dùng/email là bắt buộc");
	}
}
