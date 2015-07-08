package clients;

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

public class Details extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled8() throws Exception {
    	driver.manage().window().maximize();
    	Actions actions = new Actions(driver);
    	
        driver.get(baseUrl + "index.php/secretzone51");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("gbpljrhzxrf1530");
        driver.findElement(By.cssSelector("input.form-button")).click();
        TimeUnit.SECONDS.sleep(3);
        actions.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']/li[8]/a/span"))).build().perform();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.xpath("//ul[@id='nav']/li[8]/ul/li/a/span")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.cssSelector("a[name=\"position\"] > span.sort-title")).click();
        TimeUnit.SECONDS.sleep(5);
        String client = null;
        /*nteger n = 1;
        Integer m;
        
        for (m=0;m<n;m++){	
        	driver.findElement(By.xpath("//*[@id='portfolio_set_id_table']/tbody/tr["+n+"]/td[2]")).click();
        	TimeUnit.SECONDS.sleep(5);
        	if(driver.findElement(By.cssSelector("select[title='Store View'] optgroup option[selected='selected']")).getText().contains("Russian Store View")) break;
            driver.findElement(By.cssSelector("button[title='Back']")).click();
    	   	TimeUnit.SECONDS.sleep(5);
    	   	n++;
        }*/
        
 
        
        driver.findElement(By.cssSelector("#portfolio_set_id_filter_position")).sendKeys("10");
        driver.findElement(By.cssSelector("button[title='Search']")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.cssSelector("#portfolio_set_id_table > tbody > tr > td:nth-child(2)")).click();
        client = driver.findElement(By.cssSelector("#base_name")).getAttribute("value");
            
        driver.get(baseUrl + "clients");
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.cssSelector("div.portfolio-item")).click();
        String client_test = driver.findElement(By.cssSelector("h1")).getText();
        assertEquals(client, client_test);

    
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
