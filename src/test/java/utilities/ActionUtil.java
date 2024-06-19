package utilities;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionUtil {
	public static Logger logger = LogManager.getLogger(ActionUtil.class);

	/**
	 * Generates a random challenge name.
	 *
	 * @return a randomly generated challenge name
	 */
	public static String generateRandomChallengeName() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
		Random random = new Random();
		StringBuilder challengeName = new StringBuilder();
		int length = random.nextInt(20) + 10; // Generate a name with length between 10 and 30

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			challengeName.append(characters.charAt(index));
		}

		return challengeName.toString();
	}

	public static boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public static void click(WebElement webElement) {
		if (webElement != null) {
			webElement.click();
		}
	}

	public static void scrollWebPage(int x, int y, JavascriptExecutor js) {

		js.executeScript("window.scrollBy(" + x + "," + y + ")");

	}

	/**
	 * Waits until the given element is clickable and sends the provided text to it.
	 * 
	 * @param driver           the WebDriver instance
	 * @param element          the WebElement to be waited on and interacted with
	 * @param textToSend       the text to send to the element
	 * @param timeoutInSeconds the maximum time to wait in seconds
	 */
	public static void sendKeysWhenClickable(WebDriver driver, WebElement element, String textToSend,
			Duration timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		clickableElement.sendKeys(textToSend);
	}

	/**
	 * Waits until the given element is clickable and then clicks on it.
	 * 
	 * @param driver  the WebDriver instance
	 * @param element the WebElement to wait for and click
	 * @param i       the maximum time to wait in seconds
	 */


	public static void clickWhenClickable(WebDriver driver, WebElement element, Duration i) {
		WebDriverWait wait = new WebDriverWait(driver, i);
		WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		clickableElement.click();
	}

	/**
	 * Waits until all elements in the given list are visible.
	 * 
	 * @param driver           the WebDriver instance
	 * @param element          the List of WebElements to wait for
	 * @param timeoutInSeconds the maximum time to wait in seconds
	 * @return
	 */
	public static List<WebElement> waitForVisibilityOfAllElements(WebDriver driver, WebElement element,
			Duration timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

}
