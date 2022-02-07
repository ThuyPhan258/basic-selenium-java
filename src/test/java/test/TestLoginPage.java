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

public class TestLoginPage implements Urls{
    WebDriver driver = DriverFactory.getChromeDriver();

    public TestLoginPage() throws IllegalAccessException {
    }
//    @BeforeTest
//    public void beforeTest(){
//        System.out.println("LoginTest" + " | BeforeTest");
//    }
//
//    @BeforeClass
//    public void beforeClass(){
//        System.out.println("LoginTest" + " | BeforeClass");
//    }
//
//    @BeforeClass
//    public void openLoginPage() {
//        //Open target URL
//        String loginUrl = baseUrl.concat(loginSlug);
//        driver.get(loginUrl);
//        System.out.println("LoginTest" + " | BeforeMethod");
//    }
    @Test
    public void loginWithCorrectCreds() throws IllegalAccessException {
        String usernameStr = "tomsmith";
        String passwordStr = "SuperSecretPassword!";
        WebDriver driver = DriverFactory.getChromeDriver();

        String loginUrl = baseUrl.concat(loginSlug);
        driver.get(loginUrl);

        try {
            //create new Page Model Object
            LoginPage loginPage = new LoginPage(driver);

            FooterComponent footerComponent = new FooterComponent(driver);
            WebElement footerTextElem = footerComponent.footerTextElem();
            footerTextElem.getText();

            loginPage.inputUsername(usernameStr);
            loginPage.inputPassword(passwordStr);
            loginPage.clickOnLoginBtn();

            //Verification
            SoftAssert softAssert = new SoftAssert();
            String actualFooterTexts = loginPage.footerComponent().footerTexts();
            String expectedFooterTexts = "Powered by Elemental Selenium";

            String actualFooterLink = loginPage.footerComponent().footerLink();
            String expectedFooterLink = "http://elementalselenium.com/";

            boolean isFooterTextCorrect = actualFooterLink.equals(expectedFooterLink);
            Assert.assertTrue(isFooterTextCorrect);
            Assert.assertEquals(actualFooterLink, expectedFooterLink, "[ERR] Powered By Link text incorrect");

            softAssert.assertAll();
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }

}
