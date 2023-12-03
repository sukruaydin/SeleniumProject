package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_T2_T3_Alert_Practices {

    /*
            TC #1: Information alert practice
        1. Open browser
        2. Go to website: http://practice.cydeo.com/javascript_alerts
        3. Click to “Click for JS Alert” button
        4. Click to OK button from the alert
        5. Verify “You successfully clicked an alert” text is displayed.
     */

    /*
            TC #2: Confirmation alert practice
        1. Open browser
        2. Go to website: http://practice.cydeo.com/javascript_alerts
        3. Click to “Click for JS Confirm” button
        4. Click to OK button from the alert
        5. Verify “You clicked: Ok” text is displayed.

     */

    /*
            TC #3: Information alert practice
        1. Open browser
        2. Go to website: http://practice.cydeo.com/javascript_alerts
        3. Click to “Click for JS Prompt” button
        4. Send “hello” text to alert
        5. Click to OK button from the alert
        6. Verify “You entered: hello” text is displayed.
     */


    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        //1--> setup, open, maximize and implicitly wait the browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2--> go to "http://practice.cydeo.com/javascript_alerts"
        driver.get("http://practice.cydeo.com/javascript_alerts");
        Thread.sleep(1000);
    }

    @AfterMethod
    public void tearDownMethod(){
        //closing browser
        driver.close();
    }

    @Test
    public void alertTest1() throws InterruptedException {
        //3--> click to “Click for JS Alert” button
        //locating button
        WebElement jsAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        //clicking
        jsAlertButton.click();
        Thread.sleep(1000);

        //4--> click to OK button from the alert
        //in order to click to alert button --> we have to switch driver's attention to Alert itself
        Alert alertOKButton = driver.switchTo().alert();
        alertOKButton.accept();
        Thread.sleep(1000);

        //5--> verify “You successfully clicked an alert” text is displayed.
        //locating the text
        WebElement textMessage = driver.findElement(By.xpath("//p[@id='result']"));

        String actualTextMessage = textMessage.getText();
        String expectedTextMessage = "You successfully clicked an alert";

        Assert.assertTrue(textMessage.isDisplayed());
        Assert.assertEquals(actualTextMessage, expectedTextMessage);
    }

    @Test
    public void alertTest2() throws InterruptedException {
        //3--> click to “Click for JS Confirm” button
        WebElement jsConfirmButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirmButton.click();
        Thread.sleep(1000);

        //4--> click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5--> verify “You clicked: Ok” text is displayed.
        WebElement text = driver.findElement(By.id("result"));
        System.out.println("You clicked: Ok is displayed = " + text.isDisplayed());
    }

    @Test
    public void alertTest3() throws InterruptedException {
        //3--> click to “Click for JS Prompt” button
        WebElement jsPromptButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPromptButton.click();
        Thread.sleep(1000);

        //4--> send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        Thread.sleep(1000);

        //5--> click to OK button from the alert
        alert.dismiss();
        Thread.sleep(1000);

        //6--> verify “You entered: hello” text is displayed.
    }
}
