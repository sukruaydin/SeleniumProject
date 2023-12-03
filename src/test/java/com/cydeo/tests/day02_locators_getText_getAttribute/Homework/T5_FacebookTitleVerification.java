package com.cydeo.tests.day02_locators_getText_getAttribute.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_FacebookTitleVerification {

    public static void main(String[] args) throws InterruptedException {

        /*
        TC #1: Facebook title verification
                1. Open Chrome browser
                2. Go to https://www.facebook.com
                3. Verify title:
                Expected: “Facebook - Log In or Sign Up”
         */

        //1--> setup, open and maximize the browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2--> go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        //3--> verify title, Expected: “Facebook - Log In or Sign Up”
        String expectedTitle = "Facebook - Giriş Yap veya Kaydol";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAILED!");
        }

        Thread.sleep(2000);

        //4--> closing the browser
        driver.close();

    }

}
