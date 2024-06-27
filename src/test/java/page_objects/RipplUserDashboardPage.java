package page_objects;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;
import step_definitions.Hook;
import utilities.ActionUtil;

public class RipplUserDashboardPage extends BasePage {
	public static Properties properties;

	public RipplUserDashboardPage(WebDriver driver) {
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

	@FindBy(xpath = "//button[normalize-space()=\"Sign in\"]")
	WebElement txtTierNameInWidgetDash;

	@FindBy(xpath = "//button[normalize-space()=\"Sign in\"]")
	WebElement txtAllActionsNameInWidgetDash;

	@FindBy(xpath = "//button[normalize-space()=\"Sign in\"]")
	WebElement txtChallengeSrtDscptnInWidgetDash;
	
	@FindBy(xpath = "//button[normalize-space()=\"Sign in\"]")
	WebElement txtActionDscptnInWidgetDash;
	
	@FindBy(xpath = "//*[starts-with(text,'Complete')]")
	WebElement btnCmplteActn;
	
	@FindBy(xpath = "//*[starts-with(text,'Complete')]")
	WebElement txtTrackingInstructionInWidgetDash;
	
	

	public void launchRipplRewardsUserDashboard() {
		try {
			driver.switchTo().newWindow(WindowType.WINDOW);
			driver.get(properties.getProperty("ripplReward_applicationUrl"));
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println("An error occurred while launching the Rippl Rewards User Dashboard: " + e.getMessage());
		}
	}

	public void openWidgetDash() {
		ActionUtil.click(lnkWidget);
	}

	public void loginToRipplRewardsUserDashboard() {
		ActionUtil.click(lnkSignin);
		ActionUtil.sendKeysWhenClickable(driver, txtCustEmail, Hook.properties.getProperty("ripplReward_email"),
				Duration.ofSeconds(5));
		ActionUtil.sendKeysWhenClickable(driver, txtCustPassword, Hook.properties.getProperty("ripplReward_password"),
				Duration.ofSeconds(3));
		ActionUtil.click(btnSignin);
	}

	public void getTagNameFromWidgetDash(String filterByTags) {
		ActionUtil.waitForVisibilityOfAllElements(driver, txtTierNameInWidgetDash, Duration.ofSeconds(10));

		Assert.assertEquals(txtTierNameInWidgetDash.getAttribute("TierName"), filterByTags);

	}

	public void getChallengeNameFromWidgetDash(String challenge_name)

	{

		List<WebElement> drpdwnChallengeNameList = ActionUtil.waitForVisibilityOfAllElements(driver,
				txtAllActionsNameInWidgetDash, Duration.ofSeconds(10));

		for (WebElement challengeName : drpdwnChallengeNameList) {
			if (challengeName.getText().equals(challenge_name)) {
				Assert.assertEquals(challengeName, challenge_name);

			}
		}

	}
	public boolean validateShortDescription(String challenge_name, String short_description) {

		List<WebElement> drpdwnChallengeNameList = ActionUtil.waitForVisibilityOfAllElements(driver,
				txtAllActionsNameInWidgetDash, Duration.ofSeconds(10));

		for (WebElement challengeName : drpdwnChallengeNameList) {
			if (challengeName.getText().equals(challenge_name)) {
				if (txtChallengeSrtDscptnInWidgetDash.getText().equals(short_description)) {
					return true;
				}

			}

		}
		return false;
	}

	
	
	
	public boolean validateActionDescription(String challenge_name, String action_description) {

		List<WebElement> drpdwnChallengeNameList = ActionUtil.waitForVisibilityOfAllElements(driver,
				txtAllActionsNameInWidgetDash, Duration.ofSeconds(10));

		for (WebElement challengeName : drpdwnChallengeNameList) {
			if (challengeName.getText().equals(challenge_name)) {
				challengeName.click();
				if (txtActionDscptnInWidgetDash.getText().equals(action_description)) {
					return true;
				}

			}

		}
		return false;
	}
	
	
	
	
	public boolean validateTrackingInstructions(String challenge_name,String tracking_instruction) {

		List<WebElement> drpdwnChallengeNameList = ActionUtil.waitForVisibilityOfAllElements(driver,
				txtAllActionsNameInWidgetDash, Duration.ofSeconds(10));

		for (WebElement challengeName : drpdwnChallengeNameList) {
			if (challengeName.getText().equals(challenge_name)) {
				challengeName.click();
				btnCmplteActn.click();
				if (txtTrackingInstructionInWidgetDash.getText().equals(tracking_instruction)) {
					return true;
				}

			}

		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
}
