package models.components.global.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderComponent {
    private WebDriver driver;
    private final By compSel = By.cssSelector(".header");
    private WebElement component;

    private final By headerLinksSel = By.cssSelector(".header-links li a");

    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
        this.component = driver.findElement(compSel);
    }
    public LogoComp logoComp(){
        return new LogoComp(driver);
    }

    public List<WebElement> headerLinks(){
        return this.component.findElements(headerLinksSel);
    }

    public SearchBoxComp searchBoxComp(){
        return new SearchBoxComp(driver);
    }

    public static class LogoComp {
        private WebDriver driver;
        private final By compSel = By.cssSelector(".header-logo");
        private WebElement component;

        private final By logoLinkSel = By.tagName("a");
        private final By logoImgSel = By.cssSelector("a img");

        public LogoComp(WebDriver driver) {
            this.driver = driver;
            this.component = driver.findElement(compSel);
        }

        public WebElement logoLink(){
            return this.component.findElement(logoLinkSel);
        }

        public WebElement logoImg(){
            return this.component.findElement(logoImgSel);
        }
    }

    public static class SearchBoxComp {

        private final By compSel = By.cssSelector(".search-box form");
        private WebElement component;

        private final By inputFieldSel = By.cssSelector(".search-box-text");
        private final By submitBtnSel = By.cssSelector(".search-box-button");

        public SearchBoxComp(WebDriver driver) {
            component = driver.findElement(compSel);
        }

        public WebElement getComponent(){
            return this.component;
        }

        public WebElement inputField(){
            return this.component.findElement(inputFieldSel);
        }
        public WebElement submitBtn(){
            return this.component.findElement(submitBtnSel);
        }
    }
}

