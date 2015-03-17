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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Details extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled8() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
    	Actions actions = new Actions(driver);
        driver.get(baseUrl + "index.php/secretzone51");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("gbpljrhzxrf1530");
        driver.findElement(By.cssSelector("input.form-button")).click();
        actions.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']/li[8]/a/span"))).build().perform();
        driver.findElement(By.xpath("//ul[@id='nav']/li[8]/ul/li/a/span")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.cssSelector("a[name=\"position\"] > span.sort-title")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.xpath("//table[@id='portfolio_set_id_table']/tbody/tr/td[2]")).click();
        String store = driver.findElement(By.cssSelector("select[title='Store View'] optgroup option[selected='selected']")).getText();
        String client = null;
		    if(store == "Russian Store View"){
		    	driver.findElement(By.cssSelector("button[title='Back']")).click();
		    	TimeUnit.SECONDS.sleep(5);
		    	client = driver.findElement(By.xpath("//table[@id='portfolio_set_id_table']/tbody/tr/td[2]")).getText(); 	 
		    	 
		    }else{
	    		 driver.findElement(By.cssSelector("button[title='Back']")).click();
		    	 TimeUnit.SECONDS.sleep(5);
		    	 driver.findElement(By.xpath("//*[@id='portfolio_set_id_table']/tbody/tr[2]/td[2]")).click();
		    	 TimeUnit.SECONDS.sleep(5);
		    	 driver.findElement(By.cssSelector("button[title='Back']")).click();
		    	 TimeUnit.SECONDS.sleep(5);
		    	 client = driver.findElement(By.xpath("//*[@id='portfolio_set_id_table']/tbody/tr[2]/td[2]")).getText();
		    	 
	    	 }
            
        driver.get(baseUrl + "clients");
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.cssSelector("div.portfolio-item")).click();
        String client_test = driver.findElement(By.cssSelector("h1")).getText();
        assertEquals(client, client_test);
        driver.get(baseUrl + "clients");
        TimeUnit.SECONDS.sleep(5);
        actions.moveToElement(driver.findElement(By.cssSelector("div.portfolio-item  > img"))).build().perform();
        driver.findElement(By.linkText("Детали проекта")).click();
        TimeUnit.SECONDS.sleep(5);
    
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
