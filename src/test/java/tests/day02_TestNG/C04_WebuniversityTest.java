package tests.day02_TestNG;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebuniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C04_WebuniversityTest {

    @Test
    public void test01(){
        //1. Navigate to "http://webdriveruniversity.com/".
        Driver.getDriver().get("http://webdriveruniversity.com/");

        //2. Scroll down to the "Login Portal" section.
        WebuniversityPage webuniversityPage = new WebuniversityPage();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",webuniversityPage.loginPortalCaption);

        String WHD = Driver.getDriver().getWindowHandle();
        //3. Click on "Login Portal".
        webuniversityPage.loginPortalLink.click();
        //4. Switch to the other window.
        Set<String> allWHDs = Driver.getDriver().getWindowHandles();

        for (String eachWHD : allWHDs){
            if (eachWHD != WHD){
                Driver.getDriver().switchTo().window(eachWHD);
            }
        }

        //5. Enter random values into the "username" and "password" fields.
        Faker faker = new Faker();
        webuniversityPage.usernameBox.sendKeys(faker.name().username());
        webuniversityPage.passwordBox.sendKeys(faker.internet().password());
        //6. Click the "login" button.
        webuniversityPage.loginButton.click();

        //7. Verify that the text in the popup says "validation failed".
        ReusableMethods.wait(3);
        String actualText = Driver.getDriver().switchTo().alert().getText();
        String expectedText = "validation failed";

        Assert.assertEquals(actualText,expectedText);
        //8. Close the popup by clicking OK.
        Driver.getDriver().switchTo().alert().accept();

        //9. Return to the first page.
        Driver.getDriver().switchTo().window(WHD);

        //10. Verify that you have returned to the first page.
        Assert.assertTrue(webuniversityPage.loginPortalCaption.isDisplayed());

        Driver.getDriver().close();

    }
}
