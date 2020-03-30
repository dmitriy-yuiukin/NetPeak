package page;

import base.BaseTest;
import enums.Button;
import enums.FindButton;


public class MainPage extends BasePage {

    public MainPage(BaseTest testClass) {
        super(testClass);
    }


    public <T extends AbstractPage> T clickByCareerButtonAndTransferOnJobPage(Button button, Class<T> createNewPage) {
        String xpathForNavigateButtons = "//ul[@class='nav navbar-nav justified']//a[contains(., '%s')]";
        testClass.waitAndClickByElement(testClass.findElement(FindButton.XPATH, (String.format(xpathForNavigateButtons, button.getButon()))));
        return createPage(createNewPage);
    }


}
