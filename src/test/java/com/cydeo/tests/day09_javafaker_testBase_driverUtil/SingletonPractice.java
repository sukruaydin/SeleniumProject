package com.cydeo.tests.day09_javafaker_testBase_driverUtil;

import com.cydeo.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.Test;

public class SingletonPractice {

    @Test (priority = 2)
    public void singleton_understanding_test1(){
        Driver.getDriver().get("https://www.yandex.com");
        String str1 = Singleton.getWord();
        System.out.println("str1 = " + str1);

        String str2 = Singleton.getWord();
        System.out.println("str2 = " + str2);

        String str3 = Singleton.getWord();
        System.out.println("str3 = " + str3);
    }

    @Test (priority = 1)
    public void singleton_understanding_test2(){
        String str4 = Singleton.getWord();
        System.out.println("str4 = " + str4);
        Driver.getDriver().get("https://www.google.com");
        Driver.closeDriver();
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        SessionId sessionId = driver.getSessionId();

        //Driver.getDriver().findElement()


    }

}
