package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        //1--> Set up driver
        //We create our "Browser Driver"
        WebDriverManager.chromedriver().setup();

        //2--> Create the instance of the driver
        //This line opens an empty webPage
        WebDriver driver = new ChromeDriver();

        //maximize the page
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen(); //sometimes it doesn't work

        //3--> go to https://www.tesla.com
        driver.get("https://www.tesla.com");

        //get the title
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        //get url
        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        //stop code execution for 1.5 sec
        Thread.sleep(1500);

        //use selenium to navigate back
        driver.navigate().back();

        //stop code execution for 1.5 sec
        Thread.sleep(1500);

        //use selenium to navigate forward
        driver.navigate().forward();

        //stop code execution for 1.5 sec
        Thread.sleep(1500);

        //use selenium to refresh
        driver.navigate().refresh();

        //stop code execution for 1.5 sec
        Thread.sleep(1500);

        //use selenium to go to another page
        driver.navigate().to("https://www.google.com");

        //stop code execution for 1.5 sec
        Thread.sleep(1500);

        //it gets the title of the page
        currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        //stop code execution for 1.5 sec
        Thread.sleep(1500);

        //get url
        currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        //close the page
        driver.close();

        //kills the current session, means closes all the windows
        driver.quit();



    }

}
