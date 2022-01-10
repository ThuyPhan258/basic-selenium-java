package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import url.Urls;

public class Lesson14_Dropdown implements Urls {
    public static void main(String[] args) throws IllegalAccessException {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            //navigate to dropdown page
            driver.get(baseUrl.concat(dropdown));

            //target dropdown
            Select select = new Select(driver.findElement(By.id("dropdown")));

            select.selectByVisibleText("Option 1");
            Thread.sleep(2000);

            select.selectByIndex(2);
            Thread.sleep(2000);

            select.selectByValue("1");
            Thread.sleep(2000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
