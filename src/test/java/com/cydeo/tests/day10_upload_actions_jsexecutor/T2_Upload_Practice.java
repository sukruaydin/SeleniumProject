package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {

    /*
                TC #2 Upload Test
            1. Go to https://practice.cydeo.com/upload
            2. Find some small file from your computer, and get the path of it.
            3. Upload the file.
            4. Assert:
            -File uploaded text is displayed on the page
     */
    @Test
    public void upload_test(){
        //1--> setup, open, maximize, implicitly wait, and go to webpage
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //2--> find some small file from your computer, and get the path of it.
        String path = "C:\\Users\\sukra\\Desktop\\CYDEO\\4- Test Automation\\_HTML\\day02 - HTML\\tasks\\champions_league_task_2\\Galatasaray.jpg";

        //3--> upload the file
        //selecting the file
        WebElement chooseFile = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        chooseFile.sendKeys(path);
        //uploading
        WebElement uploadButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']"));
        uploadButton.click();

        //4--> assert :  "File Uploaded!" text is displayed on the page
        WebElement header = Driver.getDriver().findElement(By.xpath("//h3[.='File Uploaded!']"));
        String actualHeader = header.getText();
        String expectedHeader = "File Uploaded!";

        Assert.assertEquals(actualHeader, expectedHeader);
    }

}
