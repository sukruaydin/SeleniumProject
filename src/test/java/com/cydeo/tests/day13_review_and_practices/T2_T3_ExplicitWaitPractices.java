package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DynamicControls;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T2_T3_ExplicitWaitPractices {

    /*
                TC #2: Explicit wait practice
            1- Open a chrome browser
            2- Go to: https://practice.cydeo.com/dynamic_controls
            3- Click to “Remove” button
            4- Wait until “loading bar disappears”
            5- Verify:
            a. Checkbox is not displayed
            b. “It’s gone!” message is displayed.
            NOTE: FOLLOW POM
     */
    /*
                TC #3: Explicit wait practice
            1- Open a chrome browser
            2- Go to: https://practice.cydeo.com/dynamic_controls
            3- Click to “Enable” button
            4- Wait until “loading bar disappears”
            5- Verify:
            a. Input box is enabled.
            b. “It’s enabled!” message is displayed.
            NOTE: FOLLOW POM
     */

    DynamicControls dynamicControls;

    @BeforeMethod
    public void setUpMethod(){
        //1--> setup, open, maximize, implicitly wait the driver and get to the page
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControls = new DynamicControls();
    }

    @Test
    public void remove_button_test(){
        //2--> click to “Remove” button
        dynamicControls.removeButton.click();

        //3--> wait until “loading bar disappears”
        //we are turning implicitly wait off in order not to face unexpected consequences
        //since, it is said that in the document that -->
        // using implicitly and explicitly wait together might cause problem
        //problem --> unexpected wait time
        //Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //this is my explicitly wait
        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        //wait.until(ExpectedConditions.invisibilityOf(dynamicControls.loadingBar));


        //WE CREATED A UTILITY METHOD FOR EXPLICITLY WAIT

        //GOSHHHH !! I MADE IT !!! BETTER THAN GURHAN'S
        BrowserUtils.explicitlyWait().until(ExpectedConditions.invisibilityOf(dynamicControls.loadingBar));


        //4--> verify:
        //a. checkbox is not displayed
        //WOOOWWWW !!! THIS IS THE FIRST TIME WE USED EXCEPTION IN REAL SCENARIO
        try {
            Assert.assertFalse(dynamicControls.checkBox.isDisplayed());
        }catch (NoSuchElementException n){
            Assert.assertTrue(true);
        }
        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControls.text.isDisplayed());

        //5--> closing browser
        Driver.closeDriver();

    }

    @Test
    public void enable_button_test(){
        //2--> click to “Enable” button
        dynamicControls.enableButton.click();

        //3--> wait until “loading bar disappears”
        BrowserUtils.explicitlyWait().until(ExpectedConditions.invisibilityOf(dynamicControls.loadingBar2));

        //4--> verify:
        //a. Input box is enabled.
        Assert.assertTrue(dynamicControls.inputBar.isEnabled());
        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControls.isEnabledMessage.isDisplayed());

        //5--> closing browser
        Driver.closeDriver();

    }

}
