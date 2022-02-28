package test;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import url.Urls;

public class PriorityTest implements Urls{
    WebDriver driver = DriverFactory.getChromeDriver();

    public PriorityTest() throws IllegalAccessException {
    }
    @Test(priority = 1)
    public void zMethod(){
        System.out.println("zMethod");
        //Assert.assertFalse(true);
    }

    @Test(priority = 2, dependsOnMethods = {"zMethod"})
    public void yMethod(){
        System.out.println("yMethod");
    }

    @Test(priority = 3)
    public void xMethod(){
        System.out.println("xMethod");
    }

}
