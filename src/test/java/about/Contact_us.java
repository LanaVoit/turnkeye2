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
    driver.manage().window().setSize(new Dimension(1366, 1050));
    
    driver.get(baseUrl + "/about");
    assertEquals("��������� � ����", driver.findElement(By.cssSelector("a.see-more")).getText());  
    
    driver.findElement(By.cssSelector("a.see-more")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("�������� �����", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("�� ������ ������������ �����, ����������� ����, ����� ��������� � ����. �� ����� ������ ���������� ������� �� ����������� ����� hello@astrio.ru.", driver.findElement(By.cssSelector("h4")).getText());
    assertEquals("", driver.findElement(By.id("name")).getText());
    assertEquals("", driver.findElement(By.id("email")).getText());
    assertEquals("", driver.findElement(By.id("comment")).getText());
    assertEquals("���������", driver.findElement(By.cssSelector("button.button")).getText());       
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
