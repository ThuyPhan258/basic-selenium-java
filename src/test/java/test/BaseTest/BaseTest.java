package test.BaseTest;

import driver.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class BaseTest {
    private final static List<DriverFactory> webdriverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<DriverFactory> driverThread;

    @BeforeSuite(alwaysRun = true)
    public static void beforeSuite(){
        //anonymous function
        driverThread =ThreadLocal.withInitial(() -> {
            DriverFactory webDriverThread = new DriverFactory();
            webdriverThreadPool.add(webDriverThread);
            return webDriverThread;
        });
    }

    @AfterSuite(alwaysRun = true)
    public static void afterSuite(){
        for (DriverFactory driverFactory : webdriverThreadPool) {
            driverFactory.quitDriver();
        }
    }

    public static WebDriver getDriver() throws IllegalAccessException {
        return driverThread.get().getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) throws IllegalAccessException {
        if(result.getStatus() == ITestResult.FAILURE){
            //1. Screenshot name
            String methodName = result.getName();
            Calendar calendar = new GregorianCalendar();
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH) + 1;
            int d = calendar.get(Calendar.DATE);
            int hr = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);
            String dateTaken = y + "-" + m + "-" + d + "-" + hr + "-" + min + "-" + sec;
            String fileLocation = System.getProperty("user.dir") + "/screenshots/" + methodName + "_" + dateTaken + ".png";

            // methodName_2021-12-04-07-10-34.png
            //2. Save
            File screenShot = ((TakesScreenshot) driverThread.get().getDriver()).getScreenshotAs(OutputType.FILE);

           try {
               FileUtils.copyFile(screenShot, new File(fileLocation));
               //3. Add screenshot into Allure Report
               Path filePath = Paths.get(fileLocation);
               try(InputStream is = Files.newInputStream(filePath)){
                   Allure.addAttachment(methodName, is);
               }
            } catch (Exception e) {
               e.printStackTrace();
           }
        }
    }
}
