package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T3_RadioButton_Cont_2 {

    public static void main(String[] args) throws InterruptedException {


        /*
                    XPATH PRACTICES
            DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
            TC #3: Utility method task for (continuation of Task2)
            1. Open Chrome browser
            2. Go to https://practice.cydeo.com/radio_buttons
            3. Click to “Hockey” radio button
            4. Verify “Hockey” radio button is selected after clicking.
            USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

            Create a utility method to handle above logic.
            Method name: clickAndVerifyRadioButton
            Return type: void or boolean
            Method args:
            1. WebDriver
            2. Name attribute as String (for providing which group of radio buttons)
            3. Id attribute as String (for providing which radio button to be clicked)
            Method should loop through the given group of radio buttons. When it finds the
            matching option, it should click and verify option is Selected.
            Print out verification: true
         */

        //1--> setup, open, maximize and implicitly wait the browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2--> go to "https://practice.cydeo.com/radio_buttons"
        driver.get("https://practice.cydeo.com/radio_buttons");
        Thread.sleep(1000);

        //3--> using custom method
        clickAndVerifyRadioButton(driver, "sport", "football");
        Thread.sleep(1000);
        clickAndVerifyRadioButton(driver, "color", "yellow");
        Thread.sleep(1000);

        //4--> closing browser
        driver.close();

    }

    private static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String idValue){
        List<WebElement> sportRadioButtons = driver.findElements(By.name(nameAttribute));

        for (WebElement each : sportRadioButtons) {
            if (each.getAttribute("id").equals(idValue)){
                each.click();
                System.out.println(each.getAttribute("id") + " is selected = " + each.isSelected());
                break;
            }
        }

    }

}
