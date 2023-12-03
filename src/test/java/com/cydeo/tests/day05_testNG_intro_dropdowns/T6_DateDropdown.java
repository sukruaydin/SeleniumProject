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

public class T6_DateDropdown {

    /*
            TC #6: Selecting date on dropdown and verifying
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/dropdown
        3. Select “December 1st, 1923” and verify it is selected.
        Select year using : visible text
        Select month using : value attribute
        Select day using : index number
     */

    WebDriver driver;

    @BeforeClass
    public void setUpMethod() throws InterruptedException {
        //1--> setup, open, implicitly wait and maximize the browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2--> go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
        Thread.sleep(1000);
    }

    @AfterClass
    public void tearDownMethod(){
        //4--> close browser
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        //3--> Select “December 1st, 1923” and verify it is selected.

        //select year using : visible text
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        yearDropdown.selectByVisibleText("1923");
        Thread.sleep(1000);

        //select month using : value attribute
        Select montDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        montDropdown.selectByValue("11");
        Thread.sleep(1000);

        //select day using : index number
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dayDropdown.selectByIndex(0);
        Thread.sleep(1000);

        //verifying
        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = montDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualYear, expectedYear);
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualDay, expectedDay);


    }

}
