package com.hudl.pages;

import com.hudl.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="koMain")
    public WebElement dataTable;

    @FindBy(id="ssr-webnav")
    public WebElement header;

    @FindBy(xpath = "//*[@data-qa-id='webnav-globalnav-home']")
    public WebElement homeButton;


}
