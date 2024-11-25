package tests.day01_TestNG;

import org.testng.annotations.Test;

public class C02_Priority {

    @Test(priority = 0)
    public void testAutomation(){
        System.out.println("test automation executed successfully");
    }

    @Test(priority = 1)
    public void wiseQuarter(){
        System.out.println("wiseQuarter executed successfully");
    }

    @Test(priority = 2)
    public void youtube(){
        System.out.println("youtube executed successfully");
    }
}
