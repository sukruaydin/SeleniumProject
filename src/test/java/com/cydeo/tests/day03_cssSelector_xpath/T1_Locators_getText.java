package com.cydeo.tests.day03_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_Locators_getText {

    public static void main(String[] args) throws InterruptedException {

        /*
        TC #1: NextBaseCRM, locators and getText() practice
            1- Open a chrome browser
            2- Go to: https://login1.nextbasecrm.com/
            3- Enter incorrect username: “incorrect”
            4- Enter incorrect password: “incorrect”
            5- Click to login button.
            6- Verify error message text is as expected:
            Expected: Incorrect login or password
         */

        //1--> setup, open and maximize the browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2--> go to https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        Thread.sleep(1000);

        //3--> enter incorrect username: “incorrect”
        //locating username box
        WebElement usernameBox = driver.findElement(By.className("login-inp"));
        //providing “incorrect”
        usernameBox.sendKeys("“incorrect”");
        Thread.sleep(1000);

        //4--> enter incorrect password “incorrect”
        //locating passwordBox
        WebElement passwordBox = driver.findElement(By.name("USER_PASSWORD"));
        //providing “incorrect” and pressing ENTER
        passwordBox.sendKeys("incorrect");
        Thread.sleep(1000);

        //5--> click log-in button
        //locating button
        WebElement logInButton = driver.findElement(By.className("login-btn"));
        //clicking button
        logInButton.click();
        Thread.sleep(1000);

        //6--> Verify error message text is as expected: Incorrect login or password
        //locating errorMessageElement
        WebElement errorMessageElement = driver.findElement(By.className("errortext"));
        //getting the text of errorMessageElement
        String actualErrorMessage = errorMessageElement.getText();
        String expectedErrorMessage = "Incorrect login or password";

        if (actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("Error message verification PASSED!");
        }else {
            System.out.println("Error message verification FAILED!");
        }
        Thread.sleep(1000);

        //7--> closing browser
        driver.close();




    }

}
