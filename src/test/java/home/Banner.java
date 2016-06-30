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
    	if (1 == 1) {
    		throw new NoSuchElementException("ololo");
    	}
    	
    driver.manage().window().setSize(new Dimension(1366, 1050));
    
    driver.get(baseUrl);

    //String img1 = "http://cdn.astrio.ru/skin/frontend/default/turnkeye/images/main-banner/large/slide1-moscow.jpg";
    String img1 = "http://astrio.ru/skin/frontend/default/turnkeye/images/main-banner/large/xslide1-moscow.jpg.pagespeed.ic.S_XOMwWK_i.webp1";
    assertEquals("", img1, driver.findElement(By.cssSelector("#container > div.block-main-banner.block-main-banner-rus > header > div.carousel-wrapper > div > ul > li:nth-child(1) > img")).getAttribute("src"));  

    
    driver.findElement(By.cssSelector("img[alt=\"Ювелирный дом Эстет\"]")).click();
    //String img2 = "http://cdn.astrio.ru/media/wysiwyg//home-page/slide-estet-0001.jpg";
    TimeUnit.SECONDS.sleep(5);
    String img2 = "http://astrio.ru/media/wysiwyg/main-banner/home-original/xslide-estet.jpg.pagespeed.ic.DUq4u9T2xS.webp";
    assertEquals("", img2, driver.findElement(By.cssSelector("#container > div.block-main-banner.block-main-banner-rus > header > div.carousel-wrapper > div > ul > li.active > img")).getAttribute("src")); 
    
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector("img[alt=\"Группа компаний Автоэксперт\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    //String img4 = "http://cdn.astrio.ru/media/wysiwyg//home-page/slide-autoexpert-001.jpg";
    String img4 = "http://astrio.ru/media/wysiwyg/main-banner/home-original/xslide-autoexpert.jpg.pagespeed.ic.49vj8KFzAw.webp";
    assertEquals("", img4, driver.findElement(By.cssSelector("#container > div.block-main-banner.block-main-banner-rus > header > div.carousel-wrapper > div > ul > li.active > img")).getAttribute("src")); 
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
