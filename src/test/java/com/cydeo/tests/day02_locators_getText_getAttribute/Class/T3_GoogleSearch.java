package com.cydeo.tests.day02_locators_getText_getAttribute.Class;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {

    public static void main(String[] args) {

        /*
        TC#3: Google search
            1- Open a chrome browser
            2- Go to: https://google.com
            3- Write “apple” in search box
            4- Click google search button
            5- Verify title:
            Expected: Title should start with “apple” word
         */

        //1--> setup, open and maximize browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2--> go to https://google.com
        driver.get("https://google.com");

        //3--> Write “apple” in search box
        //4--> press ENTER
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("apple" + Keys.ENTER);

        //5--> verify title
        String actualTitle = driver.getTitle();
        String expectedInTitle = "apple";

        if (actualTitle.startsWith(expectedInTitle)){
            System.out.println("Title verification is PASSED!");
        } else {
            System.out.println("Title verification is FAILED!");
        }

        //6--> closing the browser
        driver.close();

    }

}
