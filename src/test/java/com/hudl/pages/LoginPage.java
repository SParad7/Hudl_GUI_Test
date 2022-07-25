package com.hudl.pages;

import com.hudl.utilities.ConfigurationReader;
import com.hudl.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "logIn")
    public WebElement loginButton;

    @FindBy(xpath = "//p[@data-qa-id='error-display']")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[@href='/register/signup']")
    public WebElement signUpButton;

    @FindBy (xpath = "//div[@class='outer']")
    public WebElement singUpDataTable;

    @FindBy(id = "register_demo")
    public WebElement registerButton;

    public void clear(WebElement e) {
        e.clear();
    }

    public void click(WebElement e) {
        e.click();
    }

    public void sendKeys(WebElement e, String txt) {
        e.sendKeys(txt);
    }

    public void openLoginPage() {
        String url = ConfigurationReader.getProperty("loginPageURl");
        Driver.getDriver().navigate().to(url);
    }

}
