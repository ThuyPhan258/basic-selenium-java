package models.pages;

import models.components.global.footer.FooterColComponent;
import models.components.global.footer.FooterComponent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.page.Scrollhandler;

public class BasePage {
    private WebDriver driver;
    protected JavascriptExecutor javascriptExecutor;

    public BasePage(WebDriver driver){
        this.driver = driver;
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public FooterComponent footerComponent(){
        return new FooterComponent(driver);
    }

    public void scrollToTop(){
        Scrollhandler.scrollToTop(javascriptExecutor);
    }
    public void scrollToBottom(){
        Scrollhandler.scrollToBottom(javascriptExecutor);
    }
}
