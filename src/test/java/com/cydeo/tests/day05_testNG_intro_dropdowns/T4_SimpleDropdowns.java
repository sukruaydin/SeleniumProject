package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_SimpleDropdowns {

    /*
            TC#4: Verifying “Simple dropdown” and “State selection” dropdown
        default values
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/dropdown
        3. Verify “Simple dropdown” default selected value is correct
        Expected: “Please select an option”
        4. Verify “State selection” default selected value is correct
        Expected: “Select a State”
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //1--> setup, open, implicitly wait, and maximize browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2--> go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void tearDownMethod(){
        //5--> closing browser
        driver.close();
    }

    @Test
    public void simpleDropdownTest1(){
        //3--> verify “Simple dropdown” default selected value is correct, Expected: “Please select an option”
        Select optionDropdown = new Select(driver.findElement(By.id("dropdown")));
        String actualText = optionDropdown.getFirstSelectedOption().getText();
        String expectedText = "Please select an option";

        Assert.assertEquals(actualText, expectedText, "they are NOT equal");
    }

    @Test
    public void simpleDropdownTest2(){
        //4--> verify “State selection” default selected value is correct, Expected: “Select a State”
        Select stateDropdown = new Select(driver.findElement(By.id("state")));
        String actualText = stateDropdown.getFirstSelectedOption().getText();
        String expectedText = "Select a State";

        Assert.assertTrue(actualText.equals(expectedText), "they are NOT equal");

    }

}
