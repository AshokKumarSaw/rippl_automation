package page_objects;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ActionUtil;

public class BuildFromScratchPage extends BasePage {
//	public WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(20));
	Actions action = new Actions(driver);

	public BuildFromScratchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-9b0rt']/following::input[1]")
	WebElement txtName;

	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-9b0rt']/following::input[2]")
	WebElement txtShortDescription;

	@FindBy(xpath = "//div[@class='ql-editor ql-blank' and @contenteditable='true']/p")
	WebElement txtActionDescription;

	@FindBy(xpath = "(//input[@placeholder='Click to select a date' and  @class='MuiInputBase-input MuiFilledInput-input MuiInputBase-inputSizeSmall css-7ulcqb'])[1]")
	WebElement inputStartDate;

	@FindBy(xpath = "(//input[@placeholder='Click to select a date' and  @class='MuiInputBase-input MuiFilledInput-input MuiInputBase-inputSizeSmall css-7ulcqb'])[2]")
	WebElement inputEndDate;

	@FindBy(xpath = "(//div[@class=' css-19bb58m'])[1]")
	WebElement drpDwnFltrByCusTags;

	@FindBy(xpath = "(//textarea[@class='MuiInputBase-input MuiFilledInput-input MuiInputBase-inputMultiline MuiInputBase-inputSizeSmall css-g4h9k1'])[1]")
	WebElement txtTrackingInstruction;

	@FindBy(css = "input[type=file][name=image]")
	WebElement btnUploadBanner;

	@FindBy(xpath = "//button[text()='Crop']")
	WebElement btnBannerCrop;

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiFilledInput-input MuiInputBase-inputSizeSmall css-7ulcqb' and @type='number'])[1]")
	WebElement inputPoints;

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiFilledInput-input MuiInputBase-inputSizeSmall css-7ulcqb' and @type='number'])[2]")
	WebElement inputGallonsOfWater;

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiFilledInput-input MuiInputBase-inputSizeSmall css-7ulcqb' and @type='number'])[3]")
	WebElement inputKgsOfPlastic;

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiFilledInput-input MuiInputBase-inputSizeSmall css-7ulcqb' and @type='number'])[4]")
	WebElement inputTreesPlanted;

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiFilledInput-input MuiInputBase-inputSizeSmall css-7ulcqb'])[9]")
	WebElement optionalEmailSettings;

	@FindBy(css = "div.ql-editor.ql-blank")
	WebElement txtcontent;

	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiFilledInput-input MuiInputBase-inputSizeSmall css-7ulcqb'])[10]")
	WebElement txtCorelatedTask;

	@FindBy(xpath = "//button[text()='Publish' and @type='submit']")
	WebElement btnPublish;

	public void randomChallengeName(String challenge_name) {
		String challengeName = ActionUtil.generateRandomChallengeName();
		ActionUtil.sendKeysWhenClickable(driver, txtName, challengeName, Duration.ofSeconds(10));
	}

	public void enterShortDescription(String short_description) {
		ActionUtil.sendKeysWhenClickable(driver, txtShortDescription, short_description, Duration.ofSeconds(10));
	}

	public void enterActionDescription(String action_description) {
		ActionUtil.sendKeysWhenClickable(driver, txtActionDescription, action_description, Duration.ofSeconds(10));
	}

	public void enterStartDate(String startdate) {
		ActionUtil.sendKeysWhenClickable(driver, inputStartDate, startdate, Duration.ofSeconds(10));
		inputStartDate.sendKeys(Keys.ENTER);
	}

	public void enterEndDate(String enddate) {
		ActionUtil.sendKeysWhenClickable(driver, inputEndDate, enddate, Duration.ofSeconds(10));
		inputEndDate.sendKeys(Keys.ENTER);
	}

	public void selectFltrByCusTag(String filterByTags) {
		List<WebElement> drpdwnTagList = ActionUtil.waitForVisibilityOfAllElements(driver, drpDwnFltrByCusTags,
				Duration.ofSeconds(10));

		for (WebElement tagList : drpdwnTagList) {
			if (tagList.getText().equals(filterByTags)) {
				tagList.click();
				break;
			}
		}

	}

	public void enterTrackingInstruction(String tracking_instruction) {
		ActionUtil.sendKeysWhenClickable(driver, txtTrackingInstruction, tracking_instruction, Duration.ofSeconds(10));
	}

	public void uploadBannerImage() {
		ActionUtil.sendKeysWhenClickable(driver, btnUploadBanner,
				System.getProperty("user.dir") + "\\image\\banner_img.jpg", Duration.ofSeconds(10));
		ActionUtil.click(btnBannerCrop);

	}

	public void enterRewardPoint(String reward_points) {
		ActionUtil.sendKeysWhenClickable(driver, inputPoints, reward_points, Duration.ofSeconds(10));
	}

	public void enterImpactOne(String water_saved) {
		ActionUtil.sendKeysWhenClickable(driver, inputGallonsOfWater, water_saved, Duration.ofSeconds(10));
	}

	public void enterImpactTwo(String plastic_saved) {
		ActionUtil.sendKeysWhenClickable(driver, inputKgsOfPlastic, plastic_saved, Duration.ofSeconds(10));
	}

	public void enterImpactThree(String Trees_planted) {
		ActionUtil.sendKeysWhenClickable(driver, inputTreesPlanted, Trees_planted, Duration.ofSeconds(10));
	}

	public void enterOptionalEmailSettings(String optional_email_settings) {
		ActionUtil.sendKeysWhenClickable(driver, optionalEmailSettings, optional_email_settings, Duration.ofSeconds(10));
	}
	
	public void enterContent(String content) {
		ActionUtil.sendKeysWhenClickable(driver, txtcontent, content, Duration.ofSeconds(10));
	}
	
	
	public void enterCorelatedTask(String correlated_task) {
		ActionUtil.sendKeysWhenClickable(driver, txtCorelatedTask, correlated_task, Duration.ofSeconds(10));
	}
	
	
	
	
	public void verifyChallengeDetails(Map<String, String> challenge_Details) {
		Assert.assertEquals(challenge_Details.get("challengeName"), txtName.getText());
		Assert.assertEquals(challenge_Details.get("shortDescription"), txtShortDescription.getText());
		Assert.assertEquals(challenge_Details.get("actionDescription"), txtActionDescription.getText());
		Assert.assertEquals(challenge_Details.get("startDate"), inputStartDate.getText());
		Assert.assertEquals(challenge_Details.get("endDate"), inputEndDate.getText());
		Assert.assertEquals(challenge_Details.get("filter_By_Tags"), drpDwnFltrByCusTags.getText());
		Assert.assertEquals(challenge_Details.get("trackinginstruction"), txtTrackingInstruction.getText());
		Assert.assertEquals(challenge_Details.get("rewardpoints"), inputPoints.getText());
		Assert.assertEquals(challenge_Details.get("watersaved"), inputGallonsOfWater.getText());
		Assert.assertEquals(challenge_Details.get("plasticsaved"), inputKgsOfPlastic.getText());
		Assert.assertEquals(challenge_Details.get("treesplanted"), inputTreesPlanted.getText());
		Assert.assertEquals(challenge_Details.get("optionalEmailSettings"), optionalEmailSettings.getText());
		Assert.assertEquals(challenge_Details.get("Content"), txtcontent.getText());
		Assert.assertEquals(challenge_Details.get("correlatedTask"), txtCorelatedTask.getText());

	}

	/**
	 * User publishes the Ways to Earn Challenge
	 */

	public void publish() {
		logger.info("User publishes the Ways to Earn Action");
		ActionUtil.click(btnPublish);

	}

}
