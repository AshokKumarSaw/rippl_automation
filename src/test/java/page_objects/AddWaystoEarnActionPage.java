package page_objects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ActionUtil;

public class AddWaystoEarnActionPage extends BasePage {
	public WebDriverWait explicitWait;
	Actions action = new Actions(driver);

	public AddWaystoEarnActionPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-9b0rt']/following::input[1]")
	WebElement txtName;

//	@FindBy(xpath = "//label[contains(text(), 'Name')]/following-sibling::*")
//	WebElement txtName;
	
	
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

	
	
//	@FindBy(xpath = "(//div[contains(@class,'css-hlgwow')][1]")
//	WebElement drpDwnFltrByCusTags;
//	
//	@FindBy(xpath = "(//div[contains(text(), 'Select...')]")
//	WebElement drpDwnFltrByCusTags;
	
	
//	@FindBy(xpath = "//div[@class=\"MuiGrid-root MuiGrid-item MuiGrid-grid-xs-8.5 css-tfvpvd\"]//div[@class=\"MuiInputBase-root MuiFilledInput-root MuiFilledInput-underline MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-sizeSmall MuiInputBase-multiline css-vdb4de\"]")
//	WebElement txtTrackingInstruction;

	@FindBy(xpath = "//label[@id=':ru:-label']/following-sibling::*")
	WebElement txtTrackingInstruction;

	@FindBy(xpath = "//input[@id=':ra:']")
	WebElement inputPoints;

	@FindBy(xpath = "//input[@id=':ra:']/following::input[1]")
	WebElement inputGallonsOfWater;

	@FindBy(xpath = "//input[@id=':ra:']/following::input[2]")
	WebElement inputKgsOfPlastic;

	@FindBy(xpath = "//input[@id=':ra:']/following::input[3]")
	WebElement inputTreesPlanted;

	@FindBy(css = "input[id=':rb:']")
	WebElement optionalEmailSettings;

	@FindBy(css = "div.ql-editor.ql-blank")
	WebElement txtcontent;

	@FindBy(xpath = "//input[@id=':rc:' and @type='text']")
	WebElement txtCorelatedTask;

	@FindBy(css = "input[type=file][name=image]")
	WebElement btnUploadBanner;

	@FindBy(xpath = "//button[text()='Publish' and @type='submit']")
	WebElement btnPublish;

	/**
	 * User enters name and short description for the Ways to Earn Challenge
	 * @param name
	 * @param short_description
	 */
	
	
	public void nameShortDescription(String name, String short_description) {
		logger.info("User enters Action Name and Short Description");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("app-iframe");

		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtName)).sendKeys(name);

		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtShortDescription)).sendKeys(short_description);

	}

	/**
	 * User enters Action Description for the Ways to Earn Challenge
	 * @param action_description
	 */
	public void actionDescription(String action_description) {
		logger.info("User enters Action Description");
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtActionDescription)).sendKeys(action_description);

	}

	/**
	 * User enters start date, end date, customer tags and tracking instruction for the challenge
	 * @param startdate
	 * @param enddate
	 * @param Filter_by_customer_tags
	 * @param tracking_instruction
	 */
	public void startEndDate_fltrByCusTags_trackingIns(String startdate, String enddate, String Filter_by_customer_tags,
			String tracking_instruction) throws InterruptedException {
		logger.info("User enters Start date, End date,Filter By Customer Tag and Tracking Instruction");
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(inputStartDate)).sendKeys(startdate);
		inputStartDate.sendKeys(Keys.ENTER);
		
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(inputEndDate)).sendKeys(enddate);
		inputEndDate.sendKeys(Keys.ENTER);
		
//		Thread.sleep(5000);
//		action.moveToElement(drpDwnFltrByCusTags);
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", drpDwnFltrByCusTags);
//		drpDwnFltrByCusTags.sendKeys(Keys.ENTER);
	
	//	ActionUtil.click(drpDwnFltrByCusTags);
		
		
        
        
		
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(drpDwnFltrByCusTags)).click();
		
//		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		explicitWait.until(ExpectedConditions.elementToBeClickable(drpDwnFltrByCusTags)).sendKeys(Filter_by_customer_tags);
		Thread.sleep(5000);
		drpDwnFltrByCusTags.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
System.out.println("drpDwnFltrByCusTags1 is clicked.............");


		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtTrackingInstruction))
				.sendKeys(tracking_instruction);

	}

	/**
	 * User enters Reward points and Impact details for the challenge
	 * @param reward_points
	 * @param water_saved
	 * @param plastic_saved
	 * @param Trees_planted
	 */
	
	public void rewardPoints_impactDetails(String reward_points, String water_saved, String plastic_saved,
			String Trees_planted) {

		logger.info("User enters Reward Points and Impact Details");		
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(inputPoints)).sendKeys(reward_points);

		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(inputGallonsOfWater)).sendKeys(water_saved);

		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(inputKgsOfPlastic)).sendKeys(plastic_saved);

		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		explicitWait.until(ExpectedConditions.elementToBeClickable(inputTreesPlanted)).sendKeys(Trees_planted);

//		inputPoints.sendKeys(reward_points);
//		inputGallonsOfWater.sendKeys(water_saved);
//		inputKgsOfPlastic.sendKeys(plastic_saved);
//		inputTreesPlanted.sendKeys(Trees_planted);
	}
	
	/**
	 * User enters Optional Email, Content and Correlated Task for the challenge
	 * @param optional_email_settings
	 * @param content
	 * @param correlated_task
	 */

	public void emailSettings_Content_CorrelatedTask(String optional_email_settings, String content,
			String correlated_task) {
		logger.info("User enters Optional Email, Content and Correlated Task");
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(optionalEmailSettings))
				.sendKeys(optional_email_settings);

		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtcontent)).sendKeys(content);

		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtCorelatedTask)).sendKeys(correlated_task);

//		optionalEmailSettings.sendKeys(optional_email_settings);
//		txtcontent.sendKeys(content);
//		txtCorelatedTask.sendKeys(correlated_task);

	}

	/**
	 * User Uploads banner Image and publishes the Ways to Earn Challenge 
	 */
	
	public void uploadBannerImgPublish() {
		logger.info("User uploads banner Image and publishes the Ways to Earn Action");
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(btnUploadBanner))
				.sendKeys("/rippl_automation/image/banner_img.jpg");

		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(btnPublish)).click();

//		btnUploadBanner.sendKeys("/rippl_automation/image/banner_img.jpg");
//		btnPublish.click();

	}

}
