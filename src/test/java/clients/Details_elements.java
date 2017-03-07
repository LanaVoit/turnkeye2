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
    	driver.manage().window().setSize(new Dimension(1366, 1050));
    	
	    driver.get(baseUrl + "/clients/pinup-girl-clothing");
	    driver.navigate().refresh();
	    assertEquals("Наши клиенты - Pinup Girl Clothing | ASTRIO", driver.getTitle());
	    assertEquals("Pinup Girl Clothing", driver.findElement(By.cssSelector("h1")).getText());
//	    assertEquals("https://astrio.ru/media/wysiwyg/portfolio/PinupClothing/top-banner.jpg", driver.findElement(By.cssSelector("#content > div.turnkeye-portfolio > div.block-portfolio-banner > img.shadows-image")).getAttribute("src"));
//	    assertEquals("https://astrio.ru/media/wysiwyg/portfolio/PinupClothing/top-mobile.png", driver.findElement(By.xpath("//div[@id='content']/div[2]/div[3]/img[2]")).getAttribute("src"));
	    assertEquals("Обзор проекта", driver.findElement(By.cssSelector("h3")).getText()); 
	    assertEquals("О проекте Pinup Girl Clothing", driver.findElement(By.cssSelector("div.block-about-project > h3")).getText());
	    assertEquals("Примеры реализации", driver.findElement(By.cssSelector("div.block-have-done > h3")).getText());
	    assertEquals("Адаптивный дизайн", driver.findElement(By.cssSelector("h4")).getText());
	    assertEquals("Вход через социальные сети", driver.findElement(By.xpath("//div[@id='content']/div[2]/div[6]/div[2]/div/div/h4")).getText());
	    assertEquals("Блок социальных активностей", driver.findElement(By.xpath("//div[@id='content']/div[2]/div[6]/div[3]/div/div/h4")).getText());
	    assertEquals("Amazon WishList", driver.findElement(By.xpath("//div[@id='content']/div[2]/div[6]/div[4]/div/div/h4")).getText());
	    assertEquals("The Look: подсказки для выбора комплекта к товару", driver.findElement(By.xpath("//div[@id='content']/div[2]/div[6]/div[5]/div/div/h4")).getText());
	    assertEquals("Love it", driver.findElement(By.xpath("//div[@id='content']/div[2]/div[6]/div[6]/div/div/h4")).getText());
	    assertEquals("LookBook", driver.findElement(By.xpath("//div[@id='content']/div[2]/div[6]/div[7]/div/div/h4")).getText());
	    assertEquals("ОТЗЫВ КЛИЕНТА", driver.findElement(By.cssSelector("h3 > span")).getText());
	    assertEquals("О НАШЕЙ РАБОТЕ", driver.findElement(By.xpath("//div[@id='content']/div[2]/div[7]/h3/span[2]/span")).getText());
	    assertEquals("Контакты", driver.findElement(By.linkText("Контакты")).getText());
	    assertEquals("EMAIL", driver.findElement(By.xpath("/html/body/div/section/div/div/div[2]/div[9]/div/a[2]")).getText());
	    assertEquals("Skype", driver.findElement(By.cssSelector("a.block-skype > span")).getText());
	    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
	            ,driver.findElement(By.cssSelector("h1")));
	    driver.findElement(By.cssSelector("span.icon-right-open")).click();
	    TimeUnit.SECONDS.sleep(5);
	    assertEquals("First Boutique", driver.findElement(By.cssSelector("h1")).getText());    
	    driver.findElement(By.cssSelector("span.icon-left-open")).click();
	    TimeUnit.SECONDS.sleep(5);
	    assertEquals("Pinup Girl Clothing", driver.findElement(By.cssSelector("h1")).getText());
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
