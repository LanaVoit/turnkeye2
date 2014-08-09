package home;

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

public class Newsletter_valid extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled3() throws Exception {
    //	final WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    driver.get(baseUrl);
    driver.findElement(By.id("newsletter")).click();
    driver.findElement(By.id("newsletter")).clear();
    driver.findElement(By.id("newsletter")).sendKeys("testqa@test.com");
    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
    assertEquals("Запрос на подтверждение был отправлен.", driver.findElement(By.cssSelector("li > span")).getText());
  //  driver.quit();
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
