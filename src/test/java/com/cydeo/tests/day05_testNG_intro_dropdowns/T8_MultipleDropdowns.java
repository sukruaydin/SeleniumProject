package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T8_MultipleDropdowns {

    /*
            TC #8: Selecting value from multiple select dropdown
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/dropdown
        3. Select all the options from multiple select dropdown.
        4. Print out all selected values.
        5. Deselect all values.
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
        //driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        //3--> select all the options from multiple select dropdown.
        Select multipleDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        System.out.println("multipleDropdown.isMultiple() = " + multipleDropdown.isMultiple());
        for (int i = 0; i < 6; i++) {
            multipleDropdown.selectByIndex(i);
            Thread.sleep(1000);
        }

        //4--> print out all selected values.
        List<WebElement> allSelectedOptions = multipleDropdown.getAllSelectedOptions();
        for (WebElement each : allSelectedOptions) {
            System.out.println("Item = " + each.getText());
        }

        //5--> deselect all values.
        multipleDropdown.deselectAll();

    }

}
