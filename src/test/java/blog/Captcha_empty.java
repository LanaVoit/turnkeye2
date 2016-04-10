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

public class Captcha_empty extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
    	Actions actions = new Actions(driver);
    	
    	driver.get(baseUrl + "/blog");
        TimeUnit.SECONDS.sleep(5);
    
    
    driver.findElement(By.linkText("ÒÅÑÒÈÐÎÂÀÍÈÅ")).click();
    driver.findElement(By.cssSelector("a[href=\"http://astrio.ru/blog/usability-testing/\"]")).click();
    driver.findElement(By.id("user")).clear();
    driver.findElement(By.id("user")).sendKeys("test");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("test@test.com");
    driver.findElement(By.id("comment")).clear();
    driver.findElement(By.id("comment")).sendKeys("test comment");
    driver.findElement(By.cssSelector("input.button.form-button")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("Your Recaptcha solution was incorrect, please try again", driver.findElement(By.cssSelector("li > span")).getText());
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
