package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends AbstractPage {

    public BasePage(BaseTest testClass) {
        super(testClass);
    }

    @FindBy(css = ".logo-block > a")
    private WebElement logo;

    public <T extends AbstractPage> T clickByLogoAndTransferOnMainPage(Class<T> createNewPage) {
        testClass.waitAndClickByElement(logo);
        return createPage(createNewPage);
    }

    public String getUrlPage() {
        return testClass.getDriver().getCurrentUrl();
    }





}
