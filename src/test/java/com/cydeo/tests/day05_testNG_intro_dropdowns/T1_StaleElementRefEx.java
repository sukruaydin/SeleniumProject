package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementRefEx {

    public static void main(String[] args) throws InterruptedException {

        /*
                            XPATH PRACTICES
        DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.

        TC #1: StaleElementReferenceException handling
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/add_remove_elements/
        3. Click to “Add Element” button
        4. Verify “Delete” button is displayed after clicking.
        5. Click to “Delete” button.
        6. Verify “Delete” button is NOT displayed after clicking.

        USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS*/

        //1--> setup, open, maximize and timeout the browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2--> go to "https://practice.cydeo.com/add_remove_elements/"
        driver.get("https://practice.cydeo.com/add_remove_elements/");
        Thread.sleep(1000);

        //3--> click "Add Element" button
        //location add element button
        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        //clicking the button
        addElementButton.click();
        Thread.sleep(1000);

        //4--> verify “Delete” button is displayed after clicking.
        //locating delete button
        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        //verifying deleteButton is displayed
        System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());

        //5--> click to “Delete” button.
        deleteButton.click();
        Thread.sleep(1000);

        //6--> verify “Delete” button is NOT displayed after clicking.
        try {
            System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());
        }catch (StaleElementReferenceException  e){
            System.out.println("StaleElementReferenceException is thrown");
            System.out.println("This means the element is completely deleted from the page");
        }

        //7--> closing browser
        driver.close();

    }

}
