package tests;

import driver.DriverFactory;
import models.components.global.FooterComponent;
import models.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class TestLoginPage implements Urls {
    public static void main(String[] args) throws IllegalAccessException {
        String usernameStr = "tomsmith";
        String passwordStr = "SuperSecretPassword!";
        WebDriver driver = DriverFactory.getChromeDriver();

        //Open target URL
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

            System.out.println("Footer text:" + loginPage.footerComponent().footerTexts());
            System.out.println("Footer Link:" + loginPage.footerComponent().footerLink());
            Thread.sleep(2000);
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}
