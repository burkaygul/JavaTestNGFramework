package tests.day03_TestNGAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_TestNG_Assertions {


    @Test
    public void test01(){
        // Navigate to the Test Automation homepage
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // Verify that the URL matches the test data provided
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty("toUrl");

        Assert.assertEquals(actualUrl, expectedUrl, "url config.pro ayri");

        // Verify that the URL is not "http://www.testotomasyonu.com"
        Assert.assertNotEquals(actualUrl,expectedUrl,"url istenmeyen degerine sahip");

        // Verify that the title contains the word "Test"
        String expectedTitleContent = "Test";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleContent), "title has not expectedTitleContent");

        // Verify that the title does not contain the word "Java"
        String unexpectedTitleContent = "Java";
        Assert.assertFalse(actualTitle.contains("Java"), "titel does not contain the word Java");


        // Close the page
        ReusableMethods.wait(3);
        Driver.getDriver().close();
    }


}
