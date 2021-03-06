package turnkeye2.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.rules.TestName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.saucelabs.testng.SauceOnDemandTestListener;
import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import junit.framework.TestCase;
import static org.testng.Assert.assertEquals;

import com.saucelabs.common.SauceOnDemandAuthentication;

import turnkeye2.util.PropertyLoader;
import turnkeye2.util.Browser;
import turnkeye2.webdriver.WebDriverFactory;

/*
 * Base class for all the test classes
 * 
 * @author Sebastiano Armeli-Battana
 */

public class TestBase {
	private static final String SCREENSHOT_FOLDER = "target/screenshots/";
	private static final String SCREENSHOT_FORMAT = ".png";

	protected WebDriver driver;

	protected String gridHubUrl;

	protected String baseUrl;

	protected Browser browser;
	
	 

	@BeforeClass
	public void init() throws MalformedURLException {
		baseUrl = PropertyLoader.loadProperty("site.url");
		gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

//		browser = new Browser();
//		browser.setName(PropertyLoader.loadProperty("browser.name"));
//		browser.setVersion(PropertyLoader.loadProperty("browser.version"));
//		browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

		String username = PropertyLoader.loadProperty("user.username");
		String password = PropertyLoader.loadProperty("user.password");

		
		
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 7");
		caps.setCapability("version", "51.0");
		caps.setCapability("screenResolution", "1680x1050");
		caps.setCapability("passed", "true");
		//caps.setCapability("failed", "false");
		caps.setCapability("name", getClass().getSimpleName());
		//System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/tools/chromedriver/chromedriver");
	        driver = new RemoteWebDriver(
	                    new URL("http://qatest_open:18ae629f-0e7f-4a44-8d23-9de3f8c92bbc@ondemand.saucelabs.com:80/wd/hub"),
	                    caps);
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}  
	
//	@BeforeClass
//	public void init() {
//		baseUrl = PropertyLoader.loadProperty("site.url");
//		gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
//
//		browser = new Browser();
//		browser.setName(PropertyLoader.loadProperty("browser.name"));
//		browser.setVersion(PropertyLoader.loadProperty("browser.version"));
//		browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));
//
//		String username = PropertyLoader.loadProperty("user.username");
//		String password = PropertyLoader.loadProperty("user.password");
//		
//		driver = WebDriverFactory.getInstance(gridHubUrl, browser, username,
//				password);
//
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	}
	
//	@AfterSuite(alwaysRun = true)
//	public void tearDown() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}
	  
	@AfterMethod
	public void stopDriver()throws Exception{
	driver.quit();
	}
	


//	@AfterMethod
//	public void setScreenshot(ITestResult result) {
//		if (!result.isSuccess()) {
//			try {
//				WebDriver returned = new Augmenter().augment(driver);
//				if (returned != null) {
//					File f = ((TakesScreenshot) returned)
//							.getScreenshotAs(OutputType.FILE);
//					try {
//						FileUtils.copyFile(f, new File(SCREENSHOT_FOLDER
//								+ result.getName() + SCREENSHOT_FORMAT));
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			} catch (ScreenshotException se) {
//				se.printStackTrace();
//			}
//		}
//	}
	
}
