package api_learning;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;


public class formHandling implements Urls {
    private static final By usernameSel = By.id("username");
    private static final By passwordSel = By.cssSelector("#password");
    private static final By loginBtnSel = By.cssSelector("[type='submit']");

    public static void main(String[] args) throws IllegalAccessException {
        String usernameStr = "tomsmith";
        String passwordStr = "SuperSecretPassword!";
        WebDriver driver = driverFactory.getChromeDriver();

        //Open target URL
        String loginUrl = baseUrl.concat(loginSlug);
        driver.get(loginUrl);

        try {
            login(driver, usernameStr, passwordStr);
            Thread.sleep(2000);
        } catch (Exception ignored){
            System.out.println("failed, exception");
            System.out.println(ignored.toString());
        }
        finally {
            driver.quit();
        }
    }

    private static void login(WebDriver driver, String username, String password) throws InterruptedException {
        //Find username element and password element
        WebElement usernameElem = driver.findElement(usernameSel);
        WebElement passwordElem = driver.findElement(passwordSel);
        WebElement loginBtnElem = driver.findElement(loginBtnSel);

        //API: sendKeys(String str);
        usernameElem.sendKeys(username);
        passwordElem.sendKeys(password);
        loginBtnElem.click();

    }
}
