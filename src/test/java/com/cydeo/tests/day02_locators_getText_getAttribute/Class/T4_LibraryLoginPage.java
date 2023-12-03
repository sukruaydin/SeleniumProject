package com.cydeo.tests.day02_locators_getText_getAttribute.Class;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_LibraryLoginPage {

    public static void main(String[] args) throws InterruptedException {

        /*
        TC #4: Library verifications
                1. Open Chrome browser
                2. Go to https://library1.cydeo.com/login.html
                3. Enter username: “incorrect@email.com”
                4. Enter password: “incorrect password”
                5. Verify: visually “Sorry, Wrong Email or Password”
                displayed
                PS: Locate username input box using “className” locator
                Locate password input box using “id” locator
                Locate Sign in button using “tagName” locator
         */

        //1--> setup, open and maximize the browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2--> go to "https://library1.cydeo.com/login.html"
        driver.get("https://library1.cydeo.com/login.html");

        //3--> enter username: “incorrect@email.com”
        WebElement inputBox = driver.findElement(By.className("form-control"));
        inputBox.sendKeys("incorrect@email.com");

        //4--> enter password: “incorrect password”
        WebElement passwordBox = driver.findElement(By.id("inputPassword"));
        passwordBox.sendKeys("incorrect password");

        //5--> press sign-in
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        Thread.sleep(3000);

        //6--> Verify: visually “Sorry, Wrong Email or Password” displayed

        //7--> closing the browser
        driver.close();


    }

}
