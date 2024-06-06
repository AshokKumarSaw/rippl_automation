package page_objects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ActionUtil;

public class LoginPage extends BasePage {
	public WebDriverWait explicitWait;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Elements

	@FindBy(xpath = "//a[@class='whitespace-nowrap hover:underline text-white']")
	WebElement lnkLogin;

	@FindBy(xpath = "//input[@id='account_email']")
	WebElement txtEmail;

	@FindBy(xpath = "//button[@name='commit']")
	WebElement btnContinueWithEmail;

	@FindBy(xpath = "//input[@id='account_password']")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@name='commit']")
	WebElement btnLogin;

	// Methods

	public void clickShopifyLoginLnk() {
		logger.info("User clicks Login Link on Shopify page ");
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(lnkLogin)).click();

	}

	public void loginIntoShopify(String email, String password) throws InterruptedException {
		logger.info(
				"User enters valid email,clicks on Continue with Email, enters valid password and clicks on Login button");

		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtEmail)).sendKeys(email);

		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(btnContinueWithEmail)).click();

		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtPassword)).sendKeys(password);

		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();

	}

}
