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
    driver.findElement(By.linkText("ÒÅÑÒÈĞÎÂÀÍÈÅ")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector("a[href=\"http://astrio.ru/blog/usability-testing/\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("ŞÇÀÁÈËÈÒÈ-ÒÅÑÒÈĞÎÂÀÍÈÅ: ÊÀÊ ÓÂÅËÈ×ÈÒÜ ÏĞÈÁÛËÜÍÎÑÒÜ ÈÍÒÅĞÍÅÒ-ÌÀÃÀÇÈÍÀ?", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Şçàáèëèòè-òåñòèğîâàíèå èíòåğíåò-ìàãàçèíà\"]")).getText());
    TimeUnit.SECONDS.sleep(5);
    assertEquals("", driver.findElement(By.id("blog-search")).getText());
    assertEquals("", driver.findElement(By.xpath("//*[@id='blog_search_mini_form']/div/button")).getText());
    assertEquals("Ïîèñê", driver.findElement(By.cssSelector("div.block-title > span")).getText());
    assertEquals("Ğàçäåëû", driver.findElement(By.xpath("//*[@id='sideRight']/div/div[1]/div[1]/div/span")).getText());
    
    assertEquals("ÑÂÅÒËÀÍÀ ÁÀĞÀÍÎÂÀ", driver.findElement(By.cssSelector("div.author-name")).getText());
    assertEquals("ÎÏÓÁËÈÊÎÂÀÍÎ Â", driver.findElement(By.cssSelector("div.post-posted-title")).getText());
    assertEquals("ÌÅÒÊÈ", driver.findElement(By.cssSelector("div.post-tags-title")).getText());
    assertEquals("Íàïèñàòü Êîììåíòàğèé!", driver.findElement(By.cssSelector("div.legend")).getText());
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
