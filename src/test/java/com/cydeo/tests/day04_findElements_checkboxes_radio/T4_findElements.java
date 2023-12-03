package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_findElements {

    public static void main(String[] args) throws InterruptedException {

        /*
            TC #4: FindElements Task
                1- Open a Chrome browser
                2- Go to: https://practice.cydeo.com/abtest
                3- Locate all the links in the page.
                4- Print out the number of the links on the page.
                5- Print out the texts of the links.
                6- Print out the HREF attribute values of the links
             */

        //1--> setup, open, and maximize the browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //providing extra time for our driver  before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2--> go to https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");
        Thread.sleep(1000);

        //3--> locate all the links in the page.
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        //4--> print out the number of the links on the page.
        System.out.println("number of the links = " + allLinks.size());

        //5--> print out the texts of the links.
        for (WebElement each : allLinks) {
            System.out.println("Text of Link = " + each.getText());
        }

        //6--> print out the HREF attribute values of the links
        for (WebElement each : allLinks) {
            System.out.println("href values = " + each.getAttribute("href"));
        }

        //alert
        driver.switchTo().alert().accept();

        //iframe
        WebDriver frame = driver.switchTo().frame(1);

        driver.switchTo().parentFrame();




        //7--> closing browser
        driver.close();


    }

}
