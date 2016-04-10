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

public class Blog_page extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled2() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
    	
    	driver.get(baseUrl + "blog/");
    	TimeUnit.SECONDS.sleep(5);
        assertEquals("������", driver.findElement(By.cssSelector("h1")).getText());
        assertEquals("", driver.findElement(By.id("blog-search")).getText());
        assertEquals("", driver.findElement(By.xpath("//*[@id='blog_search_mini_form']/div/button")).getText());
        assertEquals("�����", driver.findElement(By.cssSelector("div.block-title > span")).getText());
        assertEquals("�������", driver.findElement(By.xpath("//*[@id='sideRight']/div/div[1]/div[1]/div/span")).getText());
        assertEquals("�����", driver.findElement(By.cssSelector("div.block-archives > div.block-title > span")).getText());
        assertEquals("�����", driver.findElement(By.cssSelector("div.block-tags > div.block-title > span")).getText());
        
        driver.findElement(By.linkText("������������")).click();
        TimeUnit.SECONDS.sleep(5);
        assertEquals("���������-������������: ��� ��������� ������������ ��������-��������?", driver.findElement(By.linkText("���������-������������: ��� ��������� ������������ ��������-��������?")).getText());   
        assertEquals("", driver.findElement(By.cssSelector("img[alt=\"���������-������������ ��������-��������\"]")).getText());
        assertEquals("SEE MORE", driver.findElement(By.linkText("SEE MORE")).getText());
        assertEquals("�����", driver.findElement(By.cssSelector("div.post-tags-title")).getText());
        assertEquals("�������:", driver.findElement(By.cssSelector("div.post-posted-title")).getText());
        assertEquals("������", driver.findElement(By.cssSelector("div.block-blog-authors > div.block-title")).getText());
        assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Magento ����������\"]")).getText());
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
