package about;

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

public class Contact_us extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled6() throws Exception {
   // final WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(baseUrl + "/about");
    assertEquals("СВЯЗАТЬСЯ С НАМИ", driver.findElement(By.cssSelector("a.see-more")).getText());
    
    driver.findElement(By.cssSelector("a.see-more")).click();
    assertEquals("Обратная связь", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("Вы можете использовать форму, приведенную ниже, чтобы связаться с нами. Вы также можете отправлять вопросы на электронную почту info@turnkeye.com.", driver.findElement(By.cssSelector("h4")).getText());
    assertEquals("", driver.findElement(By.id("name")).getText());
    assertEquals("", driver.findElement(By.id("email")).getText());
    assertEquals("", driver.findElement(By.id("comment")).getText());
    assertEquals("ОТПРАВИТЬ", driver.findElement(By.cssSelector("button.button")).getText());
    
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
