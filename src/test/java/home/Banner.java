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

public class Banner extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled4() throws Exception {
    driver.manage().window().setSize(new Dimension(1366, 1050));
    
    driver.get(baseUrl);

    String img1 = "http://cdn.turnkeye.ru/skin/frontend/default/turnkeye/images/main-banner/large/slide1.jpg";
    assertEquals("", img1, driver.findElement(By.cssSelector("img[src=\"http://cdn.turnkeye.ru/skin/frontend/default/turnkeye/images/main-banner/large/slide1.jpg\"]")).getAttribute("src"));  

    
    driver.findElement(By.cssSelector("img[alt=\"Pinup Clothing\"]")).click();
    String img2 = "http://cdn.turnkeye.ru/skin/frontend/default/turnkeye/images/main-banner/large/slide2.jpg";
    assertEquals("", img2, driver.findElement(By.cssSelector("img[src=\"http://cdn.turnkeye.ru/skin/frontend/default/turnkeye/images/main-banner/large/slide2.jpg\"]")).getAttribute("src")); 
    
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector("img[alt=\"Autostyle\"]")).click();
    String img4 = "http://cdn.turnkeye.ru/skin/frontend/default/turnkeye/images/main-banner/large/slide5.jpg";
    assertEquals("", img4, driver.findElement(By.cssSelector("img[src=\"http://cdn.turnkeye.ru/skin/frontend/default/turnkeye/images/main-banner/large/slide5.jpg\"]")).getAttribute("src")); 
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
