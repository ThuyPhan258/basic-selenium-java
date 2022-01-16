package models.pages;

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
    public void inputUsername(String usernameStr){
        usernameElem().sendKeys(usernameStr);
    }
    private WebElement passwordElem(){
        return driver.findElement(passwordSel);
    }
    public void inputPassword(String passwordStr){
        passwordElem().sendKeys(passwordStr);
    }
    private WebElement loginBtnElem(){
        return driver.findElement(loginBtnSel);
    }
    public void clickOnLoginBtn(){
        loginBtnElem().click();
    }

    public FooterComponent footerComponent(){
        return this.footerComponent;
    }

}
