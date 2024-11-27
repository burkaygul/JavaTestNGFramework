package tests.day03_TestNGAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.concurrent.ConcurrentHashMap;

public class C01_NegativeLoginTest {

    //Navigate to the homepage: https://www.testotomasyonu.com/.
    //Click on the Login link.
    //Create 3 separate test methods:
    //Test 1: Enter a valid username and an invalid password.
    //Test 2: Enter an invalid username and a valid password.
    //Test 3: Enter an invalid username and an invalid password.
    //Click the Login button to attempt login.
    //Verify that login is unsuccessful (e.g., an error message is displayed or the user is not redirected to a dashboard).

    @Test
    public void invalidPassword(){
        //Navigate to the homepage: https://www.testotomasyonu.com/.
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //Click on the Login link.
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();

        //Test 1: Enter a valid mail and an invalid password.
        testOtomasyonuPage.emailBox.sendKeys(ConfigReader.getProperty("toValidMail"));
        testOtomasyonuPage.passwordBox.sendKeys(ConfigReader.getProperty("toInvalidPassword"));

        //Click the Login button to attempt login.
        testOtomasyonuPage.loginButton.click();

        //Verify that login is unsuccessful (e.g., an error message is displayed or the user is not redirected to a dashboard).
        Assert.assertTrue(testOtomasyonuPage.emailBox.isEnabled());

        Driver.quitDriver();
    }

    @Test
    public void invalidMail(){
        //Navigate to the homepage: https://www.testotomasyonu.com/.
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //Click on the Login link.
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();

        //Test 1: Enter a valid mail and an invalid password.
        testOtomasyonuPage.emailBox.sendKeys(ConfigReader.getProperty("toValidMail"));
        testOtomasyonuPage.passwordBox.sendKeys(ConfigReader.getProperty("toInvalidPassword"));

        //Click the Login button to attempt login.
        testOtomasyonuPage.loginButton.click();

        //Verify that login is unsuccessful (e.g., an error message is displayed or the user is not redirected to a dashboard).
        Assert.assertTrue(testOtomasyonuPage.emailBox.isEnabled());

        Driver.quitDriver();
    }

    @Test
    public void invalidMailPassword(){
        //Navigate to the homepage: https://www.testotomasyonu.com/.
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //Click on the Login link.
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();

        //Test 1: Enter a valid mail and an invalid password.
        testOtomasyonuPage.emailBox.sendKeys(ConfigReader.getProperty("toInvalidMail"));
        testOtomasyonuPage.passwordBox.sendKeys(ConfigReader.getProperty("toInvalidPassword"));

        //Click the Login button to attempt login.
        testOtomasyonuPage.loginButton.click();

        //Verify that login is unsuccessful (e.g., an error message is displayed or the user is not redirected to a dashboard).
        Assert.assertTrue(testOtomasyonuPage.emailBox.isEnabled());

        Driver.quitDriver();
    }


}
