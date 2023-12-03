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

public class T4_IframePractice {

    /*
            TC #4: Iframe practice
        1. Create a new class called: T4_Iframes
        2. Create new test and make set ups
        3. Go to: https://practice.cydeo.com/iframe
        4. Assert: “Your content goes here.” Text is displayed.
        5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        //1--> setup, open, maximize and implicitly wait the browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2--> go to "https://practice.cydeo.com/iframe"
        driver.get("https://practice.cydeo.com/iframe");
        Thread.sleep(1000);
    }

    @AfterMethod
    public void tearDownMethod(){
        //closing browser
        driver.close();
    }

    @Test
    public void testIframes_1(){
        //4--> assert: “Your content goes here.” Text is displayed.
        //switching to iframe
        WebElement iframe1 = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe1);
        //locating p tag
        WebElement text = driver.findElement(By.xpath("//p[.='Your content goes here.']"));

        String actualText = text.getText();
        String expectedText = "Your content goes here.";

        //re-focusing back to parent iframe
        driver.switchTo().parentFrame();

        //5--> assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        WebElement header = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));

        String actualHeader = header.getText();
        String expectedHeader = "An iFrame containing the TinyMCE WYSIWYG Editor";

        Assert.assertEquals(actualHeader, expectedHeader);

    }


}
