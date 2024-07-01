package page_objects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.Hook;
import utilities.ActionUtil;

public class ShopifyLoginPage extends BasePage {
	//public WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

	public ShopifyLoginPage(WebDriver driver) {
		super(driver);
	}
	// Elements

	@FindBy(xpath = "//a[@class='whitespace-nowrap hover:underline text-white']")
	static WebElement lnkLogin;

	@FindBy(xpath = "//input[@id='account_email']")
static 	WebElement txtEmail;

	@FindBy(xpath = "//button[@name='commit']")
static 	WebElement btnContinueWithEmail;

	@FindBy(xpath = "//input[@id='account_password']")
static 	WebElement txtPassword;

	@FindBy(xpath = "//button[@name='commit']")
static 	WebElement btnLogin;

	//Methods
	public  void clickShopifyLoginLnk() {
ActionUtil.click(lnkLogin);
	}

	public  void enterShopifyEmail(String shopify_email) {
		ActionUtil.sendKeysWhenClickable(driver, txtEmail, Hook.properties.getProperty("shopify_email"), Duration.ofSeconds(10));
	}

	public  void clickContinueWithEmail() {
		ActionUtil.click(btnContinueWithEmail);
	}

	public  void enterShopifyPassword(String shopify_password) {
		ActionUtil.sendKeysWhenClickable(driver, txtPassword, Hook.properties.getProperty("shopify_password"), Duration.ofSeconds(10));
	}

	public void clickShopifyLoginBtn() {
		ActionUtil.click(btnLogin);
	}

	
	
	
	
}
