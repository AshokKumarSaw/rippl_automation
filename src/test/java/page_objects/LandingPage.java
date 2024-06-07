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

	public void ShopifyDashboard()  {
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(actLogo)).click();
		
		
	}
	
	public  void selectStore() 
	{
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(lnkStore)).click();
		driver.manage().window().fullscreen();
	}
	
	public void ripplRewardStaging()
	{
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(lnkRipplRewardStaging)).click();
		driver.manage().window().maximize();
		
	}
	
	

}
