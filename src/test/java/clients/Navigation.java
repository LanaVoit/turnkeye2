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

public class Navigation extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled10() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
    	Actions actions = new Actions(driver);
    	
	    driver.get(baseUrl + "clients#magentoenterprise");
	    TimeUnit.SECONDS.sleep(10);
	    String test = driver.findElement(By.cssSelector("div.portfolio-item[style='position: absolute; left: 0px; top: 0px; transform: translate3d(0px, 0px, 0px);'] > img")).getAttribute("alt");   	    
	    
	    driver.get(baseUrl + "index.php/secretzone51");
        /*driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("gbpljrhzxrf1530");
        driver.findElement(By.cssSelector("input.form-button")).click();*/
        actions.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']/li[8]/a/span"))).build().perform();
        driver.findElement(By.xpath("//ul[@id='nav']/li[8]/ul/li/a/span")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.cssSelector("button[title='Reset Filter']")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.id("portfolio_set_id_filter_name")).clear();
        driver.findElement(By.id("portfolio_set_id_filter_name")).sendKeys(test);
        driver.findElement(By.cssSelector("button[title='Search']")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.xpath("//table[@id='portfolio_set_id_table']/tbody/tr/td[2]")).click();
        driver.findElement(By.cssSelector("#portfolio_tabs_small > span")).click();
        driver.findElement(By.cssSelector("#portfolio_tabs_filter > span")).click();
        String store = driver.findElement(By.cssSelector("select[name='filter_magento'] option[selected='selected']")).getText();    
	    assertEquals("Magento Enterprise", store);      
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
