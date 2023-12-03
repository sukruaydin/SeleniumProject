package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_sccSelector {

    public static void main(String[] args) throws InterruptedException {

        /*
        TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
            1- Open a chrome browser
            2- Go to: https://login1.nextbasecrm.com/
            3- Verify “Log in” button text is as expected:
            Expected: Log In
            PS: Inspect and decide which locator you should be using to locate web
            elements.
            PS2: Pay attention to where to get the text of this button from
         */

        //1--> setup, open and maximize the browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2--> go to https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        Thread.sleep(1000);

        //3--> Verify “Log in” button text is as Expected: Log In
        //I am going to implement cssSelector
        //locating the web element
        WebElement logInButton = driver.findElement(By.cssSelector("input[value='Log In']"));
        //getting the text by getAttribute (cuz "input" tag is kinda different)
        String actualLogInButtonText = logInButton.getAttribute("value");
        String expectedLogInButtonText = "Log In";

        if (actualLogInButtonText.equals(expectedLogInButtonText)){
            System.out.println("Log-in button text verification PASSED!");
        }else {
            System.out.println("Log-in button text verification FAILED!");
        }
        Thread.sleep(1000);


        //4--> closing browser
        driver.close();


    }

}
