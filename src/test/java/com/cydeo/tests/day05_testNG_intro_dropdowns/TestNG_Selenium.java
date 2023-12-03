package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //1--> setup, open, implicitly wait, and maximize browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod(){
        //4--> closing browser
        driver.close();
    }

    @Test
    public void selenium_test(){
        //do browser setup
        //open browser
        //maximize
        //implicit wait
        //get google
        //Assert : title is "Google"

        //2--> go to google
        driver.get("https://www.google.com");

        //3--> Assert : title is "Google"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        //creating an assertions
        Assert.assertEquals(actualTitle , expectedTitle, "Title is NOT matching");

    }

}
