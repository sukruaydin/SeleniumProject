package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T6_StaleElementReferenceException {

    public static void main(String[] args) throws InterruptedException {

        /*
        TC #6: StaleElementReferenceException Task
            1- Open a Chrome browser
            2- Go to: https://practice.cydeo.com/abtest
            3- Locate “CYDEO” link, verify it is displayed.
            4- Refresh the page.
            5- Verify it is displayed, again.
            This is a simple StaleElementReferenceException to understand what is
            this exception and how to handle it.
         */

        //1--> setup, open, timeout, and maximize the browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2--> go to https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");
        Thread.sleep(1000);

        //3--> locate “CYDEO” link, verify it is displayed.
        //locating
        WebElement cydeoLink = driver.findElement(By.xpath("//a[@target='_blank']"));
        //verifying
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

        //4--> refresh the page
        driver.navigate().refresh();

        //WE ARE REFRESHING THE ELEMENT REFERENCE BY RE-ASSIGNING, WE ARE LOCATING IT AGAIN
        cydeoLink = driver.findElement(By.xpath("//a[@target='_blank']"));

        //5--> verify it is displayed, again
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

        //6--> closing browser
        driver.close();


    }

}
