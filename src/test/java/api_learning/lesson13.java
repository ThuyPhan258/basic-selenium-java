package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static url.Urls.baseUrl;
import static url.Urls.dynamicControlSlug;


public class lesson13 {
    public static void main(String[] args) throws IllegalAccessException {
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            driver.get(baseUrl.concat(dynamicControlSlug));

            //LinkText selector
            By powerByLinkSel = By.linkText("Elemental Selenium");
            WebElement powerByLinkEle = driver.findElement(powerByLinkSel);

            System.out.println("Link Text: " + powerByLinkEle.getText());
            System.out.println("Power By Href: " + powerByLinkEle.getAttribute("href"));
            System.out.println("LinkText target: " + powerByLinkEle.getAttribute("target"));

            //Get current URL and Page Title
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Current title: " + driver.getTitle());

            //Wait strategies

            //click on remove btn
            By btnSel = By.cssSelector("#checkbox-example button");
            driver.findElement(btnSel).click();

            //click on Add btn
            driver.findElement(btnSel).click();

            //wait a little
            Thread.sleep(3000);

            //wait a little | wait until progress bar is Not displayed
            WebElement progressbar = driver.findElement(By.cssSelector("#loading"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.invisibilityOf(progressbar));
           
            System.out.println("progressBar: " + progressbar.isDisplayed());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
