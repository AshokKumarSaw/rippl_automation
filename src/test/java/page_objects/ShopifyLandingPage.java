package page_objects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopifyLandingPage extends BasePage {
	public WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

	public ShopifyLandingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@class='Polaris-Avatar__Initials']//*[name()='svg']")
	WebElement actLogo;

	@FindBy(xpath = "//body/div[@id='app']/div[@id='PolarisPortalsContainer']/div[1]")
	WebElement drpdwnLogoOptions;

	@FindBy(xpath = "//div[normalize-space()='Staging May 2 Test Store 1']")
	WebElement lnkStore;

	@FindBy(xpath = "//span[contains(text(),'Rippl Rewards Staging')]")
	WebElement lnkRipplRewardStaging;

	/**
	 * User clicks on My_Account Log in Shopify home page
	 */

	public void ShopifyDashboard() {

	}

	/**
	 * User selects the store from My_Account dropdown
	 */
	public void selectStore(String store_name) {
		explicitWait.until(ExpectedConditions.elementToBeClickable(actLogo)).click();
		
//		List<WebElement> drpdwnList = explicitWait
//				.until(ExpectedConditions.visibilityOfAllElements(drpdwnLogoOptions));
//
//		for (WebElement storename : drpdwnList) {
//			if (storename.getText().equals(store_name)) {
//				storename.click();
//				break;
//			}
//		}

		 explicitWait.until(ExpectedConditions.elementToBeClickable(lnkStore)).click();
		 driver.manage().window().fullscreen();
	}

	/**
	 * User clicks on Rippl Reward Staging Link displayed under App
	 */
	public void clickRipplRewardStagingLnk() {
		logger.info(
				"User clicks on Rippl Reward Staging link displayed in menu under App section for the store Staging May 2 Test Store 1");
		explicitWait.until(ExpectedConditions.elementToBeClickable(lnkRipplRewardStaging)).click();
		driver.manage().window().maximize();

	}

}
