package blog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.Logs;

import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;

public class JS_error_blog extends turnkeye2.pages.TestBase {
	
    @Test
  public void testUntitled4() throws Exception { 
  //  	final WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get(baseUrl + "blog/");
        Logs log = driver.manage().logs();
        List<LogEntry> logsEntries = log.get("browser").getAll();    
        List<String> list = new ArrayList<String>();
        list.isEmpty();
        for (LogEntry entry: logsEntries) {        	
    		System.out.println(entry.getMessage());  
    		//driver.quit();
        }
		    assertEquals(list, logsEntries);
		   // driver.quit();
  	    }    
}

