package page;

import base.BaseTest;
import enums.Button;
import enums.FindButton;


public class JobPage extends BasePage {


    public JobPage(BaseTest testClass) {
        super(testClass);
    }


    public <T extends AbstractPage> T clickByIWatnToWorInNetPeakButtonAndTransferOnHirePage(Button button, Class<T> createNewPage) {
        String xpathForIWantToWorkInNetpeakButton = "//div[@class='vac-block-border']//a[contains(., '%s')]";
        testClass.waitAndClickByElement(testClass.findElement(FindButton.XPATH, (String.format(xpathForIWantToWorkInNetpeakButton, button.getButon()))));
        return createPage(createNewPage);
    }

}
