package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.W3Schools;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class T1_DoubleClick {

    /*
            TC #1: Double Click Test
        1. Go to
        https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        2. Switch to iframe.
        3. Double-click on the text “Double-click me to change my text color.”
        4. Assert: Text’s “style” attribute value contains “red”.
        NOTE: FOLLOW POM

     */

    @Test
    public void t1_double_click_test()  {
        //1--> setup, open, maximize, implicitly wait the driver and get to the page
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //2--> switch to iframe.
        //creating W3Schools object to use its methods and variables
        W3Schools w3Schools = new W3Schools();
        Driver.getDriver().switchTo().frame(w3Schools.iframe);

        //3--> double-click on the text “Double-click me to change my text color.”
        //to double-click we need Actions class and its methods
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(w3Schools.text).perform();

        //4--> assert: Text’s “style” attribute value contains “red”.
        Assert.assertTrue(w3Schools.text.getAttribute("style").contains("red"));


        //5--> closing browser
        Driver.closeDriver();



    }

    @Test
    public void test4(){
        NoSuchElementException noSuchElementException = new NoSuchElementException();

       //boolean a = noSuchElementException instanceof ClassNotFoundException;
        System.out.println("a = " + a);
    }

}
