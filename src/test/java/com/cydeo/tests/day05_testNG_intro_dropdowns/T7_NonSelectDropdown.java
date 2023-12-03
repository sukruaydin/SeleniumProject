package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T7_NonSelectDropdown {

    /*
            TC #7: Selecting value from non-select dropdown
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/dropdown
        3. Click to non-select dropdown
        4. Select Facebook from dropdown
        5. Verify title is “Facebook - Giriş Yap veya Kaydol”
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        //1--> setup, open, implicitly wait, and maximize the browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2--> get to "https://practice.cydeo.com/dropdown"
        driver.get("https://practice.cydeo.com/dropdown");
        Thread.sleep(1000);
    }

    @AfterMethod
    public void tearDownMethod(){
        //6--> closing browser
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        //3--> click to non-select dropdown
        //locating dropdownLink element
        WebElement dropdownLink = driver.findElement(By.xpath("//a[@href='#']"));
        //clicking the element
        dropdownLink.click();
        Thread.sleep(1000);

        //4--> select Facebook from dropdown
        //locating facebookLink
        WebElement facebookLink = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));
        //selecting(clicking) the link
        facebookLink.click();
        Thread.sleep(1000);

        //5--> verify title is “Facebook - Giriş Yap veya Kaydol”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Giriş Yap veya Kaydol";

        Assert.assertEquals(actualTitle, expectedTitle, "they are NOT match");
    }

}
