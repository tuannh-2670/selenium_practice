package selenium_practice.main.pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import selenium_practice.main.driverConfig.DriverBase;

public class VibloPage extends PageBase {
	private String accessUrl = "https://accounts.viblo.asia/login";

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Tên người dùng hoặc email']")
	private WebElement emailInput;

	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	private WebElement passwordInput;

	@FindBy(how = How.XPATH, using = "//button[@class='el-button w-100 el-button--primary']")
	private WebElement loginBtn;

	@FindBys({ @FindBy(how = How.XPATH, using = "//div[@class='el-form-item__error']") })
	private List<WebElement> inputErrors;

	public VibloPage() throws Exception {
		this.setDriver(DriverBase.buildSetupDriver());
		this.getDriver().get(accessUrl);
		this.getDriver().manage().window().maximize();
		PageFactory.initElements(this.getDriver(), this);
	}

	public WebElement getEmailInput() {
		return emailInput;
	}

	public WebElement getPasswordInput() {
		return passwordInput;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public List<WebElement> getInputErrors() {
		return inputErrors;
	}

	public void clearInput(WebElement input) {
		input.clear();
	}

	public void clickBtn(WebElement btn) {
		btn.click();
	}

	public void sendInputValue(WebElement input, String value) {
		input.sendKeys(value);
	}
}
