package models.pages;

import models.components.global.footer.FooterComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
    private static WebDriver driver;
    @FindBy(id ="username")
    private WebElement usernameElem;

    @FindBy(css ="password")
    private WebElement passwordElem;

    @FindBy(css = "button[type='submit']")
    private WebElement loginBtnElem;

    private final FooterComponent footerComponent;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        footerComponent = new FooterComponent(driver);
    }
    private WebElement usernameElem(){
        return usernameElem;
    }
    public void inputUsername(String usernameStr){
        usernameElem().sendKeys(usernameStr);
    }
    private WebElement passwordElem(){
        return passwordElem;
    }
    public void inputPassword(String passwordStr){
        passwordElem().sendKeys(passwordStr);
    }

    public LoginPageFactory clickOnLoginBtn(){
        loginBtnElem.click();
        return this;
    }

    public FooterComponent footerComponent(){
        return this.footerComponent;
    }

}
