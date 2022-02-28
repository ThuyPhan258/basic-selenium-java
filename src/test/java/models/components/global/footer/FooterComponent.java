package models.components.global.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterComponent {
    private WebDriver driver;
    private By componentSel = By.cssSelector(".footer");
    private WebElement component;

    public FooterComponent(WebDriver driver) {
        this.driver = driver;
        this.component = driver.findElement(componentSel);
    }

    public FooterColComponent informationColumn(){
        return new InformationColumnComponent(driver);
    }

    public FooterColComponent csColumn(){
        return new CustomerColumnComponent(driver);
    }
}
