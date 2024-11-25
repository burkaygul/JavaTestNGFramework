package tests.day01_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C01_TestNGFirstClass {

    public static WebDriver driver;

    @BeforeMethod()
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod()
    public void teardown(){
        driver.close();
    }
    @Test
    public void test01(){
        driver.get("https://www.testotomasyonu.com");

        WebElement searchBox = driver.findElement(By.cssSelector("#global-search"));

        searchBox.sendKeys("phone" + Keys.ENTER);

        WebElement searchResult = driver.findElement(By.cssSelector(".product-count-text"));


        // assert 1
        String searchResultText = searchResult.getText();
        searchResultText = searchResultText.replaceAll("\\D","");
        System.out.println(searchResultText);
        int searchResultInt = Integer.parseInt(searchResultText);
        Assert.assertTrue(searchResultInt>0);

        // assert 2
        List<WebElement> resultList = driver.findElements(By.cssSelector("div[class*='product-box']"));
        Assert.assertTrue(resultList.size() > 0);

        //scrennshot
        ReusableMethods.wait(3);
        ReusableMethods.pageScreenshot(driver);


    }
}
