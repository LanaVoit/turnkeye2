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

public class Website extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled7() throws Exception {
    //	final WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    driver.get(baseUrl + "/portfolio");
    assertEquals("ONECA", driver.findElement(By.cssSelector("p.client-name")).getText());
    assertEquals("One Click Away", driver.findElement(By.linkText("One Click Away")).getText());
    driver.findElement(By.linkText("One Click Away")).click();
    assertEquals("One Click Away", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"OneCA\"]")).getText());
    assertEquals("Ïîñåòèòü ñàéò >", driver.findElement(By.linkText("Ïîñåòèòü ñàéò >")).getText());
    
    
    String parentHandle = driver.getWindowHandle();
    driver.findElement(By.linkText("Ïîñåòèòü ñàéò >")).click();
    for (String winHandle : driver.getWindowHandles()) {
        driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
    }
   
    assertEquals("", driver.findElement(By.cssSelector("img.img-responsive")).getText());
    assertEquals("ÈÍÒÅÐÍÅÒ-ÌÀÃÀÇÈÍ ONECA.RU", driver.findElement(By.cssSelector("div.col-md-12.col-lg-12 > h2")).getText());
    
    driver.close();
    driver.switchTo().window(parentHandle);
   // driver.quit();
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
