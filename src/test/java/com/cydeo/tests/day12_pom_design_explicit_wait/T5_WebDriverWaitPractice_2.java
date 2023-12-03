package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.DynamicLoad1Page;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T5_WebDriverWaitPractice_2 {

    /*
            TC#5 : Dynamically Loaded Page Elements 1
        1. Go to https://practice.cydeo.com/dynamic_loading/1
        2. Click to start
        3. Wait until loading bar disappears
        4. Assert username inputbox is displayed
        5. Enter username: tomsmith
        6. Enter password: incorrectpassword
        7. Click to Submit button
        8. Assert “Your password is invalid!” text is displayed.
        Note: Follow POM Design Pattern
     */

    @Test
    public void dynamic_load_1_test(){
        //1--> setup, open, maximize, implicitly wait the browser and go to page
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

        //2--> click to start
        DynamicLoad1Page dynamicLoad1Page = new DynamicLoad1Page();
        dynamicLoad1Page.startButton.click();

        //3--> wait until loading bar disappears
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad1Page.loadingBar));

        //4--> assert username input-box is displayed
        Assert.assertTrue(dynamicLoad1Page.inputUsername.isDisplayed());

        //5--> enter username: tomsmith
        dynamicLoad1Page.inputUsername.sendKeys("tomsmith");

        //6--> enter password: incorrectpassword
        dynamicLoad1Page.inputPassword.sendKeys("incorrectpassword");

        //7--> click to Submit button
        dynamicLoad1Page.submitButton.click();

        //8--> assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(dynamicLoad1Page.warningMessage.isDisplayed());

        //closing browser
        Driver.closeDriver();
    }


}
