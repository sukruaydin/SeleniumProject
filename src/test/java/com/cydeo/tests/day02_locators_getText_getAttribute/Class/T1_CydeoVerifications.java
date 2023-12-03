package com.cydeo.tests.day02_locators_getText_getAttribute.Class;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {

    public static void main(String[] args) {

        /*
        TC #1: Cydeo practice tool verifications
                1. Open Chrome browser
                2. Go to https://practice.cydeo.com
                3. Verify URL contains
                Expected: cydeo
                4. Verify title:
                Expected: Practice
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com");

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "cydeo";
        if (actualURL.contains(expectedURL)){
            System.out.println("URL verification PASSED!");
        }else {
            System.out.println("URL verification FAILED!");
        }

        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAILED!");
        }

        driver.close();

    }

}
