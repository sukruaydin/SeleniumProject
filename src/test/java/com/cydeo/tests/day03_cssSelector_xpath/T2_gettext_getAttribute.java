package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_gettext_getAttribute {

    public static void main(String[] args) throws InterruptedException {

        /*
        TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
            1- Open a chrome browser
            2- Go to: https://login1.nextbasecrm.com/
            3- Verify “remember me” label text is as expected:
            Expected: Remember me on this computer
            4- Verify “forgot password” link text is as expected:
            Expected: Forgot your password?
            5- Verify “forgot password” href attribute’s value contains expected:
            Expected: forgot_password=yes
         */

        //1--> setup, open and maximize the browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2--> go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        Thread.sleep(1000);

        //3--> Verify “remember me” label text is as Expected: Remember me on this computer
        //locating remember me
        WebElement rememberMe = driver.findElement(By.className("login-item-checkbox-label"));
        //getting the text
        String actualRememberMeText = rememberMe.getText();
        String expectedRememberMeText = "Remember me on this computer";

        if (actualRememberMeText.equals(expectedRememberMeText)){
            System.out.println("RememberMeText verification PASSED!");
        }else {
            System.out.println("RememberMeText verification FAILED!");
        }
        Thread.sleep(1000);

        //4--> Verify “forgot password” link text is as Expected: Forgot your password?
        //locating “forgot password”
        WebElement forgotPassword = driver.findElement(By.className("login-link-forgot-pass"));
        //getting the text
        String actualForgotPassword = forgotPassword.getText();
        String expectedForgotPassword = "Forgot your password?".toUpperCase();

        if (actualForgotPassword.equals(expectedForgotPassword)){
            System.out.println("ForgotPasswordText verification PASSED!");
        }else {
            System.out.println("ForgotPasswordText verification FAILED!");
        }
        Thread.sleep(1000);

        //5--> Verify “forgot password” href attribute’s value contains Expected: forgot_password=yes
        String hrefForgotPassword = forgotPassword.getAttribute("href");
        String expectedContained = "forgot_password=yes";

        if (hrefForgotPassword.contains(expectedContained)){
            System.out.println("Forgot password href attribute verification PASSED!");
        }else {
            System.out.println("Forgot password href attribute verification FAILED!");
        }
        Thread.sleep(1000);

        //6--> closing browser
        driver.close();


    }

}
