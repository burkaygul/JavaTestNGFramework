package tests.day01_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;

public class C04_POM {

    @Test
    public void test01(){

        Driver.getDriver().get("https://www.testotomasyonu.com");
        WebElement searchBox = Driver.getDriver().findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);
        ReusableMethods.wait(5);
        Driver.quitDriver();
    }
}
