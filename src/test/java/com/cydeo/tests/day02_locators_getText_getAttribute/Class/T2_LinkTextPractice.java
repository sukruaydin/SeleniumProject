package com.cydeo.tests.day02_locators_getText_getAttribute.Class;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkTextPractice {

    public static void main(String[] args) throws InterruptedException {

        /*
        TC #2: Back and forth navigation
                1- Open a chrome browser
                2- Go to: https://practice.cydeo.com
                3- Click to A/B Testing from top of the list.
                4- Verify title is:
                Expected: No A/B Test
                5- Go back to home page by using the .back();
                6- Verify title equals:
                Expected: Practice
         */


        //1-->setup, open and maximize the browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2--> go to "https://practice.cydeo.com"
        driver.get("https://practice.cydeo.com");

        Thread.sleep(1500);

        //3--> Verify title is: No A/B Test
        //driver.findElement(By.linkText("A/B Testing")).click();
        //below one is well-documented
        //clicking the button
        WebElement abTestLink = driver.findElement(By.linkText("A/B Testing"));
        abTestLink.click();

        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAILED!");
        }

        Thread.sleep(1500);

        //4--> go back
        driver.navigate().back();

        Thread.sleep(1500);

        //5--> verify title
        String expectedTitle2 = "Practice";
        actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle2)){
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAILED!");
        }

        driver.close();

    }

}
