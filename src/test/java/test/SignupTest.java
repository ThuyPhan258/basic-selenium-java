package test;

import driver.DriverFactory;
import models.components.global.FooterComponent;
import models.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import url.Urls;

import java.sql.SQLOutput;

public class SignupTest implements Urls{
    WebDriver driver = DriverFactory.getChromeDriver();

    public SignupTest() throws IllegalAccessException {
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("SignupTest" + " | BeforeTest");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("SignupTest" + " | BeforeClass");
    }

    @BeforeMethod
    public void openLoginPage() {
        System.out.println("SignupTest" + " | BeforeMethod");
    }
    @Test
    public void signUpM01(){
        System.out.println("SignupTest" + " | signUpM01");
    }

    @Test
    public void signUpM02(){
        System.out.println("SignupTest" + " | signUpM02");
    }
}
