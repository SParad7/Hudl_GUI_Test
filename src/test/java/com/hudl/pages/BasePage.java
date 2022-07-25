package com.hudl.pages;
import com.hudl.utilities.ConfigurationReader;
import com.hudl.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    @FindBy(xpath = "//*[@data-qa-id='login']")
    public WebElement loginButton;

    @FindBy(id="maincontent")
    public WebElement dataTable;

    @FindBy(xpath = "//*[contains(text(),'We power sports.')]")
    public WebElement baseText;

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void openBasePage() {
        String url = ConfigurationReader.getProperty("basePageURL");
        Driver.getDriver().navigate().to(url);
    }

    public void clear(WebElement e) {
        e.clear();
    }

    public void sendKeys(WebElement e, String txt) {
        e.sendKeys(txt);
    }



}
