package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

//env : https://practice.cydeo.com/web-tables

public class WebTableUtils {

    //This method should accept a costumerName and return the costumer order date as a String.
    public static String returnOrderDate(WebDriver driver, String customerName){
        String locator = "//td[.='"+customerName+"']//following-sibling::td[3]";
        WebElement customerDateCell = driver.findElement(By.xpath(locator));
        return customerDateCell.getText();
    }

    // This method should accept mentioned arguments and internally assert expectedOrderDate matching actualOrderDate.
    public static void orderVerify(WebDriver driver, String customerName, String expectedOrderDate){
        WebElement customerDateCell = driver.findElement(By.xpath("//td[.='" + customerName + "']//following-sibling::td[3]"));
        String actualOrderDate = customerDateCell.getText();

        Assert.assertEquals(actualOrderDate, expectedOrderDate);
    }

    public static void getTableGetEmail(WebDriver driver, String tableNum, String firstName){
        //?????????
    }

}
