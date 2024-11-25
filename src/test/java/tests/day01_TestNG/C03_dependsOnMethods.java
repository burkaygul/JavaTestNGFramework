package tests.day01_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C03_dependsOnMethods {

    // Create three different test methods and perform the following tests:
    // Navigate to the Test Automation homepage and verify that the page is loaded.
    // Search for "phone" and verify if any products are found.
    // Click on the first product and verify that the product description contains the word "phone" (case insensitive).
    WebDriver driver;
    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void verifyPage(){
        driver.get("https://www.testotomasyonu.com/");
        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test(priority = 2, dependsOnMethods = "verifyPage")
    public void searchPhone(){
        WebElement searchBox = driver.findElement(By.cssSelector("#global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        // assert 2
        List<WebElement> resultList = driver.findElements(By.cssSelector("div[class*='product-box']"));
        Assert.assertTrue(resultList.size() > 0);
    }

    @Test(priority = 3, dependsOnMethods = "searchPhone")
    public void firstProductVerify(){
        driver.findElement(By.xpath("(//*[@*='product-box my-2  py-1'])[1]")).click();
        WebElement productDescription = driver.findElement(By.xpath("//*[@class='product-short-desc  my-2']"));

        String productDescriptionStr =  productDescription.getText().toLowerCase();
        String expectedContent = "phone";

        Assert.assertTrue(productDescriptionStr.contains(expectedContent));
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
