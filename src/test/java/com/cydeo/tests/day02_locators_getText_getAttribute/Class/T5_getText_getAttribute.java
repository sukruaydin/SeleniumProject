package com.cydeo.tests.day02_locators_getText_getAttribute.Class;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getText_getAttribute {

    public static void main(String[] args) throws InterruptedException {

        /*
        TC #5: getText() and getAttribute() method practice
                1- Open a chrome browser
                2- Go to: https://practice.cydeo.com/registration_form
                3- Verify header text is as expected:
                Expected: Registration form
                4- Locate “First name” input box
                5- Verify placeholder attribute’s value is as expected:
                Expected: first name
         */

        //1--> setup, open and maximize the browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2--> go to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");
        Thread.sleep(3000);

        //3--> Verify header text is as expected: Registration form
        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader = header.getText();
        String expectedHeader = "Registration form";

        if (actualHeader.equals(expectedHeader)){
            System.out.println("Header verification PASSED!");
        }else {
            System.out.println("Header verification FAILED!");
        }

        //4--> locate “First name” input box, by using "name" locator
        WebElement firstNameBox = driver.findElement(By.name("firstname"));

        //5--> Verify placeholder attribute’s value is as expected: first name
        String actualPlaceholder= firstNameBox.getAttribute("placeholder");
        String expectedPlaceholder = "first name";

        if (actualPlaceholder.equals(expectedPlaceholder)){
            System.out.println("Placeholder verification PASSED!");
        }else {
            System.out.println("Placeholder verification FAILED!");
        }

        //6--> closing the browser
        driver.close();

    }

}














