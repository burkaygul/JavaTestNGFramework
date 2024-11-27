package tests.day02_TestNG;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;

import java.util.List;

public class C03_Dropdown {

    @Test
    public void test01(){
        //1 - Navigate to the URL: https://testotomasyonu.com/form
        Driver.getDriver().get("https://testotomasyonu.com/form");
        // 2 - Select "5" from the birth date day option using index.
        TestOtomasyonuFormPage testOtomasyonuFormPage = new TestOtomasyonuFormPage();
        Select daySelect = new Select(testOtomasyonuFormPage.dayDropdown);
        daySelect.selectByIndex(5);

        //3 - Select "April" from the birth date month option using value.
        Select monthSelect = new Select(testOtomasyonuFormPage.monthDropdown);
        monthSelect.selectByValue("subat");

        // 4 - Select "1990" from the birth date year option using visible text.
        Select yearSelect = new Select(testOtomasyonuFormPage.yearDropdown);
        yearSelect.selectByVisibleText("1990");

        //5 - Print the selected values in the console.
        System.out.println(daySelect.getFirstSelectedOption().getText());
        System.out.println(monthSelect.getFirstSelectedOption().getText());
        System.out.println(yearSelect.getFirstSelectedOption().getText());

        //6 - Print all the values (value attributes) from the month dropdown menu in the console.
        List<WebElement> mounthValues = monthSelect.getOptions();

        for (int i = 0; i < mounthValues.size(); i++) {
            System.out.println(mounthValues.get(i).getText());
        }
        //7 - Verify that the size of the month dropdown menu is 13.
        int expectedSize = 13;
        int actualSize = mounthValues.size();
        Assert.assertEquals(actualSize,expectedSize);

    }
}
