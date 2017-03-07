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

public class Captcha_disable extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled3() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
    	Actions actions = new Actions(driver);
    	
        driver.get(baseUrl + "index.php/secretzone51");
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("gbpljrhzxrf1530");
        driver.findElement(By.cssSelector("input.form-button")).click();
        TimeUnit.SECONDS.sleep(5);
        actions.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']/li[8]/a/span"))).build().perform(); 
        driver.findElement(By.xpath("//ul[@id='nav']/li[8]/ul/li[6]/a/span")).click();
        TimeUnit.SECONDS.sleep(5);
        new Select(driver.findElement(By.id("blog_recaptcha_enabled"))).selectByVisibleText("No");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,driver.findElement(By.cssSelector("button[title=\"Save Config\"]")));
       
        driver.findElement(By.cssSelector("button[title=\"Save Config\"]")).click();
        TimeUnit.SECONDS.sleep(5);
        assertEquals("The configuration has been saved.", driver.findElement(By.cssSelector("li > span")).getText());   
        
        actions.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']/li[11]/a/span"))).build().perform();    
        driver.findElement(By.xpath("//ul[@id='nav']/li[11]/ul/li[11]/a/span")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.linkText("Select All")).click();
        driver.findElement(By.cssSelector("button[title=\"Submit\"]")).click();
        TimeUnit.SECONDS.sleep(5);
        assertEquals("7 cache type(s) refreshed.", driver.findElement(By.cssSelector("li > span")).getText());
        
        driver.get(baseUrl + "blog/usability-testing/");        
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys("test");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("comment")).clear();
        driver.findElement(By.id("comment")).sendKeys("test comment");
        driver.findElement(By.cssSelector("input.button.form-button")).click();
        TimeUnit.SECONDS.sleep(5);
        assertEquals("Ваш комментарий отправлен и ожидает подтверждения администратором.", driver.findElement(By.cssSelector("#noty_top_layout_container >li > div > div > span > ul > li > ul > li > span")).getText());   	 	
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
