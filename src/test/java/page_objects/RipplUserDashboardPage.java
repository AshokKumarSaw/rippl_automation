package page_objects;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;
import step_definitions.Hook;
import utilities.ActionUtil;

public class RipplUserDashboardPage extends BasePage{
	public static Properties properties;
public	RipplUserDashboardPage(WebDriver driver)
	{
		super(driver);
	}
	

@FindBy(xpath = "//span[@class=\"btn-text\"]")
WebElement lnkWidget;

@FindBy(xpath = "(//span[@class='btn-text'])[1]")
WebElement lnkSignin;

@FindBy(xpath = "//input[@id=\"CustomerEmail\"]")
WebElement txtCustEmail;

@FindBy(xpath = "//input[@id=\"CustomerPassword\"]")
WebElement txtCustPassword;

@FindBy(xpath = "//button[normalize-space()=\"Sign in\"]")
WebElement btnSignin;



public void launchRipplRewardsUserDashboard()
{
	try {
	driver.switchTo().newWindow(WindowType.WINDOW);
	driver.get(properties.getProperty("ripplReward_applicationUrl"));
	driver.manage().window().maximize();
	}
	catch(Exception e)
	{
		System.out.println("An error occurred while launching the Rippl Rewards User Dashboard: " + e.getMessage());
	}
}


public void openWidgetDash()
{
	ActionUtil.click(lnkWidget);
}

public void loginToRipplRewardsUserDashboard()
{
	ActionUtil.click(lnkSignin);
	ActionUtil.sendKeysWhenClickable(driver,txtCustEmail ,Hook.properties.getProperty("ripplReward_email"), Duration.ofSeconds(5));
	ActionUtil.sendKeysWhenClickable(driver,txtCustPassword ,Hook.properties.getProperty("ripplReward_password"), Duration.ofSeconds(3));
	ActionUtil.click(btnSignin);
}


















}
