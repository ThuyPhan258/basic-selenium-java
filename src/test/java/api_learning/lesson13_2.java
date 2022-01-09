package api_learning;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

import static url.Urls.baseUrl;
import static url.Urls.dynamicControlSlug;


public class lesson13_2 implements Urls {
    private static By inputFieldSel = By.cssSelector("input");
    private static By btnSel = By.cssSelector("button");

    public static void main(String[] args) throws IllegalAccessException {
        WebDriver driver = driverFactory.getChromeDriver();

        try{
            driver.get(baseUrl.concat(dynamicControlSlug));

            //LinkText selector
            By powerByLinkSel = By.linkText("Elemental Selenium");
            WebElement powerByLinkEle = driver.findElement(powerByLinkSel);

            //checkbox example form
            By checkboxExampleFormSel = By.cssSelector("#checkbox-example");
            WebElement checkboxExampleFormElem= driver.findElement(checkboxExampleFormSel);
            WebElement checkboxOptionElem = checkboxExampleFormElem.findElement(inputFieldSel);
            WebElement removeBtnElem = checkboxExampleFormElem.findElement(btnSel);

            if(!checkboxOptionElem.isSelected())
                checkboxOptionElem.click();
            removeBtnElem.click();
            Thread.sleep(2000);

            //input example form
            By inputExampleFormSel = By.cssSelector("#input-example");
            WebElement inputExampleFormElem = driver.findElement(inputExampleFormSel);
            WebElement inputExampleInputFieldEle = inputExampleFormElem.findElement(inputFieldSel);
            WebElement inputExamplebtnEle = inputExampleFormElem.findElement(btnSel);
//            System.out.println("input Example InputFieldElement: " + inputExampleInputFieldEle.isEnabled());
//            System.out.println("input example button: " + inputExamplebtnEle.getText());
            if(!inputExampleInputFieldEle.isEnabled())
                inputExampleInputFieldEle.click();
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
