package com.cydeo.tests.day11_actions_jse_practice_closeDriver;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7_Scroll_JSExecutor_FromDay10 {

    /*
            TC #7: Scroll using JavascriptExecutor
        1- Open a chrome browser
        2- Go to: https://practice.cydeo.com/large
        3- Scroll down to “Cydeo” link
        4- Scroll up to “Home” link
        5- Use below provided JS method only
        JavaScript method to use : arguments[0].scrollIntoView(true)
        Note: You need to locate the links as web elements and pass them as
        arguments into executeScript() method
     */

    @Test
    public void task7_scroll_test(){
        //1--> setup, open, maximize, implicitly wait, and go to webpage
        Driver.getDriver().get("https://practice.cydeo.com/large");
        BrowserUtils.sleep(1);

        //2--> locating cydeoLink
        WebElement cydeoLink = Driver.getDriver().findElement(By.xpath("//a[@href='https://cydeo.com/']"));

        //3--> creating by downs-casting JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //scrolling down to cydeoLink by using js object
        js.executeScript("arguments[0].scrollIntoView(true)", cydeoLink);
        BrowserUtils.sleep(1);

        //4--> locating homeLink
        WebElement homeLink = Driver.getDriver().findElement(By.xpath("//a[@href='/']"));
        //scrolling down to cydeoLink by using js object
        js.executeScript("arguments[1].scrollIntoView(true)", cydeoLink, homeLink);
        BrowserUtils.sleep(1);

        //5--> closing browser
        Driver.closeDriver();

    }

}
