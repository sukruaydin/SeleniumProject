package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_StateDropdown {

    /*
            TC #5: Selecting state from State dropdown and verifying result
        1. Open Chrome browser
        2. Go to http://practice.cybertekschool.com/dropdown
        3. Select Illinois
        4. Select Virginia
        5. Select California
        6. Verify final selected option is California.
        Use all Select options. (visible text, value, index)
     */

    WebDriver driver;

    @BeforeClass
    public void setUpMethod() throws InterruptedException {
        //1--> setup, open, implicitly wait and maximize the browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2--> go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
        Thread.sleep(1000);

    }

    @AfterClass
    public void tearDownMethod(){
        //7--> close browser
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        //3--> select Illinois, byVisibleText
        Select stateDropdown = new Select(driver.findElement(By.id("state")));
        stateDropdown.selectByVisibleText("Illinois");
        Thread.sleep(1000);

        //4--> select Virginia, byValue
        stateDropdown.selectByValue("VA");
        Thread.sleep(1000);

        //5--> select California, byIndex
        stateDropdown.selectByIndex(5);
        Thread.sleep(1000);

        //6--> verify final selected option is California.
        String actualText = stateDropdown.getFirstSelectedOption().getText();
        String expectedText = "California";

        Assert.assertEquals(actualText, expectedText, "they are NOT equal");
    }

}
