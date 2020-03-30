package page;

import base.BaseTest;
import constance.Wait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractPage {


    protected BaseTest testClass;

    public AbstractPage(BaseTest testClass) {
        this.testClass = testClass;
        waitForLoad();
        PageFactory.initElements(testClass.getDriver(), this);
    }

    public void waitForLoad() {
        new WebDriverWait(testClass.getDriver(), Wait.TIME_IMPLICIT_WAIT).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    protected <T extends AbstractPage> T createPage(Class<T> clazz) {

            try {
                return clazz.getConstructor(BaseTest.class).newInstance(testClass);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Cannot create object of class: " + clazz.getName());
            }
        }
    }

