package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class T1_Registration_Form {

    /*
                TC#1: Registration form confirmation
            Note: Use JavaFaker OR read from configuration.properties file when possible.
            1. Open browser
            2. Go to website: https://practice.cydeo.com/registration_form
            3. Enter first name
            4. Enter last name
            5. Enter username
            6. Enter email address
            7. Enter password
            8. Enter phone number
            9. Select a gender from radio buttons
            10.Enter date of birth
            11.Select Department/Office
            12.Select Job Title
            13.Select programming language from checkboxes
            14.Click to sign up button
            15.Verify success message “You’ve successfully completed registration!” is
            displayed.
            Note:
            1. Use new Driver utility class and method
            2. User JavaFaker when possible
            3. User ConfigurationReader when it makes sense
     */

    @Test
    public void registration_form_test(){
        //1--> setup, open, maximize, implicitly, wait and read from properties
        String registrationFormUrl = ConfigurationReader.getProperty("registration.form.url");
        Driver.getDriver().get(registrationFormUrl);

        //2--> enter first name
        WebElement inputFirstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        //providing the firstName by java faker
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        inputFirstName.sendKeys(firstName);

        //3--> enter last name
        WebElement inputLastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        //providing the lastName by java faker
        String lastName = faker.name().lastName();
        inputLastName.sendKeys(lastName);

        //4--> enter username
        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        //providing the username by java faker
        String username = faker.name().username();
        username = username.replace(".","");
        inputUsername.sendKeys(username);
        //inputUsername.sendKeys(faker.bothify("helpdesk###"));

        //5--> enter email address
        WebElement inputEmail = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        //providing the email by java faker
        inputEmail.sendKeys(username+"@cydeo.com");

        //6--> enter password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        //providing the password by java faker
        inputPassword.sendKeys(faker.bothify("??##???#?##"));

        //7--> enter phone number
        WebElement inputPhoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        //providing the number by java faker
        inputPhoneNumber.sendKeys(faker.numerify("571-###-####"));

        //8--> select a gender from radio buttons
        WebElement maleRadioButton = Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        maleRadioButton.click();

        //9--> enter date of birth
        WebElement inputBirthday = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        int month = faker.number().numberBetween(1, 12);
        int day = faker.number().numberBetween(1, 30);
        int year = faker.number().numberBetween(1950, 2022);
        inputBirthday.sendKeys(month+"/"+day+"/"+year);

        //10--> select Department/Office
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        List<WebElement> departments = Driver.getDriver().findElements(By.xpath("//select[@name='department']//option"));
        int number = faker.number().numberBetween(1, departments.size());
        departmentDropdown.selectByIndex(number);

        //11--> select Job Title
        Select jobTitleDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        List<WebElement> jobTitles = Driver.getDriver().findElements(By.xpath("//select[@name='job_title']//option"));
        int number2 = faker.number().numberBetween(1, jobTitles.size());
        jobTitleDropdown.selectByIndex(number2);

        //12--> select programming language from checkboxes
        List<WebElement> programmingLanguages = Driver.getDriver().findElements(By.xpath("(//div[@class='col-sm-5'])[11]//input"));
        int number3 = faker.number().numberBetween(0, programmingLanguages.size()-1);
        programmingLanguages.get(number3).click();

        //13--> click to sign up button
        WebElement buttonSignUp = Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));
        buttonSignUp.click();

        WebElement textMessage = Driver.getDriver().findElement(By.xpath("//p[.=\"You've successfully completed registration!\"]"));
        String actualText = textMessage.getText();
        String expectedText = "You've successfully completed registration!";

        Assert.assertEquals(actualText, expectedText);

    }

}
