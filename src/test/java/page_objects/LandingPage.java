package page_objects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ActionUtil;

public class LandingPage extends BasePage {
	public WebDriverWait explicitWait;

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	
	
	@FindBy(xpath = "//span[@class='Polaris-Avatar__Initials']//*[name()='svg']")
	WebElement actLogo;
	
	
	@FindBy(xpath = "//div[normalize-space()='Staging May 2 Test Store 1']")
	WebElement lnkStore;

	@FindBy(xpath = "//span[contains(text(),'Rippl Rewards Staging')]")
	WebElement lnkRipplRewardStaging;

	
	/**
	 * User clicks on My_Account Log in Shopify home page
	 */
	
	public void ShopifyDashboard()  {
		logger.info("User clicks on Shopify Account Profile Logo displayed on top-right");
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(actLogo)).click();
		
		
	}
	
	/**
	 * User selects the store from My_Account dropdown 
	 */
	public  void selectStore() 
	{
		logger.info("User selects the Staging May 2 Test Store 1 store from the Account dropdown");
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(lnkStore)).click();
		driver.manage().window().fullscreen();
	}
	
	/**
	 * User clicks on Rippl Reward Staging Link displayed under App  
	 */
	public void ripplRewardStaging()
	{
		logger.info("User clicks on Rippl Reward Staging link displayed in menu under App section for the store Staging May 2 Test Store 1");
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(lnkRipplRewardStaging)).click();
		driver.manage().window().maximize();
		
	}
	
	

}
