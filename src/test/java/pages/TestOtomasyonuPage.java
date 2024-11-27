package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuPage {

    public TestOtomasyonuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "global-search")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@*='product-box my-2  py-1']")
    public List<WebElement> productElementList;

    @FindBy(css = "#priceproduct")
    public WebElement priceElement;

    @FindBy(xpath = "//*[text()='Account']")
    public WebElement accountLink;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id ="submitlogin")
    public WebElement loginButton;

    @FindBy(xpath = "(//div[@class ='prod-detail']/div)[1]")
    public WebElement productNameElement;
}
