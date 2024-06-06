package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ActionUtil {
	public static Logger logger = LogManager.getLogger(ActionUtil.class);

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

}
