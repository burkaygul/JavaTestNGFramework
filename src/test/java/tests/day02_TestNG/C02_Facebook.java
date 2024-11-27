package tests.day02_TestNG;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookLoginPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_Facebook {

    @Test
    public void facebookLogin(){


        Driver.getDriver().get("https://facebook.com");

        Faker faker = new Faker();

        FacebookLoginPage facebookLoginPage = new FacebookLoginPage();
        ReusableMethods.wait(2);
        facebookLoginPage.cookies.click();

        facebookLoginPage.emailBox.sendKeys(faker.internet().emailAddress());
        facebookLoginPage.passwordBox.sendKeys(faker.internet().password());

        facebookLoginPage.loginButton.click();

        Assert.assertTrue(facebookLoginPage.loginFailedText.isDisplayed());

        Driver.quitDriver();
    }
}
