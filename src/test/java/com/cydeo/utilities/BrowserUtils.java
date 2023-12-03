package com.cydeo.utilities;

//in this class only general utility methods that are NOT related to some specific page

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    //accepts int in seconds and executes Thread.sleep for given duration
    public static void sleep(int seconds)  {
        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //accepts 3 arguments, switches the window accordingly, and asserts the title if it is true
    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedInTitle){
        for (String each : driver.getWindowHandles()) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().contains(expectedInTitle));

    }

    //accepts String expectedTitle and asserts if it is true
    public static void verifyTitle(WebDriver driver, String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    //calls explicitly wait with turning-off implicitly wait and returns WebDriverWait wait
    public static WebDriverWait explicitlyWait(){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        return wait;
    }



}
