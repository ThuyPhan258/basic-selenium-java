package models.components.global.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformationColumnComponent extends FooterColComponent{

    public InformationColumnComponent(WebDriver driver){
        super(driver);
    }

    @Override
    protected By componentSel(){
        return By.cssSelector(".information");
    }
}
