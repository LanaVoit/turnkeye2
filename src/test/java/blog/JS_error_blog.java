package blog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
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
    	driver.manage().window().setSize(new Dimension(1366, 1050));
    	
    	driver.get(baseUrl + "blog/");
    	
        Logs log = driver.manage().logs();
        List<LogEntry> logsEntries = log.get("browser").getAll();     
        String test1 = "http://www.google.com/uds/?file=ads&v=3&packages=search&async=2 0:0 Failed to load resource: the server responded with a status of 404 (Not Found)";         
        Integer errorsCount = 0;
        List<String> list = new ArrayList<String>();
        list.isEmpty();
        
        for (LogEntry entry: logsEntries) {    
        	if (entry.getMessage().contains(test1)) {
        		continue;
        	}
        	errorsCount++;
    		System.out.println(entry.getMessage());     		   		
        }  
        
	    assertEquals("0", errorsCount.toString());	 
  	}    
}

