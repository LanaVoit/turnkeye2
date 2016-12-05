package clients;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Array;
import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.Select;

public class Link_visit_website extends turnkeye2.pages.TestBase{
	private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private static int statusCode;
	  
	  
	    @Test
	  public void testUntitled8() throws Exception {
	    	
	    boolean ok = true;
	    	
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		driver.get(baseUrl + "clients");
		List<WebElement> links   = driver.findElements(By.cssSelector("a.link-visit"));
		for(WebElement e : links) {
		System.out.println(e.getAttribute("href"));
		
		}
			for(int i = 0; i < links.size(); i++){
		        if(!(links.get(i).getAttribute("href") == null) && !(links.get(i).getAttribute("href").equals(""))){
		            if(links.get(i).getAttribute("href").contains("http")){
		                statusCode= getResponseCode(links.get(i).getAttribute("href").trim());
		                if(statusCode != 200 && statusCode != 301 && statusCode != 302){
		                	System.out.println("HTTP Error " + statusCode + " # " + i + " " + links.get(i).getAttribute("href"));
		                	ok = false;
		                	}
		            	}
		            
		        	}
				}
			assertEquals(true,ok);
	    }
	    public static int getResponseCode(String urlString) throws MalformedURLException, IOException{
	    	try {
	    		URL url = new URL(urlString);
		        HttpURLConnection huc = (HttpURLConnection)url.openConnection();
		        huc.setRequestMethod("GET");
		        huc.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");			       
		        huc.connect();
		        return huc.getResponseCode();
	    	} catch (Exception e) {
	    		
	    	}
	    	
	    	return 500;
	        
	    }

	   private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  
	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}
