package page_objects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.Hook;

public class ShopifyLoginPage extends BasePage {
	public WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

	public ShopifyLoginPage(WebDriver driver) {
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

	/*
	 * User logs in into shopify application
	 * 
	 * @param shopify_email
	 * 
	 * @param shopify_password
	 */

	public void loginShopify(String shopify_email, String shopify_password) {
		explicitWait.until(ExpectedConditions.elementToBeClickable(lnkLogin)).click();
		logger.info("User clicks Login Link on Shopify page ");
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtEmail))
				.sendKeys(Hook.properties.getProperty("shopify_email"));
		explicitWait.until(ExpectedConditions.elementToBeClickable(btnContinueWithEmail)).click();
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtPassword))
				.sendKeys(Hook.properties.getProperty("shopify_password"));
		explicitWait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
		logger.info("User enters shopify email,clicks on Continue with Email, enters password, clicks on Login button");

	}

}
