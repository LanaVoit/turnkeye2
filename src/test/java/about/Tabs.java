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

public class Tabs extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled5() throws Exception {
    driver.manage().window().setSize(new Dimension(1366, 1050));
    
    driver.get(baseUrl + "/about");
    assertEquals("� ����� ��������", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("���� ������ ������� ���� ������� ��� ������ Magento Enterprise & Magento Community �������.", driver.findElement(By.cssSelector("h4")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"����������� �������� Magento\"]")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"����������� �������� PayPal\"]")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Magento ������������\"]")).getText());
    assertEquals("��������� � ����", driver.findElement(By.cssSelector("a.see-more")).getText()); 
    
    driver.findElement(By.cssSelector("a[href=\"http://turnkeye.ru/about/meet_the_team.html\"]")).click();
    assertEquals("������������� � ����� ������� ��������.", driver.findElement(By.cssSelector("h4")).getText());
    assertEquals("���� �������", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("�������� ���������", driver.findElement(By.cssSelector("div.t-col-2 > h4")).getText());  
    
    driver.findElement(By.cssSelector("a[href=\"http://turnkeye.ru/about/vacancy.html\"]")).click();
    assertEquals("���� ��������", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("����� ������ ����� ������� �����.\n�� ������ ������ ��� ����� �� ���������� ������ � ����������:", driver.findElement(By.cssSelector("h4")).getText());
    assertEquals("����������-�����������", driver.findElement(By.cssSelector("h2.list-header")).getText());      
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
