package step_definitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ActionUtil;

public class Hook {
	public static WebDriver driver;
	public static Properties properties;
	public Logger logger; // for logging
	public String br; // to store browser name

	/**
	 * To Read data from Config.Properties File and subsequently launch the browser
	 * 
	 * @throws InterruptedException
	 */
	@Before
	public void setup() throws IOException, InterruptedException {

		// for log
		logger = LogManager.getLogger(this.getClass());

		File file = new File(".\\src\\test\\resources\\config.properties");
		FileInputStream fileInputStream = new FileInputStream(file);
		properties = new Properties();
		properties.load(fileInputStream);
		br = properties.getProperty("browser");
		launch_browser();
	}

	public void launch_browser() throws InterruptedException {
		if (br.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (br.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(properties.getProperty("shopify_applicationUrl"));
		driver.manage().window().maximize();

	}

	/**
	 * To take screenshots of failed test scripts and subsequently close all the
	 * open tabs of a browser
	 */

	@After
	public void screenshot(Scenario scenario) {
		System.out.println("Scenario status ======>" + scenario.getStatus());
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		driver.quit();
	}

}
