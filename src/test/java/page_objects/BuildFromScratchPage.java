package page_objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ActionUtil;

public class BuildFromScratchPage extends BasePage {
	public WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(20));
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

	public void buildFromScratchFormData(String challenge_name, String short_description, String action_description,
			String startdate, String enddate, String filterByTags, String tracking_instruction, String reward_points,
			String water_saved, String plastic_saved, String Trees_planted, String optional_email_settings,
			String content, String correlated_task) {

		logger.info("User enters Action Name and Short Description");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("app-iframe");
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtName)).sendKeys(challenge_name);
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtShortDescription)).sendKeys(short_description);
		logger.info("User enters Action Description");
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtActionDescription)).sendKeys(action_description);
		logger.info(
				"User enters Start date, End date,Filter By Customer Tag, uploads banner Image and Tracking Instruction");

		explicitWait.until(ExpectedConditions.elementToBeClickable(inputStartDate)).sendKeys(startdate);
		inputStartDate.sendKeys(Keys.ENTER);

		explicitWait.until(ExpectedConditions.elementToBeClickable(inputEndDate)).sendKeys(enddate);
		inputEndDate.sendKeys(Keys.ENTER);

		explicitWait.until(ExpectedConditions.elementToBeClickable(drpDwnFltrByCusTags)).click();
		driver.findElement(By.xpath("//div[contains(text(),'" + filterByTags + "')]")).click();

		explicitWait.until(ExpectedConditions.elementToBeClickable(txtTrackingInstruction))
				.sendKeys(tracking_instruction);

		btnUploadBanner.sendKeys(System.getProperty("user.dir") + "\\image\\banner_img.jpg");
		explicitWait.until(ExpectedConditions.elementToBeClickable(btnBannerCrop)).click();

		logger.info("User enters Reward Points and Impact Details");

		explicitWait.until(ExpectedConditions.elementToBeClickable(inputPoints)).sendKeys(reward_points);

		explicitWait.until(ExpectedConditions.elementToBeClickable(inputGallonsOfWater)).sendKeys(water_saved);

		explicitWait.until(ExpectedConditions.elementToBeClickable(inputKgsOfPlastic)).sendKeys(plastic_saved);

		explicitWait.until(ExpectedConditions.elementToBeClickable(inputTreesPlanted)).sendKeys(Trees_planted);

	}

	/**
	 * User publishes the Ways to Earn Challenge
	 */

	public void publish() {
		logger.info("User publishes the Ways to Earn Action");
		explicitWait.until(ExpectedConditions.elementToBeClickable(btnPublish)).click();

	}

}
