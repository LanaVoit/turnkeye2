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
import org.openqa.selenium.support.ui.Select;

public class Search extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled3() throws Exception {
      driver.manage().window().setSize(new Dimension(1366, 1050));
      
      driver.get(baseUrl + "blog/");
      TimeUnit.SECONDS.sleep(5);
      assertEquals("", driver.findElement(By.id("blog-search")).getText());
      assertEquals("", driver.findElement(By.xpath("//*[@id='blog_search_mini_form']/div/button")).getText());
      driver.findElement(By.id("blog-search")).clear();
      driver.findElement(By.id("blog-search")).sendKeys("“≈—“»–Œ¬¿Õ»≈");
      driver.findElement(By.xpath("//*[@id='blog_search_mini_form']/div/button")).click();
      TimeUnit.SECONDS.sleep(5);
      assertEquals("“ÂÒÚËÓ‚‡ÌËÂ", driver.findElement(By.cssSelector("h1")).getText());
      driver.findElement(By.cssSelector("a[href=\"http://astrio.ru/blog/usability-testing/\"]")).click();
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
