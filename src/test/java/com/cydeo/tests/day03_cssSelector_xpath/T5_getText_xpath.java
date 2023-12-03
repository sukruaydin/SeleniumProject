package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_getText_xpath {

    public static void main(String[] args) throws InterruptedException {

        /*
        TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
            1- Open a chrome browser
            2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
            3- Enter incorrect username into login box:
            4- Click to `Reset password` button
            5- Verify “error” label is as expected
            Expected: Login or E-mail not found
            PS: Inspect and decide which locator you should be using to locate web
            elements.
            PS2: Pay attention to where to get the text of this button from
         */

        //1--> setup, open and maximize the browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2--> go to https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
        Thread.sleep(1000);

        //3--> enter incorrect username into login box: "incorrect"
        //locating inputLogin
        WebElement inputLogInButton = driver.findElement(By.xpath("//input[@class='login-inp']"));
        //providing "incorrect" data
        inputLogInButton.sendKeys("incorrect");
        Thread.sleep(1000);

        //4--> click to `Reset password` button
        //locating resetPasswordButton
        WebElement resetPasswordButton = driver.findElement(By.xpath("//button[@class='login-btn']"));
        //clicking
        resetPasswordButton.click();
        Thread.sleep(1000);

        //5--> verify “error” label is as Expected: Login or E-mail not found
        //locating the “error” label element
        WebElement error = driver.findElement(By.xpath("//div[@class='errortext']"));
        //getting the text
        String actualErrorText = error.getText();
        String expectedErrorText = "Login or E-mail not found";

        if (actualErrorText.equals(expectedErrorText)){
            System.out.println("Error text verification PASSED!");
        }else {
            System.out.println("Error text verification FAILED!");
        }
        Thread.sleep(1000);

        //6--> closing browser
        driver.close();


    }

}
