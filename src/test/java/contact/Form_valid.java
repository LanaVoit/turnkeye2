package contact;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import java.io.IOException;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

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

import contact.Form_valid.GetMulti;

public class Form_valid extends turnkeye2.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled6() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
        Actions actions = new Actions(driver);
        driver.get(baseUrl + "index.php/secretzone51");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("gbpljrhzxrf1530");
        driver.findElement(By.cssSelector("input.form-button")).click();
        actions.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']/li[11]/a/span"))).build().perform();    
        driver.findElement(By.xpath("//ul[@id='nav']/li[11]/ul/li[15]/a/span")).click();
        driver.findElement(By.xpath("//ul[@id='system_config_tabs']/li/dl/dd[6]/a/span")).click();
        driver.findElement(By.id("contacts_email_recipient_email")).clear();
        driver.findElement(By.id("contacts_email_recipient_email")).sendKeys("qatestingtestqa@gmail.com");
        driver.findElement(By.cssSelector("button[title=\"Save Config\"]")).click();
        assertEquals("The configuration has been saved.", driver.findElement(By.cssSelector("li > span")).getText());
        actions.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']/li[11]/a/span"))).build().perform();    
        driver.findElement(By.xpath("//ul[@id='nav']/li[11]/ul/li[11]/a/span")).click();
        driver.findElement(By.linkText("Select All")).click();
        driver.findElement(By.cssSelector("button[title=\"Submit\"]")).click();
        assertEquals("7 cache type(s) refreshed.", driver.findElement(By.cssSelector("li > span")).getText());
        
        driver.get(baseUrl + "/contact_us.html");
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("test");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("qatestingtestqa@gmail.com");
        driver.findElement(By.id("comment")).clear();
        driver.findElement(By.id("comment")).sendKeys("test message");
        driver.findElement(By.cssSelector("button.button")).click();
        TimeUnit.SECONDS.sleep(5);
        assertEquals("Ваше сообщение получено и мы ответим на него в ближайшее время. Спасибо за сообщение.", driver.findElement(By.cssSelector("li > span")).getText());
        TimeUnit.SECONDS.sleep(10);
        	driver.get(baseUrl + "/contact_us.html");
        	class MailAuthenticator extends Authenticator {
       		 
        	    public PasswordAuthentication getPasswordAuthentication() {
        	         return new PasswordAuthentication("qatestingtestqa@gmail.com", "parol123");
        	    }
        	}
        	
        	Properties props = new Properties();
        	
        	props.put("mail.smtp.user", "qatestingtestqa@gmail.com");
        	props.put("mail.host", "pop.gmail.com");
        	props.put("mail.store.protocol", "pop3s");
            props.put("mail.pop3s.auth", "true");
            props.put("mail.pop3s.port", 995);
        	props.put("mail.smtp.starttls.enable","true");
        	props.put("mail.smtp.debug", "true");
        	props.put("mail.smtp.auth", "true");
        	props.put("mail.smtp.socketFactory.port", 995);
        	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        	props.put("mail.smtp.socketFactory.fallback", "false");

        	Session session = Session.getInstance(props, new MailAuthenticator());
        	session.setDebug(true);
    	       	  
        	

        	
    	        Store store = session.getStore("pop3s");
    	        store.connect("pop.gmail.com", "qatestingtestqa@gmail.com", "parol123");
    	 
    	        Folder inbox = store.getFolder("INBOX");
    	        inbox.open(Folder.READ_ONLY);
    	        
    	        Message[] messages = inbox.getMessages();
    	        
    	           
    	        GetMulti gmulti = new GetMulti();
    	        String textMessage = gmulti.getText(messages[messages.length - 1]);
    	        String regex = "Comment: test message";
    	        Pattern p = Pattern.compile(regex);
    	        Matcher m = p.matcher(textMessage);
    	        if (m.find()) {
    	        	    driver.get(baseUrl + "/contact_us.html");
    	        	    driver.findElement(By.id("comment")).clear();
    	        	    driver.findElement(By.id("comment")).sendKeys(m.group());
    	        	TimeUnit.SECONDS.sleep(5);
    	        	   
    	        }
    	        inbox.close(false);
    	        store.close(); 
    	        driver.get(baseUrl + "/contact_us.html");
    	        driver.quit();  
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
  public class GetMulti {
	    
	    public  boolean textIsHtml = false;
	 
	    /**
	     * Return the primary text content of the message.
	     */
	    public String getText(Part p) throws MessagingException, IOException {
	        if (p.isMimeType("text/*")) {
	            String s = (String)p.getContent();
	            textIsHtml = p.isMimeType("text/html");
	            return s;
	        }
	 
	        if (p.isMimeType("multipart/alternative")) {
	            // prefer html text over plain text
	            Multipart mp = (Multipart)p.getContent();
	            String text = null;
	            for (int i = 0; i < mp.getCount(); i++) {
	                Part bp = mp.getBodyPart(i);
	                if (bp.isMimeType("text/plain")) {
	                    if (text == null)
	                        text = getText(bp);
	                    continue;
	                } else if (bp.isMimeType("text/html")) {
	                    String s = getText(bp);
	                    if (s != null)
	                        return s;
	                } else {
	                    return getText(bp);
	                }
	            }
	            return text;
	        } else if (p.isMimeType("multipart/*")) {
	            Multipart mp = (Multipart)p.getContent();
	            for (int i = 0; i < mp.getCount(); i++) {
	                String s = getText(mp.getBodyPart(i));
	                if (s != null)
	                    return s;
	            }
	        }
	 
	        return null;
	    }
	 
	}
}
