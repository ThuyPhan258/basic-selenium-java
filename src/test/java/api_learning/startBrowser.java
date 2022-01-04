package api_learning;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;

public class startBrowser implements Urls {

    public static void main(String[] args) throws IllegalAccessException {
        //current project dir
        WebDriver driver = driverFactory.getChromeDriver();

        //launch target test url
        driver.get(baseUrl);

        //Error may happen here -- DEBUG PURPOSE ONLY

        //Quit
        driver.quit();
    }
}
