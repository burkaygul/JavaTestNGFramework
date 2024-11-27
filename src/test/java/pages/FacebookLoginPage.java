package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookLoginPage {

    public FacebookLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[text()='Alle Cookies erlauben'])[2]")
    public WebElement cookies;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "pass")
    public WebElement passwordBox;

    @FindBy(name = "login")
    public WebElement loginButton;

    @FindBy(css = "._9ay7")
    public WebElement loginFailedText;
}
