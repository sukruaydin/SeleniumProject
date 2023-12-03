package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_getText_cssSelector {

    public static void main(String[] args) throws InterruptedException {

        /*
        TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
            1- Open a chrome browser
            2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
            3- Verify “Reset password” button text is as expected:
            Expected: Reset password
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

        //3--> Verify “Reset password” button text is as Expected: Reset password
        //locating the web element
        WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[class='login-btn']"));
        //getting the text
        String actualResetPasswordButtonText = resetPasswordButton.getText();
        String expectedResetPasswordButtonText = "Reset password";

        if (actualResetPasswordButtonText.equals(expectedResetPasswordButtonText)){
            System.out.println("Reset password button text verification PASSED!");
        }else {
            System.out.println("Reset password button text verification FAILED!");
        }
        Thread.sleep(1000);

        //4--> closing browser
        driver.close();



    }

}
