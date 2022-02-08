package models.pages;

import io.qameta.allure.Step;
import models.components.global.FooterComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class LoginPage {
    private static WebDriver driver;
    private static final By usernameSel = By.id("username");
    private static final By passwordSel = By.cssSelector("#password");
    private static final By loginBtnSel = By.cssSelector("[type='submit']");

    private final FooterComponent footerComponent;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        footerComponent = new FooterComponent(driver);
    }
    private WebElement usernameElem(){
        return driver.findElement(usernameSel);
    }

    @Step("Input username as {usernameStr}")
    public void inputUsername(String usernameStr){
        usernameElem().sendKeys(usernameStr);
    }
    private WebElement passwordElem(){
        return driver.findElement(passwordSel);
    }

    @Step("Input password as {passwordStr}")
    public void inputPassword(String passwordStr){
        passwordElem().sendKeys(passwordStr);
    }

    private WebElement loginBtnElem(){
        return driver.findElement(loginBtnSel);
    }

    @Step("Click on Login button")
    public void clickOnLoginBtn(){
        loginBtnElem().click();
    }

    public FooterComponent footerComponent(){
        return this.footerComponent;
    }

}
