package clients;

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

public class Navigation extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled10() throws Exception {
    //	final WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    driver.get(baseUrl + "/portfolio");
    assertEquals("ONECA", driver.findElement(By.cssSelector("p.client-name")).getText());
    assertEquals("One Click Away", driver.findElement(By.linkText("One Click Away")).getText());
    driver.findElement(By.linkText("One Click Away")).click();
    assertEquals("One Click Away", driver.findElement(By.cssSelector("h1")).getText());
    
    assertEquals("ICARPC >", driver.findElement(By.cssSelector(".next-project")).getText());
    assertEquals("< VIKING 360", driver.findElement(By.cssSelector(".prev-project")).getText());
    
    driver.findElement(By.cssSelector(".next-project")).click();
    assertEquals("iCarPC", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("GOLDEN EDIBLES >", driver.findElement(By.cssSelector(".next-project")).getText());
    
    driver.findElement(By.cssSelector(".next-project")).click();
    assertEquals("Golden Edibles", driver.findElement(By.cssSelector("h1")).getText());
    
    driver.findElement(By.cssSelector(".prev-project")).click();
    assertEquals("iCarPC", driver.findElement(By.cssSelector("h1")).getText());
    
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
