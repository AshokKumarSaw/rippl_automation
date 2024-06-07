package page_objects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddWaystoEarnActionPage extends BasePage {
	public WebDriverWait explicitWait;
	public AddWaystoEarnActionPage(WebDriver driver) {
		super(driver);
	}

//	@FindBy(xpath = "")
//	WebElement txtName;
	//
	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-9b0rt']/following::input[1]")
	WebElement txtName;
//	@FindBy(xpath = "//input[@id=':r2:']")
//	WebElement txtShortDescription;

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

	@FindBy(xpath = "//div[text()='Live image capture']")
	WebElement drpDwnImgTrackingType;

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

	public void nameShortDescription(String name, String short_description) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("app-iframe");
		
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtName)).sendKeys(name);
		
		
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtShortDescription)).sendKeys(short_description);
		
	}

	public void actionDescription(String action_description) {
		
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtActionDescription)).sendKeys(action_description);
		
	//	txtActionDescription.sendKeys(action_description);
	}

	
	public void startEndDate_fltrByCusTags_imgTrackingTyp(String startdate,String enddate, String cusTags,String imgTrckngTyp) {
	
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(inputStartDate)).sendKeys(startdate);
		
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(inputEndDate)).sendKeys(enddate);
		
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(drpDwnFltrByCusTags)).sendKeys(cusTags);
		
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(drpDwnImgTrackingType)).sendKeys(imgTrckngTyp);
		
		
		
		
		
		
//		inputStartDate.sendKeys(startdate);
//		inputEndDate.sendKeys(enddate);
//		drpDwnFltrByCusTags.sendKeys(cusTags);
//		drpDwnImgTrackingType.sendKeys(imgTrckngTyp);
	}
	
	
	public void rewardPoints_impactDetails(String reward_points,String water_saved, String plastic_saved, String Trees_planted) {
	
		
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(inputPoints)).sendKeys(reward_points);
		
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(inputGallonsOfWater)).sendKeys(water_saved);
		
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(inputKgsOfPlastic)).sendKeys(plastic_saved);
		
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(inputTreesPlanted)).sendKeys(Trees_planted);
		
//		inputPoints.sendKeys(reward_points);
//		inputGallonsOfWater.sendKeys(water_saved);
//		inputKgsOfPlastic.sendKeys(plastic_saved);
//		inputTreesPlanted.sendKeys(Trees_planted);
	}
	
	
	public void emailSettings_Content_CorrelatedTask(String optional_email_settings,String content, String correlated_task) {
		
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(optionalEmailSettings)).sendKeys(optional_email_settings);
		
		
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtcontent)).sendKeys(content);
		
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(txtCorelatedTask)).sendKeys(correlated_task);
		
		
//		optionalEmailSettings.sendKeys(optional_email_settings);
//		txtcontent.sendKeys(content);
//		txtCorelatedTask.sendKeys(correlated_task);
		
	}
	
	
	public void uploadBannerImgPublish()
	{
		
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(btnUploadBanner)).sendKeys("/rippl_automation/image/banner_img.jpg");
		
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(btnPublish)).click();
		
//		btnUploadBanner.sendKeys("/rippl_automation/image/banner_img.jpg");
//		btnPublish.click();
		
	}
	
	
	
	

}
