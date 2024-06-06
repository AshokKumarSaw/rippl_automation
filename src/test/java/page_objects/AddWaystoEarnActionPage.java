package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddWaystoEarnActionPage extends BasePage {
	public AddWaystoEarnActionPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-9b0rt']/following::input[1]")
	WebElement txtName;
	
	@FindBy(xpath="//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-9b0rt']/following::input[2]")
	WebElement txtShortDescription;
	
	@FindBy(xpath="//div[@class='ql-editor ql-blank' and @contenteditable='true']/p")
	WebElement txtActionDescription;
	
	@FindBy(xpath="(//input[@placeholder='Click to select a date' and  @class='MuiInputBase-input MuiFilledInput-input MuiInputBase-inputSizeSmall css-7ulcqb'])[1]")
	WebElement inputStartDate;
	
	@FindBy(xpath="(//input[@placeholder='Click to select a date' and  @class='MuiInputBase-input MuiFilledInput-input MuiInputBase-inputSizeSmall css-7ulcqb'])[2]")
	WebElement inputEndDate;
	
	
	@FindBy(xpath="(//div[@class=' css-19bb58m'])[1]")
	WebElement drpDwnFltrByCusTags;
	
	@FindBy(xpath="//div[text()='Live image capture']")
	WebElement drpDwnImgTrackingType;
	
	@FindBy(xpath="//input[@id=':ra:']")
	WebElement inputPoints;
	
	@FindBy(xpath="//input[@id=':ra:']/following::input[1]")
	WebElement inputGallonsOfWater;
	
	@FindBy(xpath="//input[@id=':ra:']/following::input[2]")
	WebElement inputKgsOfPlastic;
	
	@FindBy(xpath="//input[@id=':ra:']/following::input[3]")
	WebElement inputTreesPlanted;
	
	@FindBy(css="input[id=':rb:']")
	WebElement optionalEmailSettings;
	
	@FindBy(css="div.ql-editor.ql-blank")
	WebElement txtcontent;
	

	@FindBy(xpath="//input[@id=':rc:' and @type='text']")
	WebElement txtCorelatedTask;
	
	@FindBy(css="input[type=file][name=image]")
	WebElement btnUploadBanner;
	
	@FindBy(xpath="//button[text()='Publish' and @type='submit']")
	WebElement btnPublish;
	
	
	
	
}
