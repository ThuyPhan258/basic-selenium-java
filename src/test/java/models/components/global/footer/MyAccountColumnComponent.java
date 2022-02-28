package models.components.global.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountColumnComponent extends FooterColComponent{

    public MyAccountColumnComponent(WebDriver driver){
        super(driver);
    }

    @Override
    protected By componentSel(){
        return By.cssSelector(".my-account");
    }
}
