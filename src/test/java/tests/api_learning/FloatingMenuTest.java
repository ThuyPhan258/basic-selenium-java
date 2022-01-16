package tests.api_learning;

import driver.DriverFactory;
import models.pages.api_learning.FloatingMenuPage;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class FloatingMenuTest implements Urls {
    public static void main(String[] args) throws IllegalAccessException {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(baseUrl.concat(floatingMenu));

        try{
            FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
            floatingMenuPage.scrollToBottom();
            Thread.sleep(2000);
            floatingMenuPage.scrollToTop();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }



}
