package com.cydeo.tests.day11_actions_jse_practice_closeDriver;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Circle_Drag_N_Drop {

    /*
            TC #: Drag and drop
        1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        2. Drag and drop the small circle to bigger circle.
        3. Assert:
        -Text in big circle changed to: “You did great!”
     */

    //this test is being performed by using actions.dragAndDrop() method
    @Test
    public void test_1(){
        //1--> setup, open, maximize, implicitly wait the driver and get to the page
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //2--> drag and drop the small circle to bigger circle.
        //locating smallCircle and bigCircle
        WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        //creating Actions' class object to use its methods
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(smallCircle, bigCircle).perform();
        BrowserUtils.sleep(2);

        //3--> assert: Text in big circle changed to: “You did great!”
        String expectedText = "You did great!";
        String actualText = bigCircle.getText();

        Assert.assertEquals(expectedText, actualText);

        //4--> closing browser
        Driver.getDriver().quit();
        //Driver.closeDriver();
    }

    /*
    this test is doing same as test1,
    but introducing a new way like
    actions.clickAndHold(smallCircle).moveToElement(bigCircle).release().perform();
     */
    @Test
    public void test_2() {
        //1--> setup, open, maximize, implicitly wait the driver and get to the page
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //2--> drag and drop the small circle to bigger circle.
        //locating smallCircle and bigCircle
        WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        //creating Actions' class object to use its methods
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(bigCircle)
                .pause(1000)
                .release()
                .perform();
        BrowserUtils.sleep(2);

        //3--> assert: Text in big circle changed to: “You did great!”
        String expectedText = "You did great!";
        String actualText = bigCircle.getText();

        Assert.assertEquals(expectedText, actualText);

        //4--> closing browser
        Driver.closeDriver();

    }

}
