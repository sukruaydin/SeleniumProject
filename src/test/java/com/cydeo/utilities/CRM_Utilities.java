package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//env : http://login1.nextbasecrm.com/

public class CRM_Utilities {

    //will log in with helpdesk1@cybertekschool.com user
    public static void crm_login(WebDriver driver){
        //3--> enter valid username
        //locating login box
        WebElement loginBox = driver.findElement(By.xpath("//input[@placeholder='Login']"));
        //providing valid username
        loginBox.sendKeys("helpdesk1@cybertekschool.com");

        //4--> enter valid password
        //locating password box
        WebElement passwordBox = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        //providing valid password
        passwordBox.sendKeys("UserUser");

        //5--> click to `Log In` button
        //locating LogIn button
        WebElement logInButton = driver.findElement(By.xpath("//input[@onclick=\"BX.addClass(this, 'wait');\"]"));
        logInButton.click();
    }

    //will log in with given username and password
    public static void crm_login(WebDriver driver, String username, String password){
        //3--> enter valid username
        //locating login box
        WebElement loginBox = driver.findElement(By.xpath("//input[@placeholder='Login']"));
        //providing valid username
        loginBox.sendKeys(username);

        //4--> enter valid password
        //locating password box
        WebElement passwordBox = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        //providing valid password
        passwordBox.sendKeys(password);

        //5--> click to `Log In` button
        //locating LogIn button
        WebElement logInButton = driver.findElement(By.xpath("//input[@onclick=\"BX.addClass(this, 'wait');\"]"));
        logInButton.click();
    }

}
