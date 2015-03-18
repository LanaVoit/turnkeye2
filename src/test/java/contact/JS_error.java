package contact;

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

public class JS_error extends turnkeye2.pages.TestBase {
	
    @Test
  public void testUntitled4() throws Exception { 
    	driver.manage().window().setSize(new Dimension(1366, 1050));
    	
    	driver.get(baseUrl + "/contact_us.html");
    	
        Logs log = driver.manage().logs();
        List<LogEntry> logsEntries = log.get("browser").getAll();    
        List<String> list = new ArrayList<String>();
        list.isEmpty();
        
        for (LogEntry entry: logsEntries) {        	
    		System.out.println(entry.getMessage());  
        }
        
		assertEquals(list, logsEntries);		
  }    
}

