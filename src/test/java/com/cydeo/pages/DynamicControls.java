package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControls {


    public DynamicControls(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //FOR TEST_1
    @FindBy(xpath = "//button[@onclick='swapCheckbox()']")
    public WebElement removeButton;

    @FindBy(xpath = "//div[@id='loading']")
    public WebElement loadingBar;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBox;

    @FindBy(xpath = "//p[@id='message']")
    public WebElement text;

    //FOR TEST_2
    @FindBy(xpath = "//button[@onclick='swapInput()']")
    public WebElement enableButton;

    @FindBy(xpath = "//div[@id='loading']")
    public WebElement loadingBar2;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputBar;

    @FindBy(xpath = "//p[@id='message']")
    public WebElement isEnabledMessage;

    @FindBy(id = "search-icon")
    public WebElement searchButton;

}
