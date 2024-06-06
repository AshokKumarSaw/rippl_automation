package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Rippl_RewardsPage extends BasePage{
	public Rippl_RewardsPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeMedium css-10myjs0' and @type='button']")
	WebElement iconHamburger;
	
	@FindBy(xpath="//p[contains(text(), 'Program')]")
	WebElement drpdwnProgram;
	
	
	@FindBy(xpath="//p[contains(text(), 'Points')]")
	WebElement submenuPoints;
	
	
	@FindBy(xpath="//button[contains(text(), 'Add Ways to Earn')]")
	WebElement btnAddWaystoEarn;
	
	
	@FindBy(xpath="//h2[contains(text(),'Build From Scratch')]")
	WebElement btnBuildFromScratch;
	
	
	
	
}
