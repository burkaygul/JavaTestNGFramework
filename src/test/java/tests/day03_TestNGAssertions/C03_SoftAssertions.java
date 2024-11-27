package tests.day03_TestNGAssertions;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_SoftAssertions {

    @Test
    public void testSoftAssertion(){

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        String expectedUrlIcerik = "testotomasyonuq";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(actualUrl.contains(expectedUrlIcerik), "actualUrl doesnt contain expectedUrl");

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.searchBox.sendKeys(ConfigReader.getProperty("searchTerm") + Keys.ENTER);

        softAssert.assertTrue(testOtomasyonuPage.productElementList.size() > 0 );

        testOtomasyonuPage.productElementList.get(0).click();

        String actualProductName = testOtomasyonuPage.productNameElement.getText().toLowerCase();
        String expectedProductName = ConfigReader.getProperty("searchTerm").toLowerCase();

        softAssert.assertTrue(actualProductName.contains(expectedProductName));

        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.quitDriver();


    }
}
