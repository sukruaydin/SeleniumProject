package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {

    public static void main(String[] args) {
        /*
        TC #1: Yahoo Title Verification
            1. Open Chrome browser
            2. Go to https://www.yahoo.com
            3. Verify title:
            Expected: Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos
         */

        //1--> Setting up the driver
        WebDriverManager.chromedriver().setup();

        //2--> Creating the instance, open the browser
        WebDriver driver = new ChromeDriver();

        //3--> maximizing
        driver.manage().window().maximize();

        //4--> go to yahoo
        driver.get("https://www.yahoo.com");

        //5--> getting the title
        String actualTitle = driver.getTitle();

        //6--> comparing
        String expectedTitle = "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title is as expected. Verification PASSED!");
        }else {
            System.out.println("Title is NOT as expected. Verification FAILED!");
        }


        driver.close();

    }

}
