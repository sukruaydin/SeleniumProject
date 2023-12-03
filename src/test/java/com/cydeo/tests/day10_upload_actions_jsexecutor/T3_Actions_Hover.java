package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_Actions_Hover {

    /*
                TC #3: Hover Test
            1. Go to https://practice.cydeo.com/hovers
            2. Hover over to first image
            3. Assert:
                a. “name: user1” is displayed
                b. “view profile” is displayed
            4. Hover over to second image
            5. Assert:
                a. “name: user2” is displayed
                b. “view profile” is displayed
            6. Hover over to third image
            7. Confirm:
                a. “name: user3” is displayed
                b. “view profile” is displayed
     */

    @Test
    public void hovering_test(){
        //1--> setup, open, maximize, implicitly wait, and go to webpage
        Driver.getDriver().get("https://practice.cydeo.com/hovers");

        //2--> hover over to first image
        //locating first image
        WebElement firstImage = Driver.getDriver().findElement(By.xpath("//img[@src='/img/avatar-blank.jpg']"));
        //creating actions object
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(firstImage).perform();

        //3--> assert:
        //a. “name: user1” is displayed
        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        Assert.assertTrue(user1.isDisplayed());
        //b. “view profile” is displayed
        WebElement viewLink1 = Driver.getDriver().findElement(By.xpath("//a[@href='/users/1']"));
        Assert.assertTrue(viewLink1.isDisplayed());

        ///4--> hover over to second image
        //locating the second image
        WebElement secondImage = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[2]"));
        actions.moveToElement(secondImage).perform();

        //5--> assert:
        //a. “name: user2” is displayed
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        Assert.assertTrue(user2.isDisplayed());
        //b. “view profile” is displayed
        WebElement viewLink2 = Driver.getDriver().findElement(By.xpath("//a[@href='/users/2']"));
        Assert.assertTrue(viewLink2.isDisplayed());

        ///6--> hover over to second image
        //locating the third image
        WebElement thirdImage = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[3]"));
        actions.moveToElement(thirdImage).perform();

        //7--> assert:
        //a. “name: user3” is displayed
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));
        Assert.assertTrue(user3.isDisplayed());
        //b. “view profile” is displayed
        WebElement viewLink3 = Driver.getDriver().findElement(By.xpath("//a[@href='/users/3']"));
        Assert.assertTrue(viewLink3.isDisplayed());

    }

}
