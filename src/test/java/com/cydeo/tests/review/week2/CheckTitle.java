package com.cydeo.tests.review.week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckTitle {

    public static void main(String[] args) throws InterruptedException {

        //1--> setup, open and maximize the browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2--> go to https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/");
        Thread.sleep(1500);

        //3--> verify the title is "Practice"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAILED!");
        }

        //4--> current url
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //5--> close the browser
        driver.close();

    }

}
