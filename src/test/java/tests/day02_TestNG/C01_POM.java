package tests.day02_TestNG;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;

public class C01_POM {

    @Test
    public void searchTest(){
        Driver.getDriver().get("https://www.testotomasyonu.com");


        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.searchBox.sendKeys("phone" + Keys.ENTER);

        Assert.assertTrue(testOtomasyonuPage.productElementList.size()>0);


        testOtomasyonuPage.productElementList.get(0).click();

        String price = testOtomasyonuPage.priceElement.getText();

        price = price.replaceAll("\\D","");
        System.out.println(price); // 79900

        int actualPrice =Integer.parseInt(price)/100;
        int expectedMaxPrice = 1000;
        Assert.assertTrue(actualPrice<expectedMaxPrice);
    }
}
