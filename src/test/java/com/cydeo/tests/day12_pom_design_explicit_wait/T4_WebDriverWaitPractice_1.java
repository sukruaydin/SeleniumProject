package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.DynamicLoad7Page;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_WebDriverWaitPractice_1 {

    /*
            TC#4 : Dynamically Loaded Page Elements 7
        1. Go to https://practice.cydeo.com/dynamic_loading/7
        2. Wait until title is “Dynamic title”
        3. Assert: Message “Done” is displayed.
        4. Assert: Image is displayed.
        Note: Follow POM
     */

    @Test
    public void dynamic_load_7_test(){
        //1--> setup, open, maximize, implicitly wait the browser and go to page
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");

        //.titleIs
        //2--> wait until title is “Dynamic title”
        //creating the wait object to be able to create certain condition
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        //use the wait object to create our expected condition
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        //3--> assert: Message “Done” is displayed.
        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();
        Assert.assertTrue(dynamicLoad7Page.doneMessage.isDisplayed());

        //4--> assert: Image is displayed.
        Assert.assertTrue(dynamicLoad7Page.spongeBobImage.isDisplayed());

        //5--> closing browser
        Driver.closeDriver();
    }


}
