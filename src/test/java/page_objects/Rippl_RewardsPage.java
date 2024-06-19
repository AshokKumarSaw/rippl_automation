package page_objects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ActionUtil;

public class Rippl_RewardsPage extends BasePage {

	public Rippl_RewardsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeMedium css-10myjs0' and @type='button']")
	WebElement iconHamburger;

	@FindBy(xpath = "//p[contains(text(), 'Program')]")
	WebElement drpdwnProgram;

	@FindBy(xpath = "//p[contains(text(), 'Points')]")
	WebElement submenuPoints;

	@FindBy(xpath = "//button[contains(text(), 'Add Ways to Earn')]")
	WebElement btnAddWaystoEarn;

	@FindBy(xpath = "//h2[contains(text(),'Build From Scratch')]")
	WebElement btnBuildFromScratch;

	@FindBy(xpath = "//div[@class=\"MuiCardContent-root css-1vq0w4j\"]")
	WebElement listWaysToEarn;

	@FindBy(xpath = "//button[contains(text(),'Edit')]")
	WebElement btnEditWaysToEarnChallenge;

	/**
	 * User navigates to Hamburger icon, program->Points->Add Ways to Earn->Build
	 * From Scratch Template
	 * 
	 */

	public void clickHamburgerIcon() {
		driver.switchTo().frame("app-iframe");
		ActionUtil.clickWhenClickable(driver, iconHamburger, Duration.ofSeconds(10));
	}

	public void clickProgramDrpdwn() {
		ActionUtil.clickWhenClickable(driver, drpdwnProgram, Duration.ofSeconds(10));
	}

	public void clickPoints() {
		ActionUtil.clickWhenClickable(driver, submenuPoints, Duration.ofSeconds(10));
	}

	public void clickAddWaysToEarn() {
		ActionUtil.clickWhenClickable(driver, btnAddWaystoEarn, Duration.ofSeconds(10));
	}

	public void clickBuildFromScratch() {
		ActionUtil.clickWhenClickable(driver, btnBuildFromScratch, Duration.ofSeconds(10));
	}



	public void verifyNewlyCreatedChallengeFromWaysToEarnList(String challenge_name) {

		List<WebElement> waystoearnlist = ActionUtil.waitForVisibilityOfAllElements(driver, listWaysToEarn,
				Duration.ofSeconds(10));



		for (WebElement challengename : waystoearnlist) {
			if (challengename.getText().equals(challenge_name)) {
				btnEditWaysToEarnChallenge.click();
				break;
			}
		}

	}

}
