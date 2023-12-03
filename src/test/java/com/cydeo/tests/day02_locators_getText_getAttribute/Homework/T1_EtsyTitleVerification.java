package com.cydeo.tests.day02_locators_getText_getAttribute.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_EtsyTitleVerification {

    public static void main(String[] args) throws InterruptedException {

        /*
        TC #1: Etsy Title Verification
                1. Open Chrome browser
                2. Go to https://www.etsy.com
                3. Search for “wooden spoon”
                4. Verify title:
                Expected: “Wooden spoon - Etsy”
         */

        //1--> setup, open and maximize the browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2--> go to https://www.etsy.com
        driver.get("https://www.etsy.com");

        //3--> Search for “wooden spoon”
        //locating searchBox
        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        //providing "wooden spoon" and hitting ENTER
        searchBox.sendKeys("Wooden spoon" + Keys.ENTER);

        Thread.sleep(3000);

        //4--> Verify title, Expected: “Wooden spoon - Etsy”
        String expectedTitle = "Wooden spoon - Etsy";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAILED!");
        }

        //5--> closing the browser
        driver.close();


    }

}
