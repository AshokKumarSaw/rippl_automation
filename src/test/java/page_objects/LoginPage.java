package page_objects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ActionUtil;

public class LoginPage extends BasePage {
	public WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

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

	/**
	 * The user clicks on the Login from the Shopify home page.
	 */

	public void clickShopifyLoginLnk() {
		logger.info("User clicks Login Link on Shopify page ");
		explicitWait.until(ExpectedConditions.elementToBeClickable(lnkLogin)).click();

	}

	/**
	 * User Logs in into the Shopify application
	 * 
	 * @param email
	 * @param password
	 */
	public void loginIntoShopify(String email, String password) throws InterruptedException {
		logger.info("User enters email,clicks on Continue with Email, enters password, clicks on Login button");

		explicitWait.until(ExpectedConditions.elementToBeClickable(txtEmail)).sendKeys(email);
		explicitWait.until(ExpectedConditions.elementToBeClickable(btnContinueWithEmail)).click();
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtPassword)).sendKeys(password);
		explicitWait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();

	}

}
