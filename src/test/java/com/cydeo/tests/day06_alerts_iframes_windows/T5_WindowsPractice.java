package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_WindowsPractice {

    /*
            TC #5: Window Handle practice
        1. Create a new class called: T5_WindowsPractice
        2. Create new test and make set ups
        3. Go to : https://practice.cydeo.com/windows
        4. Assert: Title is “Windows”
        5. Click to: “Click Here” link
        6. Switch to new Window.
        7. Assert: Title is “New Window”
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        //1--> setup, open, maximize and implicitly wait the browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2--> go to "https://practice.cydeo.com/windows"
        driver.get("https://practice.cydeo.com/windows");
        Thread.sleep(1000);
    }

    @AfterMethod
    public void tearDownMethod(){
        //closing browser
       // driver.quit();
    }

    @Test
    public void windowHandleTest() throws InterruptedException {

        //storing main handle is good practice for future re-use purposes
        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        //4--> assert: Title is “Windows”
        Assert.assertEquals(driver.getTitle(), "Windows");

        //5--> click to: “Click Here” link
        //locating "click here" link
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        //clicking
        clickHereLink.click();
        Thread.sleep(1000);

        //6--> switch to new Window.
        //handling and switching the new window
        for (String each : driver.getWindowHandles()) {
            driver.switchTo().window(each);
            System.out.println("current title: " + driver.getTitle());
        }

        //7--> assert: Title is “New Window”
        Assert.assertEquals(driver.getTitle(), "New Window");

    }

}
