package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTableOrderVerify {

    /*
            TC #1: Web table practice
        1. Go to: https://practice.cydeo.com/web-tables
        2. Verify Bob’s name is listed as expected.
        Expected: “Bob Martin”
        3. Verify Bob Martin’s order date is as expected
        Expected: 12/31/2021
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //1--> setup, open, maximize, and implicitly wait
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public  void tearDownMethod(){
        //closing browser
        driver.close();
    }

    @Test
    public void orderNameVerifyTest(){
        //1--> go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");
        BrowserUtils.sleep(2);

        //2--> verify Bob’s name is listed as expected, Expected: “Bob Martin”
        WebElement bobName = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
        String actualName = bobName.getText();
        String expectedName = "Bob Martin";

        Assert.assertEquals(actualName, expectedName);

        //3--> verify Bob Martin’s order date is as expected, Expected: 12/31/2021
        WebElement dateValue = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']//following-sibling::td[3]"));
        String actualDate = dateValue.getText();
        String expectedDate = "12/31/2021";


        Assert.assertEquals(actualDate, expectedDate);
    }

    @Test
    public void orderNameVerifyTest_2(){
        //to use returnOrderDate method

        //1--> go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");
        BrowserUtils.sleep(2);

        String customerOrderDate = WebTableUtils.returnOrderDate(driver, "Bob Martin");
        String expectedDate = "12/31/2021";

        Assert.assertEquals(customerOrderDate, expectedDate);
    }

    @Test
    public void orderNameVerifyTest_3(){
        //to user oderVerify method

        //1--> go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");
        BrowserUtils.sleep(2);

        WebTableUtils.orderVerify(driver, "Bob Martin", "12/31/2021");
    }



}
