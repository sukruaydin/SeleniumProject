package com.cydeo.tests.review.week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class FirstClass {

    public static void main(String[] args) throws InterruptedException {

        //1--> setup, open and maximize the browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2--> go to https://www.google.com
        driver.get("https://www.google.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        Thread.sleep(1000);

        ChromeOptions chromeOptions = new ChromeOptions();

        ArrayList<String> a = new ArrayList<>();

        for (String s : a) {
            
        }
        


        /*//3--> go to https://www.ebay.com
        driver.navigate().to("https://www.ebay.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        Thread.sleep(1000);

        //4--> go back
        driver.navigate().back();
        System.out.println("driver.getTitle() = " + driver.getTitle());
        Thread.sleep(1000);

        //5--> go ebay again
        driver.navigate().forward();
        System.out.println("driver.getTitle() = " + driver.getTitle());
        Thread.sleep(1000);

        //6--> refresh
        driver.navigate().refresh();
        System.out.println("driver.getTitle() = " + driver.getTitle());
        Thread.sleep(1000);

        driver.close();*/

    }

}
