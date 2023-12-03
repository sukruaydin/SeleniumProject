package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T1_T2_T3_POMPractices  {

    /*
            TC #1: Required field error message test
        1- Open a chrome browser
        2- Go to: https://library1.cydeo.com
        3- Do not enter any information
        4- Click to “Sign in” button
        5- Verify expected error is displayed:
        Expected: This field is required.
        NOTE: FOLLOW POM DESIGN PATTERN
     */
    /*

            TC #2: Invalid email format error message test
        1- Open a chrome browser
        2- Go to: https://library1.cydeo.com
        3- Enter invalid email format
        4- Verify expected error is displayed:
        Expected: Please enter a valid email address.
        NOTE: FOLLOW POM DESIGN PATTERN

     */
    /*
            TC #3: Library negative login
        1- Open a chrome browser
        2- Go to: https://library1.cydeo.com
        3- Enter incorrect username or incorrect password
        4- Verify title expected error is displayed:
        Expected: Sorry, Wrong Email or Password
        NOTE: FOLLOW POM DESIGN PATTERN
     */

    LibraryLoginPage libraryLoginPage = new LibraryLoginPage();

    @BeforeMethod
    public void setUpMethod(){
        //1--> setup, open, maximize, implicitly wait the driver and get to the page
        Driver.getDriver().get("https://library1.cydeo.com");
        BrowserUtils.sleep(1);

        //now, we are reaching the variables and methods of LibraryLoginPage class
        //libraryLoginPage = new LibraryLoginPage();
    }

    @AfterMethod
    public void tearDownMethod(){
        //4--> closing browser
        Driver.closeDriver();
    }

    @Test(priority = 1)
    public void required_field_error_message_test_1(){
        //2--> do not enter any information
        //3--> click to “Sign in” button
        libraryLoginPage.signInButton.click();
        BrowserUtils.sleep(1);

        //4- Verify expected error is displayed: Expected: This field is required.
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());
    }

    @Test(priority = 2)
    public void invalid_email_format_error_message_test_2(){
        //2--> enter invalid email format
        libraryLoginPage.inputUsername.sendKeys("somethingwrong");
        BrowserUtils.sleep(1);
        libraryLoginPage.signInButton.click();

        //3--> verify expected error is displayed: Expected: Please enter a valid email address.
        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());
    }

    @Test(priority = 3)
    public void library_negative_login_test_3(){
        //2--> enter incorrect username and incorrect password
        libraryLoginPage.inputUsername.sendKeys("abcd@fg.com");
        BrowserUtils.sleep(1);
        libraryLoginPage.inputPassword.sendKeys("1234");
        BrowserUtils.sleep(1);
        libraryLoginPage.signInButton.click();

        //3--> verify title expected error is displayed: Expected: Sorry, Wrong Email or Password
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());
    }

}
