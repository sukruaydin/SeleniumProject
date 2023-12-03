package com.cydeo.tests.day11_actions_jse_practice_closeDriver;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T4_T5_Scroll_FromDay10 {

    /*
            TC #4: Scroll practice
        1- Open a chrome browser
        2- Go to: https://practice.cydeo.com/
        3- Scroll down to “Powered by CYDEO”
        4- Scroll using Actions class “moveTo(element)” method

        TC #5: Scroll practice 2
        1- Continue from where the Task 4 is left in the same test.
        2- Scroll back up to “Home” link using PageUP button
     */

    @Test
    public void scroll_test(){
        //1--> setup, open, maximize, implicitly wait the driver and get to the page
        Driver.getDriver().get("https://practice.cydeo.com/");
        BrowserUtils.sleep(1);

        //(FIRST WAY TO SCROLL)
        //2--> scroll down to “Powered by CYDEO”
        //3--> scroll using Actions class “moveTo(element)” method
        //locating poweredByCydeo
        WebElement poweredByCydeo = Driver.getDriver().findElement(By.xpath("//a[@href='https://cydeo.com/']"));
        //creating Actions' object to use its methods
        Actions actions = new Actions(Driver.getDriver());
        //moving to the element
        actions.moveToElement(poweredByCydeo).perform();
        BrowserUtils.sleep(1);

        //(SECOND WAY TO SCROLL)
        //TC #5: Scroll practice 2
        //1--> continue from where the Task 4 is left in the same test.
        //2--> scroll back up to “Home” link using PageUP button
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();

        Driver.closeDriver();

    }

    @Test
    public void test_2(){
        Driver.getDriver().get("https://practice.cydeo.com/");
        Driver.closeDriver();
    }

}
