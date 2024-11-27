package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuFormPage {

    public TestOtomasyonuFormPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//select[@class='form-control'])[1]")
    public WebElement dayDropdown;

    @FindBy(xpath = "(//select[@class='form-control'])[2]")
    public WebElement monthDropdown;
    @FindBy(xpath = "(//select[@class='form-control'])[3]")
    public WebElement yearDropdown;


}
