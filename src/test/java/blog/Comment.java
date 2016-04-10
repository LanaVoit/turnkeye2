package blog;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Comment extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled4() throws Exception {
    		driver.manage().window().setSize(new Dimension(1366, 1050));
    	    Actions actions = new Actions(driver);
    	    
    	    driver.get(baseUrl + "index.php/secretzone51/");
    	    /*driver.findElement(By.id("username")).clear();
    	    driver.findElement(By.id("username")).sendKeys("admin");
    	    driver.findElement(By.id("login")).clear();
    	    driver.findElement(By.id("login")).sendKeys("gbpljrhzxrf1530");
    	    driver.findElement(By.cssSelector("input.form-button")).click();*/
    	    TimeUnit.SECONDS.sleep(5);
    	    actions.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']/li[8]/a/span"))).build().perform();
    	    driver.findElement(By.xpath("//ul[@id='nav']/li[8]/ul/li[4]/a/span")).click();
    	    TimeUnit.SECONDS.sleep(5);
    	    driver.findElement(By.cssSelector("span.sort-title")).click();
    	    TimeUnit.SECONDS.sleep(5);
    	    driver.findElement(By.cssSelector("span.sort-title")).click();   
    	    TimeUnit.SECONDS.sleep(5);
    	    driver.findElement(By.cssSelector("td.a-left")).click();    	
    	    TimeUnit.SECONDS.sleep(5);
    	    assertEquals("test comment", driver.findElement(By.id("comment")).getText());
    	    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Approved");
    	    driver.findElement(By.cssSelector("button[title=\"Save Comment\"]")).click();
    	    assertEquals("Comment was successfully saved", driver.findElement(By.cssSelector("li > span")).getText());
    	    
    	    actions.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']/li[11]/a/span"))).build().perform();    
    	    driver.findElement(By.xpath("//ul[@id='nav']/li[11]/ul/li[11]/a/span")).click();
    	    TimeUnit.SECONDS.sleep(5);
    	    driver.findElement(By.linkText("Select All")).click();
    	    driver.findElement(By.cssSelector("button[title=\"Submit\"]")).click();
    	    TimeUnit.SECONDS.sleep(5);
    	    assertEquals("7 cache type(s) refreshed.", driver.findElement(By.cssSelector("li > span")).getText());
    	    
    	    driver.get(baseUrl + "blog/usability-testing/");
    	    assertEquals("test comment", driver.findElement(By.cssSelector("div.comment-content")).getText());
    	    
    	    driver.get(baseUrl + "index.php/secretzone51/"); 
    	    TimeUnit.SECONDS.sleep(7);
    	    actions.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']/li[8]/a/span"))).build().perform();
    	    TimeUnit.SECONDS.sleep(3);
    	    driver.findElement(By.xpath("//ul[@id='nav']/li[8]/ul/li[4]/a/span")).click(); 
    	    driver.findElement(By.id("commentGrid_filter_comment")).clear();
    	    driver.findElement(By.id("commentGrid_filter_comment")).sendKeys("test comment");
    	    driver.findElement(By.cssSelector("button[title=\"Search\"]")).click();
    	    TimeUnit.SECONDS.sleep(3);
    	    driver.findElement(By.cssSelector("td.a-left")).click();        
    	    assertEquals("test comment", driver.findElement(By.id("comment")).getText());
    	    driver.findElement(By.cssSelector("button[title=\"Delete Comment\"]")).click();
    	    TimeUnit.SECONDS.sleep(5);
    	    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to do this[\\s\\S]$"));
    	    TimeUnit.SECONDS.sleep(3);
    	    
    	    actions.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']/li[11]/a/span"))).build().perform();    
    	    driver.findElement(By.xpath("//ul[@id='nav']/li[11]/ul/li[11]/a/span")).click();
    	    TimeUnit.SECONDS.sleep(5);
    	    driver.findElement(By.linkText("Select All")).click();
    	    driver.findElement(By.cssSelector("button[title=\"Submit\"]")).click();
    	    TimeUnit.SECONDS.sleep(5);
    	    assertEquals("7 cache type(s) refreshed.", driver.findElement(By.cssSelector("li > span")).getText());
    	    driver.get(baseUrl + "blog/usability-testing/");
    	    assertEquals("0 комментарии", driver.findElement(By.cssSelector("div.comment-box > div.post-title")).getText());    	 
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
