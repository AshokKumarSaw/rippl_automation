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

	@FindBy(xpath = "//body/div[@id='app']/div[@class='_OuterContainer_19gip_19']/div[@id='AppFrame']/div[@class='Polaris-Frame Polaris-Frame--hasNav Polaris-Frame--hasTopBar']/div/div[@id='AppFrameNav']/div/nav[@class='Polaris-Navigation']/div[@class='Polaris-Navigation__PrimaryNavigation Polaris-Scrollable Polaris-Scrollable--vertical Polaris-Scrollable--horizontal Polaris-Scrollable--scrollbarWidthThin']/ul[@class='_Section_fmdqr_1']/li[2]/ul[1]/li[1]/ul[1]/li[1]/div[1]/div[1]/a[1]/span[1]")
	WebElement lnkRipplRewardStaging;

	public void ShopifyDashboard() {
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(actLogo)).click();
	}
	
	public  void selectStore()
	{
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(lnkStore)).click();
	}
	

}
