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
    String img1 = "http://astrio.ru/skin/frontend/default/turnkeye/images/main-banner/large/2000x520xslide1-moscow.jpg.pagespeed.ic.6QQP1U0tX-.webp";
    assertEquals("", img1, driver.findElement(By.cssSelector("img[src=\"http://astrio.ru/skin/frontend/default/turnkeye/images/main-banner/large/2000x520xslide1-moscow.jpg.pagespeed.ic.6QQP1U0tX-.webp\"]")).getAttribute("src"));  

    
    driver.findElement(By.cssSelector("img[alt=\"Ювелирный дом Эстет\"]")).click();
    //String img2 = "http://cdn.astrio.ru/media/wysiwyg//home-page/slide-estet-0001.jpg";
    String img2 = "http://astrio.ru/media/wysiwyg/main-banner/home-original/Nx520xslide-estet.jpg.pagespeed.ic.a1zdO-4m4e.webp";
    assertEquals("", img2, driver.findElement(By.cssSelector("img[src=\"http://astrio.ru/media/wysiwyg/main-banner/home-original/Nx520xslide-estet.jpg.pagespeed.ic.a1zdO-4m4e.webp\"]")).getAttribute("src")); 
    
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector("img[alt=\"Группа компаний Автоэксперт\"]")).click();
    //String img4 = "http://cdn.astrio.ru/media/wysiwyg//home-page/slide-autoexpert-001.jpg";
    String img4 = "http://astrio.ru/media/wysiwyg/main-banner/home-original/Nx520xslide-autoexpert.jpg.pagespeed.ic.Yjxfai3-Cu.webp";
    assertEquals("", img4, driver.findElement(By.cssSelector("img[src=\"http://astrio.ru/media/wysiwyg/main-banner/home-original/Nx520xslide-autoexpert.jpg.pagespeed.ic.Yjxfai3-Cu.webp\"]")).getAttribute("src")); 
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
