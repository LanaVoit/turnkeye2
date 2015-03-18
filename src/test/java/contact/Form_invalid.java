package contact;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Form_invalid extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled3() throws Exception {
    driver.manage().window().setSize(new Dimension(1366, 1050));
    
    driver.get(baseUrl + "/contact_us.html");
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("<script>alert();</script>");
    driver.findElement(By.id("comment")).clear();
    driver.findElement(By.id("comment")).sendKeys("<script>alert();</script>");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("<script>alert();</script>");
    driver.findElement(By.cssSelector("button.button")).click();
    assertEquals("Please enter a valid email address", driver.findElement(By.cssSelector("label.error")).getText());
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
