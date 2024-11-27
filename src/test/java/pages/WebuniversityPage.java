package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebuniversityPage {

    public WebuniversityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='LOGIN PORTAL']")
    public WebElement loginPortalCaption;

    //Login Portal
    @FindBy(xpath = "//*[text()='Login Portal']")
    public WebElement loginPortalLink;

    @FindBy(id ="text")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "login-button")
    public WebElement loginButton;
}
