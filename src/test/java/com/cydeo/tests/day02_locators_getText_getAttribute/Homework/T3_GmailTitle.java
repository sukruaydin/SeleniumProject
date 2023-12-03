package com.cydeo.tests.day02_locators_getText_getAttribute.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GmailTitle {

    public static void main(String[] args) throws InterruptedException {

        /*
        TC #3: Back and forth navigation
                1- Open a chrome browser
                2- Go to: https://google.com
                3- Click to Gmail from top right.
                4- Verify title contains:
                Expected: Gmail
                5- Go back to Google by using the .back();
                6- Verify title equals:
                Expected: Google
         */

        //1--> setup, open and maximize browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2--> go to https://google.com
        driver.get("https://google.com");

        //3--> click to Gmail from top right.
        //locating to gmail
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        //clicking
        gmailLink.click();

        Thread.sleep(3000);

        //4--> verify title contains: Gmail
        String actualTitle = driver.getTitle();
        String isContained = "Gmail";

        if (actualTitle.contains(isContained)){
            System.out.println("Gmail title verification PASSED!");
        }else {
            System.out.println("Gmail title verification FAILED!");
        }

        //5--> go back to Google by using the .back();
        driver.navigate().back();

        Thread.sleep(3000);

        //6--> verify title equals: Google
        String expectedTitle = "Google";
        actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Google title verification PASSED!");
        }else {
            System.out.println("Google title verification FAILED!");
        }

        //7--> closing the browser
        driver.close();

    }

}
