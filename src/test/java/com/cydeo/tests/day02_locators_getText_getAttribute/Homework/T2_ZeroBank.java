package com.cydeo.tests.day02_locators_getText_getAttribute.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_ZeroBank {

    public static void main(String[] args) throws InterruptedException {

        /*
        TC #2: Zero Bank header verification
                1. Open Chrome browser
                2. Go to http://zero.webappsecurity.com/login.html
                3. Verify header text
                Expected: “Log in to ZeroBank”
         */

        //1--> setup, open and maximize the browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2--> go to "http://zero.webappsecurity.com/login.html"
        driver.get("http://zero.webappsecurity.com/login.html");

        Thread.sleep(3000);

        //3--> verify header text, Expected: “Log in to ZeroBank”
        //locating the header
        WebElement header = driver.findElement(By.tagName("h3"));
        //getting the text of header
        String actualHeader = header.getText();
        String expectedHeader = "Log in to ZeroBank";

        if (actualHeader.equals(expectedHeader)){
            System.out.println("Header verification PASSED!");
        }else {
            System.out.println("Header verification FAILED!");
        }


        //4--> closing browser
        driver.close();

    }

}
