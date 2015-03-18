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

public class Details_page extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled() throws Exception {
    driver.manage().window().setSize(new Dimension(1366, 1050));
    
    driver.get(baseUrl + "blog/");
    driver.findElement(By.linkText("ТЕСТИРОВАНИЕ")).click();
    driver.findElement(By.cssSelector("a[href=\"http://turnkeye.ru/blog/usability-testing/\"]")).click();
    assertEquals("ЮЗАБИЛИТИ-ТЕСТИРОВАНИЕ: КАК УВЕЛИЧИТЬ ПРИБЫЛЬНОСТЬ ИНТЕРНЕТ-МАГАЗИНА?", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Юзабилити-тестирование интернет-магазина\"]")).getText());
    assertEquals("", driver.findElement(By.cssSelector("input.gsc-search-button.gsc-search-button-v2")).getText());
    assertEquals("Разделы", driver.findElement(By.cssSelector("div.block-title > span")).getText());
    assertEquals("Метки", driver.findElement(By.cssSelector("div.block-tags > div.block-title > span")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Magento разработка\"]")).getText());
    assertEquals("СВЕТЛАНА БАРАНОВА", driver.findElement(By.cssSelector("div.author-name")).getText());
    assertEquals("ОПУБЛИКОВАНО В", driver.findElement(By.cssSelector("div.post-posted-title")).getText());
    assertEquals("МЕТКИ", driver.findElement(By.cssSelector("div.post-tags-title")).getText());
    assertEquals("Написать Комментарий!", driver.findElement(By.cssSelector("div.legend")).getText());
    assertEquals("", driver.findElement(By.id("user")).getText());
    assertEquals("", driver.findElement(By.id("email")).getText());
    assertEquals("", driver.findElement(By.id("comment")).getText());
    assertEquals("", driver.findElement(By.cssSelector("input.button.form-button")).getText()); 
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
