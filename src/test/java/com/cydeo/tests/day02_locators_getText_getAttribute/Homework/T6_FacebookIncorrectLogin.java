package com.cydeo.tests.day02_locators_getText_getAttribute.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T6_FacebookIncorrectLogin {

    public static void main(String[] args) throws InterruptedException {

        /*
        TC #2: Facebook incorrect login title verification
                1. Open Chrome browser
                2. Go to https://www.facebook.com
                3. Enter incorrect username
                4. Enter incorrect password
                5. Verify title changed to:
                Expected: “Log into Facebook”
         */

        //1--> setup, open adn maximize thr browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2--> go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        //3--> enter incorrect username
        //locating usernameBox
        WebElement usernameBox = driver.findElement(By.id("email"));
        //entering the content
        usernameBox.sendKeys("incorrectUsername");

        Thread.sleep(1000);

        //4--> enter incorrect password
        //locating the passwordBox
        WebElement passwordBox = driver.findElement(By.id("pass"));
        passwordBox.sendKeys("incorrectPassword" + Keys.ENTER);

        Thread.sleep(1000);

        //5--> press log-in
        //locating "Log in" button
        //WebElement logIn = driver.findElement(By.className("_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy"));
        //clicking
       // logIn.click();

        Thread.sleep(1000);

        //6--> Verify title changed to -- Expected: “Facebook'a Giriş Yap”
        String expectedTitle = "Facebook'a Giriş Yap";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAILED!");
        }

        Thread.sleep(1000);

        //7--> closing the browser
        driver.close();

    }

}
