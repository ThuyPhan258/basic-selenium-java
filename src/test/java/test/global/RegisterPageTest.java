package test.global;

import models.components.global.header.HeaderComponent;
import models.pages.HomePage;
import models.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.BaseTest.BaseTest;
import test_flows.global.FooterTestFlow;
import test_flows.global.HeaderTestFlow;
import url.Urls;

public class RegisterPageTest extends BaseTest implements Urls {

    @Test
    public void testFooterComponent() throws IllegalAccessException {
        WebDriver driver = getDriver();

        //navigate to test page
        driver.get(BASE_URL.concat(HOME_PAGE));

        //verify footer commponent
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent(RegisterPage.class);
    }

    @Test
    public void testHeaderComponent() throws IllegalAccessException {
        WebDriver driver = getDriver();

        //navigate to test page
        driver.get(BASE_URL.concat(HOME_PAGE));

        //verify header commponent
        new HeaderTestFlow(driver).verifyHeaderComp(new HomePage(driver));
    }
}
