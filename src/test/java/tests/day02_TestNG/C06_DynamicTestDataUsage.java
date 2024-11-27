package tests.day02_TestNG;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_DynamicTestDataUsage {

    @Test
    public void testDynamicData() {
        //1. Navigate to the Test Automation homepage.
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2. Perform a search for a specified keyword.
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.searchBox.sendKeys(ConfigReader.getProperty("toSearchWord") + Keys.ENTER);

        //3. Verify that a product can be found in the search results.
        Assert.assertTrue(testOtomasyonuPage.productElementList.size()>0);

        //4. Close the page.
        ReusableMethods.wait(2);
        Driver.quitDriver();

    }


}
