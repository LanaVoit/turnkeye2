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
    	driver.manage().window().setSize(new Dimension(1366, 1050));
    	
        driver.get(baseUrl + "/clients/pinup-girl-clothing");
        assertEquals("Наши клиенты - Pinup Girl Clothing", driver.getTitle());
        assertEquals("Pinup Girl Clothing", driver.findElement(By.cssSelector("h1")).getText());
        String parentHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("/html/body/div/section/div/div/div[2]/div[2]/p/a")).click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        TimeUnit.SECONDS.sleep(10);
        driver.findElement(By.cssSelector("#close-button > a")).click();
        TimeUnit.SECONDS.sleep(5);
        assertEquals("", driver.findElement(By.cssSelector("img[alt=\"PinupGirlClothing.com\"]")).getText()); 
        //assertEquals("Welcome to Pinup Girl Clothing! Since 1999, Pin Up Girl, headed by Laura Byrnes, has specialized in the highest quality vintage inspired fashion, shoes and accessories for women of every size! Our original designs are cut to flatter your curves and make you look as beautiful as you feel, at prices to fit every budget. Pinup Girl Clothing is the first company to do more than pay lip service to the idea that beauty is not a size. We use models from size Extra Small to 4X to showcase our designs, featuring stunning editorial pinup photography by Laura, who is also the head designer for our signature line, Pinup Couture. Our designs can be found in thousands of boutiques across the globe, but online, we are the exclusive manufacturer and retailer of vintage inspired clothing lines Pinup Couture, Laura Byrnes California by Laura Byrnes, Deadly Dames by Micheline Pitt, and Dixiefried by Melanie Komenkul. We love our customers, and again, we're not just saying that: our Pinup Girl Clothing Facebook page has over 900,000 likes and counting, because it is an active, lively forum filled with loyal customers who not only sing our praises, but actually help other customers with questions about fit, sizing, and more. We enjoy and value this interaction with our customers and your comments and suggestions help us bring you even better designs and products, so please feel free to join us! We believe in hassle free, personalized service, delivered with sincerity and respect. Profit is important to us, but not at the expense of fun, and here at Pinup Girl Clothing, we love what we do and look forward to helping you look fabulous! Since 1999, the originator of Pinup Style: Couture for Every Body!", driver.findElement(By.cssSelector("td > div.std")).getText());
        
        driver.close();
        driver.switchTo().window(parentHandle);     
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
