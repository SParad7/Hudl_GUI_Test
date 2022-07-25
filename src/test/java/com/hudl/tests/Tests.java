package com.hudl.tests;
import com.hudl.pages.BasePage;
import com.hudl.pages.HomePage;
import com.hudl.pages.LoginPage;
import com.hudl.utilities.ConfigurationReader;
import com.hudl.utilities.Helpers;
import org.testng.Assert;
import org.testng.annotations.*;


public class Tests extends BaseTest  {

    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    String loginEmail = ConfigurationReader.getProperty("email");
    String password = ConfigurationReader.getProperty("password");

    @Test(priority = 1)
    public void verifyBasePage(){
        basePage.openBasePage();
        Helpers.waitForElementIsVisible(basePage.loginButton, 2);
        Helpers.waitForElementIsVisible(basePage.dataTable,2);
        Helpers.waitForElementIsVisible(basePage.baseText, 2);

        String actualText = basePage.baseText.getText().trim();
        String expectedText = "We power sports.";

        Assert.assertEquals(expectedText, actualText);

        Helpers.click(basePage.loginButton);
        Helpers.waitForElementIsVisible(loginPage.loginButton,2);

        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test(priority = 2)
    public void verifyLoginPage(){
        loginPage.openLoginPage();
        Helpers.waitForElementIsVisible(loginPage.emailField,2);
        Helpers.waitForElementIsVisible(loginPage.passwordField, 2);
        Helpers.waitForClickablility(loginPage.loginButton,2);
        Helpers.waitForClickablility(loginPage.signUpButton,2);

        Helpers.click(loginPage.signUpButton);

        Helpers.waitForElementIsVisible(loginPage.singUpDataTable, 2);
        Helpers.waitForElementIsVisible(loginPage.registerButton, 2);

        String expectedButton = loginPage.registerButton.getText().trim();
        String actualText = "High Schools, Clubs & Colleges";
        Assert.assertEquals(expectedButton, actualText);
    }

    @Test(priority = 4)
    public void loginWithCorrectCredentials(){
        loginPage.openLoginPage();
        loginPage.sendKeys(loginPage.emailField, loginEmail);
        loginPage.sendKeys(loginPage.passwordField, password);
        loginPage.click(loginPage.loginButton);

        Helpers.waitForElementIsVisible(homePage.header, 1);
        Helpers.waitForElementIsVisible(homePage.dataTable, 1);

        String homeButton = homePage.homeButton.getText();
        String expectedTitle = "Home";
        Assert.assertEquals(expectedTitle, homeButton);
    }

    @Test(priority = 3)
    public void failedLogin(){
        loginPage.openLoginPage();
        loginPage.sendKeys(loginPage.emailField, "email");
        loginPage.sendKeys(loginPage.passwordField, "password");
        loginPage.click(loginPage.loginButton);
        Helpers.waitForElementIsVisible(loginPage.errorMessage, 1);

        String errorMessage = loginPage.errorMessage.getText();
        Assert.assertEquals(errorMessage, "We didn't recognize that email and/or password.Need help?");
    }
}
