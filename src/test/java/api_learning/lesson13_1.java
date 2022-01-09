package api_learning;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

import static url.Urls.baseUrl;
import static url.Urls.dynamicControlSlug;


public class lesson13_1 {
    public static void main(String[] args) throws IllegalAccessException {
        WebDriver driver = driverFactory.getChromeDriver();

        try{
            driver.get(baseUrl.concat(dynamicControlSlug));

            //wait strategies
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            By btnSel = By.cssSelector("button");

            List<WebElement> btnElem = driver.findElements(btnSel);

            System.out.println("Size: " + btnElem.size());
            final int CHECKBOX_EXAMPLE_BTN_INDEX = 0;
            final int INPUT_EXAMPLE_BTN_INDEX = 1;

            WebElement checkboxExampleBtnEle = btnElem.get(CHECKBOX_EXAMPLE_BTN_INDEX);
            WebElement inputExampleBtnEle = btnElem.get(INPUT_EXAMPLE_BTN_INDEX);

            checkboxExampleBtnEle.click();
            inputExampleBtnEle.click();

            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
