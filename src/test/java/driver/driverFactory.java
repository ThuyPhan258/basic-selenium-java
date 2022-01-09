package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class driverFactory {
    public static WebDriver getChromeDriver() throws IllegalAccessException {
        String currentProjectDirLocation = System.getProperty("user.dir");

        //specify Chromedriver Option || Incognito
        String chromeDriverLocation = null;
        if(OS.isFamilyMac())
            chromeDriverLocation = currentProjectDirLocation + "/src/test/resources/driver/chromedriver";
        if(OS.isFamilyWindows())
            chromeDriverLocation = currentProjectDirLocation + "\\src\\test\\resources\\driver\\chromedriver.exe";
        if(chromeDriverLocation == null)
            throw new IllegalAccessException("Can't detect current OS");

        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        //Section initialization
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Deprecated

        return driver;
    }
}
