package models.pages;

import models.components.global.footer.FooterComponent;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public FooterComponent footerComp(){
        return new FooterComponent(driver);
    }

}
