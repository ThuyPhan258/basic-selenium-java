package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.BrowserType;

import java.time.Duration;

import static org.openqa.selenium.remote.BrowserType.*;

public class DriverFactory {
    private WebDriver driver;

    public WebDriver getDriver() throws IllegalAccessException {
        if (driver == null)
            driver = createWebDriver();
        return driver;
    }

    private WebDriver createWebDriver() throws IllegalAccessException {
        WebDriver driver;
        String browserName = System.getProperty("browser");
        if (browserName == null)
            browserName = System.getenv("browser");
        if (browserName == null) {
            throw new IllegalArgumentException("[ERR] Please supply 'browser' type value!");
        } else {
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = getChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = getFirefoxDriver();
            } else {
                throw new IllegalArgumentException("[ERR]" + browserName + "is not supported!");
            }
            return driver;
        }
    }

    public static WebDriver getFirefoxDriver() {
        //Current project dir
        String currentProjectDirLocation = System.getProperty("user.dir");

        //Specify ChromeDriver Option!Incognito
        String driverLocation = null;
        if(OS.isFamilyMac())
                driverLocation = currentProjectDirLocation + "/src/test/resources/driver/geckodriver";

        if(OS.isFamilyWindows())
                driverLocation = currentProjectDirLocation + "\\src\\test\\resources\\driver\\geckodriver.exe";
        if(driverLocation == null)
            throw new IllegalArgumentException("Can't detect current OS");
        System.setProperty("webdriver.gecko.driver", driverLocation);

        //session initialization
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    public static WebDriver getChromeDriver() throws IllegalAccessException {
        String currentProjectDirLocation = System.getProperty("user.dir");

        //specify Chromedriver Option || Incognito
        String chromeDriverLocation = null;
        if (OS.isFamilyMac())
            chromeDriverLocation = currentProjectDirLocation + "/src/test/resources/driver/chromedriver";
        if (OS.isFamilyWindows())
            chromeDriverLocation = currentProjectDirLocation + "\\src\\test\\resources\\driver\\chromedriver.exe";
        if (chromeDriverLocation == null)
            throw new IllegalAccessException("Can't detect current OS");
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        //Section initialization
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Deprecated
        return driver;
    }
    
    public void quitDriver() {
        if (driver != null)
            driver.quit();
        driver = null;
    }

    public void closeDriver() {
        if (driver != null)
            driver.close();
        driver = null;
    }

}

