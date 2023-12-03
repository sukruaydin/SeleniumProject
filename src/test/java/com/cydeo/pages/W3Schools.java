package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W3Schools {

    public W3Schools(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//iframe[@id='iframeResult']")
    public WebElement iframe;

    @FindBy(xpath = "//p[@id='demo']")
    public WebElement text;

}
