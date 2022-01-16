package models.pages;

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
    public void scrollToTop(){
        Scrollhandler.scrollToTop(javascriptExecutor);
    }
    public void scrollToBottom(){
        Scrollhandler.scrollToBottom(javascriptExecutor);
    }
}
