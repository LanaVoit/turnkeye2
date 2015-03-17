package services;

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

public class Page extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled2() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
    driver.get(baseUrl + "/services/magento_development.html");
        assertEquals("���������� ������ �� Magento", driver.findElement(By.cssSelector("h1")).getText());
        assertEquals("���������� ������ �� MAGENTO", driver.findElement(By.cssSelector("li.active > span")).getText());
        assertEquals("MAGENTO ��� ������", driver.findElement(By.linkText("MAGENTO ��� ������")).getText());
        assertEquals("", driver.findElement(By.cssSelector("img[alt=\"�� ������������ Meet Magento ������\"]")).getText());
        assertEquals("", driver.findElement(By.cssSelector("img[alt=\"�� ����������������� Magento ������������\"]")).getText());
        assertEquals("�� ���������� ���������������� ������ �� �������� ����������� ��������� �� ��������� MAGENTO.", driver.findElement(By.cssSelector("h3")).getText());
        assertEquals("�� ���������� �GILE", driver.findElement(By.xpath("//div[@id='content']/div[2]/div/section/h3[2]")).getText());
        assertEquals("5-������ ����\n�AGENTO-����������", driver.findElement(By.xpath("//div[@id='content']/div[2]/div/section/h3[3]")).getText());
        assertEquals("�� ����������� 100% ��������", driver.findElement(By.cssSelector("div.block-grey.quality > h3")).getText());
        assertEquals("�� ������ ����������� �������, ��� �������� �� ��������, � ����� ���������.", driver.findElement(By.cssSelector("h4.list-header")).getText());
        assertEquals("������� �������������", driver.findElement(By.cssSelector("div.development-team > h3")).getText());
        assertEquals("�� �������� ������������ ���������� Magento � ������.\n���� ����������� ������ ������������� ������������ �� Magento ����������.", driver.findElement(By.cssSelector("div.development-team > h4")).getText());       

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
