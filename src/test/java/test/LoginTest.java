package test;

import driver.DriverFactory;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import jdk.jfr.Description;
import models.components.global.FooterComponent;
import models.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.BaseTest.BaseTest;
import test_flows.authentication.LoginFlow;
import url.Urls;
import utils.page.data.DataObjectBuilder;


public class LoginTest extends BaseTest implements Urls {

    @Description("Test Login Function with Data Driven | Multiple Data set")
    @Test(dataProvider = "wrongCredData", description = "Login Test Incorrect Creds")
    @TmsLinks({@TmsLink("TC_001"),@TmsLink("TC_002")})
    @Issue("Bug_001")
    public void loginWithIncorrectCreds(CredsData credsData) throws IllegalAccessException {
        WebDriver driver = getDriver();
        //open target URL
        String loginUrl = baseUrl.concat(loginSlug);
        driver.get(loginUrl);

        LoginFlow loginFlow = new LoginFlow(driver);
        loginFlow.login(credsData);
        loginFlow.verifyLoginWithInCorrectCreds();

    }

    @Description("Test Login Function with Data Driven | Multiple Data set")
    @Test(description = "Login Test Correct Creds")
    @TmsLinks({@TmsLink("TC_001"),@TmsLink("TC_002")})
    public void loginWithcorrectCreds() throws IllegalAccessException {
        String jsonDataFileLocation = "/src/test/resources/test_data_authentication/ValidCreds.json";
        CredsData credsData = DataObjectBuilder.buildCredObject(jsonDataFileLocation)[0];

        WebDriver driver = getDriver();
        //open target URL
        String loginUrl = baseUrl.concat(loginSlug);
        driver.get(loginUrl);

        LoginFlow loginFlow = new LoginFlow(driver);
        loginFlow.login(credsData);
        loginFlow.verifyLoginWithCorrectCreds();

    }

    @DataProvider
    public CredsData[] wrongCredData(){
        String jsonDataFileLocation = "/src/test/resources/test_data_authentication/InvalidCreds.json";
        return DataObjectBuilder.buildCredObject(jsonDataFileLocation);
    }

    @DataProvider
    public Object[][] wrongCredDatabk(){
        return new Object[][] {
                {"Cedric", "password_1"},
                {"Anne", "password_2"},
        };
    }
}
