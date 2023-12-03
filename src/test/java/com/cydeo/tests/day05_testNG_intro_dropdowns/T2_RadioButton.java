package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T2_RadioButton {

    public static void main(String[] args) throws InterruptedException {

        /*
                        XPATH PRACTICES
                DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
                TC #2: Radiobutton handling
                1. Open Chrome browser
                2. Go to https://practice.cydeo.com/radio_buttons
                3. Click to “Hockey” radio button
                4. Verify “Hockey” radio button is selected after clicking.
                USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
         */

        //1--> setup, open, maximize and implicitly wait the browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2--> go to "https://practice.cydeo.com/radio_buttons"
        driver.get("https://practice.cydeo.com/radio_buttons");
        Thread.sleep(1000);

        //3--> click to "Hockey" radio button
        //locating hockey button
        WebElement hockeyButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        //clicking the button
        hockeyButton.click();
        Thread.sleep(1000);

        //4--> verify “Hockey” radio button is selected after clicking.
        if (hockeyButton.isSelected()){
            System.out.println("Button is selected. Verification PASSED!");
        }else {
            System.out.println("Button is not selected. Verification FAILED!");
        }

        //5--> closing browser
        driver.close();


    }

}
