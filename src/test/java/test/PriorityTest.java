package test;

import driver.DriverFactory;
import models.components.global.FooterComponent;
import models.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import url.Urls;

import java.sql.SQLOutput;

public class PriorityTest implements Urls{
    WebDriver driver = DriverFactory.getChromeDriver();

    public PriorityTest() throws IllegalAccessException {
    }
    @Test(priority = 1)
    public void zMethod(){
        System.out.println("zMethod");
        Assert.assertFalse(true);
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
