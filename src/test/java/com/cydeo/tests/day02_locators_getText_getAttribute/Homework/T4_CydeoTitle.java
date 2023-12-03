package com.cydeo.tests.day02_locators_getText_getAttribute.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_CydeoTitle {

    public static void main(String[] args) throws InterruptedException {

        /*
        TC #4: Practice Cydeo – Class locator practice
                1- Open a chrome browser
                2- Go to: https://practice.cydeo.com/inputs
                3- Click to “Home” link
                4- Verify title is as expected:
                Expected: Practice
                PS: Locate “Home” link using “className” locator
         */

        //1--> setup, open and maximize browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2--> go to "https://practice.cydeo.com/inputs"
        driver.get("https://practice.cydeo.com/inputs");

        Thread.sleep(2000);

        //3--> click "Home"
        //locating "home" by className
        WebElement homeLink = driver.findElement(By.className("nav-link"));
        //clicking
        homeLink.click();

        Thread.sleep(2000);

        //4--> Verify title is as expected: Practice
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAILED!");
        }

        //5--> closing browser
        driver.close();


    }

}
