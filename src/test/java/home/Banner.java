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

    //String img1 = "http://cdn.astrio.ru/skin/frontend/default/turnkeye/images/main-banner/large/slide1-moscow.jpg";
    String img1 = "1";
    assertEquals("", img1, driver.findElement(By.cssSelector("#container > div.block-main-banner.block-main-banner-rus > header > div.carousel-wrapper > div > ul > li:nth-child(1)")).getAttribute("data-init-position"));  

    
    driver.findElement(By.cssSelector("img[alt=\"��������� ��� �����\"]")).click();
    //String img2 = "http://cdn.astrio.ru/media/wysiwyg//home-page/slide-estet-0001.jpg";
    TimeUnit.SECONDS.sleep(5);
    String img2 = "2";
    assertEquals("", img2, driver.findElement(By.cssSelector("#container > div.block-main-banner.block-main-banner-rus > header > div.carousel-wrapper > div > ul > li.active")).getAttribute("data-init-position")); 
    
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector("img[alt=\"������ �������� �����������\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    //String img4 = "http://cdn.astrio.ru/media/wysiwyg//home-page/slide-autoexpert-001.jpg";
    String img4 = "3";
    assertEquals("", img4, driver.findElement(By.cssSelector("#container > div.block-main-banner.block-main-banner-rus > header > div.carousel-wrapper > div > ul > li.active")).getAttribute("data-init-position")); 
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
