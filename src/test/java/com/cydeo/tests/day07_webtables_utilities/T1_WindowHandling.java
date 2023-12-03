package com.cydeo.tests.day07_webtables_utilities;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T1_WindowHandling {

    /*
            TC #1: Window Handle practice
        1. Create new test and make set-ups
        2. Go to : https://www.amazon.com
        3. Copy and paste the lines from below into your class
        4. Create a logic to switch to the tab where Etsy.com is open
        5. Assert: Title contains “Etsy”
        Lines to be pasted:
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
        These lines will simply open new tabs using something called JavascriptExecutor
        and get those pages. We will learn JavascriptExecutor later as well.
     */
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //1--> setup, open, maximize and implicitly wait
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDownMethod(){
        //closing browser
        driver.quit();
    }

   @Test
   public void windowHandlingTest(){
       //2--> go to "https://www.amazon.com"
       driver.get("https://www.amazon.com");

       //3--> copy and paste the lines from below into your class
       ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
       ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
       ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");

       //4--> create a logic to switch to the tab where Etsy.com is open
       Set<String> windowHandles = driver.getWindowHandles();
       for (String each : windowHandles) {
           driver.switchTo().window(each);
          if (driver.getCurrentUrl().contains("etsy")){
              break;
          }
       }

       //5--> assert: Title contains “Etsy”
       Assert.assertTrue(driver.getTitle().contains("Etsy"));

   }

}
