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

public class Details_elements extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled9() throws Exception {
    //	final WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    driver.get(baseUrl + "/portfolio");
    assertEquals("ONECA", driver.findElement(By.cssSelector("p.client-name")).getText());
    assertEquals("One Click Away", driver.findElement(By.linkText("One Click Away")).getText());
    driver.findElement(By.linkText("One Click Away")).click();
    assertEquals("One Click Away", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("�������� ���� >", driver.findElement(By.linkText("�������� ���� >")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"OneCA\"]")).getText());
    assertEquals("ICARPC >", driver.findElement(By.cssSelector(".next-project")).getText());
    assertEquals("< VIKING 360", driver.findElement(By.cssSelector(".prev-project")).getText());
    assertEquals("OneCA.ru, ������� ������, ����� � �����������", driver.findElement(By.cssSelector("ul.key-options.cols-4 > li > span")).getText());
    assertEquals("ONECA.RU, ��������-������� ������, �����, ����������� � ����, ��� ������ ���������������, ������� ����������� �� ����� ���� � ������ � 1991 ����.", driver.findElement(By.cssSelector("h3")).getText());
    assertEquals("�������� ����������� �������", driver.findElement(By.cssSelector("ul.list-services > li")).getText());
    assertEquals("���������� ������� � MAGENTO", driver.findElement(By.xpath("//div[@id='content']/div[2]/div[2]/ul/li[2]")).getText());
    assertEquals("���������� MAGENTO �������", driver.findElement(By.xpath("//div[@id='content']/div[2]/div[2]/ul/li[3]")).getText());
    assertEquals("����������� ������������������", driver.findElement(By.xpath("//div[@id='content']/div[2]/div[2]/ul/li[4]")).getText());
    assertEquals("��������� � ����������������", driver.findElement(By.xpath("//div[@id='content']/div[2]/div[2]/ul/li[5]")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"������� ��������\"]")).getText());
    assertEquals("������� �������", driver.findElement(By.cssSelector("div.team-behind > h3")).getText());
    assertEquals("���� ������ ��� ������ ������\n������������������ �������������:", driver.findElement(By.cssSelector("div.team-behind > h4")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"�������� �������\"]")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"������� �����������\"]")).getText());
    assertEquals("", driver.findElement(By.xpath("(//img[@alt='������� �����������'])[2]")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"�����������\"]")).getText());
    assertEquals("", driver.findElement(By.xpath("(//img[@alt='�����������'])[2]")).getText());
    assertEquals("", driver.findElement(By.xpath("(//img[@alt='�����������'])[3]")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"QA-����������\"]")).getText());    	
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"oneca\"]")).getText());
    
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
