package test_flows.authentication;

import models.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import test.CredsData;

public class LoginFlow {
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginFlow(WebDriver driver) {
        this.driver = driver;
    }

    private void initLoginPage(){
        loginPage = new LoginPage(driver);
    }

    //main flow
    public LoginFlow login(CredsData credsData){
        if(loginPage == null)
            initLoginPage();
        //create new Page Model Object
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(credsData.getUsername());
        loginPage.inputPassword(credsData.getPassword());
        loginPage.clickOnLoginBtn();
        return this;
    }

    public LoginFlow verifyLoginWithCorrectCreds(){
        if(loginPage == null)
            throw new RuntimeException("Please call method login before verify");

        //Verification
        String actualFooterTexts = loginPage.footerComponent().footerTexts();
        String expectedFooterTexts = "Powered by Elemental Selenium";

        String actualFooterLink = loginPage.footerComponent().footerLink();
        String expectedFooterLink = "http://elementalselenium.com/";

        //boolean isFooterTextCorrect = actualFooterLink.equals(expectedFooterLink);
        Assert.assertEquals(actualFooterTexts, expectedFooterTexts);
        Assert.assertEquals(actualFooterLink, expectedFooterLink, "[ERR] Powered By Link text incorrect");

        return this;
    }
    public void verifyLoginWithInCorrectCreds(){

    }

    //main verification methods

}
