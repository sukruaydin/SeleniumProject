package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_T2_xpath_cssSelector_practice {

    public static void main(String[] args) throws InterruptedException {

        /*
                    XPATH and CSS Selector PRACTICES
            DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
            TC #1: XPATH and cssSelector Practices
                1. Open Chrome browser
                2. Go to https://practice.cydeo.com/forgot_password
                3. Locate all the WebElements on the page using XPATH and/or CSS
                locator only (total of 6)

                a. “Home” link
                b. “Forgot password” header
                c. “E-mail” text
                d. E-mail input box
                e. “Retrieve password” button
                f. “Powered by Cydeo text
                4. Verify all web elements are displayed.
                First solve the task with using cssSelector only. Try to create 2 different
                cssSelector if possible
                Then solve the task using XPATH only. Try to create 2 different
                XPATH locator if possible
         */

        //1--> setup, open, and maximize the browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2--> go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");
        Thread.sleep(1000);

        //3--> locating elements

        //3.1
        //locating "Home" link using cssSelector (class attribute)
        WebElement homeLink1 = driver.findElement(By.cssSelector("a[class='nav-link']"));
        //locating "Home" link using cssSelector syntax2
        WebElement homeLink2 = driver.findElement(By.cssSelector("a[class='nav-link']"));
        //locating "Home" link using cssSelector (href attribute)
        WebElement homeLink3 = driver.findElement(By.cssSelector("a[href='/']"));

        //3.2
        //locating "Forgot password" header using cssSelector and move down to h2, syntax2
        WebElement header1 = driver.findElement(By.cssSelector("div.example > h2"));
        //locating "Forgot password" header using xpath, text()
        WebElement header2 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));
        //   . --> stands for text()
        WebElement header3 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        //3.3
        //locating "E-mail" text using cssSelector, (for)
        WebElement emailText1 = driver.findElement(By.cssSelector("label[for='email']"));
        //locating "E-mail" text using xpath, text()
        WebElement emailText2 = driver.findElement(By.xpath("//label[text()='E-mail']"));
        //locating "E-mail" text using xpath, .
        WebElement emailText3 = driver.findElement(By.xpath("//label[.='E-mail']"));
        //locating "E-mail" text using xpath, (for)
        WebElement emailText4 = driver.findElement(By.xpath("//label[@for='email']"));

        //3.4
        //locating E-mail input box using sccSelector, type
        WebElement inputBox1 = driver.findElement(By.cssSelector("input[type='text']"));
        //locating E-mail input box using sccSelector, name
        WebElement inputBox2 = driver.findElement(By.cssSelector("input[name='email']"));
        //locating E-mail input box using xpath, name
        WebElement inputBox3 = driver.findElement(By.xpath("//input[@name='email']"));
        //locating E-mail input box using xpath, CONTAINS method
        //tagName[contains(attribute='value')]
        WebElement inputBox4 = driver.findElement(By.xpath("//input[contains(@pattern, 'a-z0-9')]"));

        //3.5
        //locating “Retrieve password” button using cssSelector, class
        WebElement retrieveButton1 = driver.findElement(By.cssSelector("button[class='radius']"));
        //locating “Retrieve password” button using xpath, id
        WebElement retrieveButton2 = driver.findElement(By.xpath("//button[@id='form_submit']"));
        //locating “Retrieve password” button using xpath, type
        WebElement retrieveButton3 = driver.findElement(By.xpath("//button[@type='submit']"));

        //3.6
        //locating “Powered by Cydeo" text using
        WebElement poweredByCydeoText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        //4--> verify all web elements are displayed.
        System.out.println("homeLink1.isDisplayed() = " + homeLink1.isDisplayed());
        System.out.println("header1.isDisplayed() = " + header1.isDisplayed());
        System.out.println("emailText1.isDisplayed() = " + emailText1.isDisplayed());
        System.out.println("inputBox1.isDisplayed() = " + inputBox1.isDisplayed());
        System.out.println("retrieveButton1.isDisplayed() = " + retrieveButton1.isDisplayed());
        System.out.println("poweredByCydeoText.isDisplayed() = " + poweredByCydeoText.isDisplayed());

        //5--> closing browser
        driver.close();

    }

}
