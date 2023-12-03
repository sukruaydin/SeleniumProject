package com.cydeo.tests.day07_webtables_utilities;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T3_CRM_Login extends TestBase {

    /*
            TC #3: Login scenario
        1. Create new test and make set ups
        2. Go to : http://login1.nextbasecrm.com/
        3. Enter valid username
        4. Enter valid password
        5. Click to `Log In` button
        6. Verify title is as expected:
        Expected: Portal

        USERNAME                        PASSWORD
        helpdesk1@cybertekschool.com    UserUser
        helpdesk2@cybertekschool.com    UserUser
     */

    @Test
    public void crm_login_test(){
        //2--> go to "https://login1.nextbasecrm.com/"
        driver.get("https://login1.nextbasecrm.com/");

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

        //6--> verify title is as expected, Expected: Portal
        BrowserUtils.verifyTitle(driver, "Portal");

    }

    @Test
    public void crm_login_test_2(){
        //2--> go to "https://login1.nextbasecrm.com/"
        driver.get("https://login1.nextbasecrm.com/");

        CRM_Utilities.crm_login(driver);

        //6--> verify title is as expected, Expected: Portal
        BrowserUtils.verifyTitle(driver, "Portal");

    }

    @Test
    public void crm_login_test_3(){
        //2--> go to "https://login1.nextbasecrm.com/"
        driver.get("https://login1.nextbasecrm.com/");

        CRM_Utilities.crm_login(driver, "helpdesk2@cybertekschool.com", "UserUser");
        BrowserUtils.sleep(2);

        //6--> verify title is as expected, Expected: Portal
        BrowserUtils.verifyTitle(driver, "Portal");

    }



}
