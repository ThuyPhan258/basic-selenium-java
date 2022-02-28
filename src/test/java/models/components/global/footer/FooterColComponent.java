package models.components.global.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class FooterColComponent {

    protected WebDriver driver;
    protected WebElement component;
    private static final By columnTitleSel = By.tagName("h3");
    private static final By linkSel = By.tagName("a");

    public FooterColComponent(WebDriver driver) {
        this.driver = driver;
        this.component = driver.findElement(componentSel());
    }

    protected abstract By componentSel();

    public String columnTitle(){
        return this.component.findElement(columnTitleSel).getText();
    }

    public List<WebElement> linkElems(){
        return this.component.findElements(linkSel);
    }

}
