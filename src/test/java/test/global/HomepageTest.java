package test.global;

import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.BaseTest.BaseTest;
import test_flows.global.FooterTestFlow;
import url.Urls;

public class HomepageTest extends BaseTest implements Urls {

    @Test
    public void testFooterComponent() throws IllegalAccessException {
        WebDriver driver = getDriver();

        //navigate to test page
        driver.get(BASE_URL.concat(HOME_PAGE));

        //verify footer commponent
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent(HomePage.class);
    }
}
