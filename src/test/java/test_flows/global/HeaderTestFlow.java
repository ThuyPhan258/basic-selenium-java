package test_flows.global;


import models.components.global.header.HeaderComponent;
import static models.components.global.header.HeaderComponent.SearchBoxComp;
import models.pages.BasePage;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class HeaderTestFlow implements Urls {
    public final WebDriver driver;

    public HeaderTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyHeaderComp(BasePage page) {
        HeaderComponent headerComponent = page.headerComponent();

        //verify Logo component
        System.out.println("Logo Link: " + headerComponent.logoComp().logoLink().getText());
        System.out.println("Logo Img: " + headerComponent.logoComp().logoImg().getAttribute("src"));

        //verify Header Links
        headerComponent.headerLinks().forEach(link -> {
            System.out.println(link.getText() + ":" + link.getAttribute("href"));
        });

        //verify Header Search Box
        SearchBoxComp searchBoxComp = headerComponent.searchBoxComp();
        searchBoxComp.getComponent().getAttribute("action");
        searchBoxComp.getComponent().getAttribute("method");
        System.out.println(searchBoxComp.getComponent().getAttribute("value"));
        searchBoxComp.inputField().sendKeys("Laptop");
        searchBoxComp.submitBtn().click();
        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {}
     }
}



