package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T4_Config_Practice {

    /*
            TC #4: Google search
        1- Open a chrome browser
        2- Go to: https://google.com
        3- Write “apple” in search box
        4- Verify title:
        Expected: apple - Google Search

        Use `configuration.properties` for the following:
        1. The browser type
        2. The URL
        3. The search keyword
        4. Make title verification dynamic. If search value changes, title
        assertion should not fail.
     */


    @BeforeMethod
    public void setUpMethod(){
        /*//1--> setup, open, maximize, and implicitly wait
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
    }

    @AfterMethod
    public  void tearDownMethod(){
        //closing browser
        Driver.getDriver().close();
    }
    @Test
    public void google_search_test(){
        //2--> go to https://google.com
        String googleUrl = ConfigurationReader.getProperty("googleUrl");
        Driver.getDriver().get(googleUrl);

        //3--> write “apple” in search box
        //locating the searchBox
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));
        //providing "apple"
        String searchData = ConfigurationReader.getProperty("searchValue");
        searchBox.sendKeys(searchData + Keys.ENTER);

        //4--> verify title, Expected: apple - Google Search
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = searchData+" - Google'da Ara";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

}
