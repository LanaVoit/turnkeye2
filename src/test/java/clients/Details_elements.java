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
    assertEquals("Посетить сайт >", driver.findElement(By.linkText("Посетить сайт >")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"OneCA\"]")).getText());
    assertEquals("ICARPC >", driver.findElement(By.cssSelector(".next-project")).getText());
    assertEquals("< VIKING 360", driver.findElement(By.cssSelector(".prev-project")).getText());
    assertEquals("OneCA.ru, магазин одежды, обуви и аксессуаров", driver.findElement(By.cssSelector("ul.key-options.cols-4 > li > span")).getText());
    assertEquals("ONECA.RU, ИНТЕРНЕТ-МАГАЗИН ОДЕЖДЫ, ОБУВИ, АКСЕССУАРОВ И МОДЫ, БЫЛ СОЗДАН ПРОФЕССИОНАЛАМИ, УСПЕШНО РАБОТАЮЩИМИ НА РЫНКЕ МОДЫ В РОССИИ С 1991 ГОДА.", driver.findElement(By.cssSelector("h3")).getText());
    assertEquals("СОЗДАНИЕ УНИКАЛЬНОГО ДИЗАЙНА", driver.findElement(By.cssSelector("ul.list-services > li")).getText());
    assertEquals("ИНТЕГРАЦИЯ ДИЗАЙНА В MAGENTO", driver.findElement(By.xpath("//div[@id='content']/div[2]/div[2]/ul/li[2]")).getText());
    assertEquals("РАЗРАБОТКА MAGENTO МОДУЛЕЙ", driver.findElement(By.xpath("//div[@id='content']/div[2]/div[2]/ul/li[3]")).getText());
    assertEquals("ОПТИМИЗАЦИЯ ПРОИЗВОДИТЕЛЬНОСТИ", driver.findElement(By.xpath("//div[@id='content']/div[2]/div[2]/ul/li[4]")).getText());
    assertEquals("ПОДДЕРЖКА И КОНСУЛЬТИРОВАНИЕ", driver.findElement(By.xpath("//div[@id='content']/div[2]/div[2]/ul/li[5]")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Главная страница\"]")).getText());
    assertEquals("КОМАНДА ПРОЕКТА", driver.findElement(By.cssSelector("div.team-behind > h3")).getText());
    assertEquals("Этот проект был создан нашими\nсертифицированными специалистами:", driver.findElement(By.cssSelector("div.team-behind > h4")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Менеджер проекта\"]")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Ведущий разработчик\"]")).getText());
    assertEquals("", driver.findElement(By.xpath("(//img[@alt='Ведущий разработчик'])[2]")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Разработчик\"]")).getText());
    assertEquals("", driver.findElement(By.xpath("(//img[@alt='Разработчик'])[2]")).getText());
    assertEquals("", driver.findElement(By.xpath("(//img[@alt='Разработчик'])[3]")).getText());
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"QA-специалист\"]")).getText());    	
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
