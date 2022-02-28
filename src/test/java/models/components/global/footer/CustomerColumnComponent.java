package models.components.global.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerColumnComponent extends FooterColComponent{

    public CustomerColumnComponent(WebDriver driver){
        super(driver);
    }

    @Override
    protected By componentSel(){
        return By.cssSelector(".customer-service");
    }
}
