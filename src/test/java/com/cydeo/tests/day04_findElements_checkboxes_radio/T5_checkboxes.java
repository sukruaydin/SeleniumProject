package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T5_checkboxes {

    public static void main(String[] args) throws InterruptedException {

        /*
        Practice: Checkboxes
            1. Go to https://practice.cydeo.com/checkboxes
            2. Confirm checkbox #1 is NOT selected by default
            3. Confirm checkbox #2 is SELECTED by default.
            4. Click checkbox #1 to select it.
            5. Click checkbox #2 to deselect it.
            6. Confirm checkbox #1 is SELECTED.
            7. Confirm checkbox #2 is NOT selected.
         */

        //1--> setup, open, timeout, and maximize the browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2--> go to https://practice.cydeo.com/checkboxes
        driver.get("https://practice.cydeo.com/checkboxes");
        Thread.sleep(1000);

        //3--> confirm checkbox #1 is NOT selected by default
        //locating checkbox #1
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@name='checkbox1']"));
        //confirming checkbox #1 is not selected by default
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());

        //4--> confirm checkbox #2 is selected by default
        //locating checkbox #2
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@name='checkbox2']"));
        //confirming checkbox #2 is selected by default
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());

        //5--> click checkbox #1 to select it.
        checkBox1.click();
        Thread.sleep(1000);

        //6--> click checkbox #2 to deselect it.
        checkBox2.click();
        Thread.sleep(1000);

        //7--> confirm checkbox #1 is SELECTED.
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());

        //8--> confirm checkbox #2 is NOT selected.
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());

        //9--> closing browser
        driver.close();


    }

}
