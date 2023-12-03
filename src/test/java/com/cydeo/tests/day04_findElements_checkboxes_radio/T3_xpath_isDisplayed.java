package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T3_xpath_isDisplayed {

    public static void main(String[] args) throws InterruptedException {

        /*
        XPATH Practice
        DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        TC #6: XPATH LOCATOR practice
            1. Open Chrome browser
            2. Go to http://practice.cydeo.com/multiple_buttons
            3. Click on Button 1
            4. Verify text displayed is as expected:
            Expected: “Clicked on button one!”
            USE XPATH LOCATOR FOR ALL WEB-ELEMENT LOCATORS
         */

        //1--> setup, open, maximize and implicitlyWait the driver
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2--> go to http://practice.cydeo.com/multiple_buttons
        driver.get("http://practice.cydeo.com/multiple_buttons");
        Thread.sleep(1000);

        //3--> click on Button 1
        //locating button 1
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        //clicking
        button1.click();
        Thread.sleep(1000);

        //4--> verify text displayed is as Expected: “Clicked on button one!”
        //locating textMessage
        WebElement textMessage = driver.findElement(By.xpath("//p[@id='result']"));
        //verifying isDisplayed
        System.out.println("textMessage.isDisplayed() = " + textMessage.isDisplayed());

        //5--> closing browser
        driver.close();


    }

}
