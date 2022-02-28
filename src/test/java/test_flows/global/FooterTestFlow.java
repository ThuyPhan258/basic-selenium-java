package test_flows.global;

import models.components.global.footer.FooterColComponent;
import models.components.global.footer.FooterComponent;
import models.pages.BasePage;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static url.Urls.BASE_URL;

public class FooterTestFlow {
    private WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent(Class <? extends BasePage> page){
        BasePage pageTest = null;
        try {
            pageTest = page.getConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e){
            e.printStackTrace();
        }
        if(pageTest != null){
            FooterComponent footerComponent = pageTest.footerComponent();
            System.out.println(footerComponent.informationColumn().columnTitle());
            for (WebElement link : footerComponent.informationColumn().linkElems()) {
                System.out.println(link.getText());
                System.out.println(link.getAttribute("href"));
            }
        }
    }

    public void verifyInformation(FooterComponent footerComponent){
        FooterColComponent informationColumn = footerComponent.informationColumn();
        System.out.println(informationColumn.columnTitle());
        Assert.assertEquals(informationColumn.columnTitle(), "INFORMATION", "[ERR] Information column incorrect!");
        List<String> expectedLinkTexts = Arrays.asList("Sitemap", "Shipping & Returns", "Privacy Notice", "Conditions of Use",
                                                        "About us", "Contact us");
        List<String> expectedLinkHrefs = Arrays.asList(
                    BASE_URL.concat("/sitemap"),
                    BASE_URL.concat("/shipping-returns"),
                    BASE_URL.concat("/privacy-policy"),
                    BASE_URL.concat("/conditions-of-use"),
                    BASE_URL.concat("/about-us"),
                    BASE_URL.concat("/contactus")
        );
        verifyColumnData(informationColumn, expectedLinkTexts, expectedLinkHrefs);
    }
    private void verifyCustomerColumn(FooterComponent footerComponent){
        FooterColComponent customerColumnComp = footerComponent.csColumn();
    }

    private void verifyColumnData(FooterColComponent footerColumnComponent, List<String> expectedLinkTexts, List<String> expectedLinkHrefs) {
        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualLinkHrefs = new ArrayList<>();

        for (WebElement link : footerColumnComponent.linkElems()) {
            actualLinkTexts.add(link.getText());
            actualLinkHrefs.add(link.getAttribute("href"));
        }

        if(actualLinkTexts.isEmpty() || actualLinkHrefs.isEmpty())
            Assert.fail("[ERR] Texts of link Hrefs in Information column is Empty!");

        //Verify Link Text
        Assert.assertTrue(expectedLinkTexts.size() == actualLinkTexts.size(), "[ERR] information column texts is mismatched!");
        for(String expectedLinkText: expectedLinkTexts){
            Assert.assertTrue(actualLinkTexts.contains(expectedLinkText));
        }

        //Verify Link Href
        Assert.assertTrue(expectedLinkHrefs.size() == actualLinkHrefs.size(), "[ERR] information column hrefs is mismatched!");
        for(String expectedLinkHref: expectedLinkHrefs){
            Assert.assertTrue(actualLinkHrefs.contains(expectedLinkHref));
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        FooterTestFlow footerTestFlow = new FooterTestFlow(null);
        footerTestFlow.verifyFooterComponent(HomePage.class);
    }
}
