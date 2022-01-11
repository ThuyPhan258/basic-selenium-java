package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class Lesson14_IFrame implements Urls {
    public static void main(String[] args) throws IllegalAccessException {
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            //Navigate to Hovers page
            driver.get(baseUrl.concat(iFrame));

            //switch to iFrame
            driver.switchTo().frame(driver.findElement(By.cssSelector("[id$= 'ifr']")));

            //clear default text then input the new ones
            WebElement editorInputElem = driver.findElement(By.id("tinymce"));
            editorInputElem.clear();
            editorInputElem.sendKeys("Testing iFrame input");

            Thread.sleep(2000);

            //switch back to default frame
            driver.switchTo().defaultContent();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
        }
}
