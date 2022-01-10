package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class StartBrowser implements Urls {

    public static void main(String[] args) throws IllegalAccessException {
        //current project dir
        WebDriver driver = DriverFactory.getChromeDriver();

        //launch target test url
        driver.get(baseUrl);

        //Error may happen here -- DEBUG PURPOSE ONLY

        //Quit
        driver.quit();
    }
}
