package page;

import base.BaseTest;
import enums.Button;
import enums.DataUser;
import enums.FindButton;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HirePage extends BasePage{

    public HirePage(BaseTest testClass) {
        super(testClass);
    }

    @FindBy(xpath = "//input[@type='file']")
    private WebElement uploadFile;

    @FindBy(css = "#inputName")
    private WebElement name;

    @FindBy(css = "#inputLastname")
    private WebElement lastName;

    @FindBy(css = "#inputEmail")
    private WebElement email;

    @FindBy(xpath = "//div[@class='form-group birthday-form']/select[@name='bd']")
    private WebElement birthDay;

    @FindBy(xpath = "//div[@class='form-group birthday-form']/select[@name='bm']")
    private WebElement birthMonth;

    @FindBy(xpath = "//div[@class='form-group birthday-form']/select[@name='by']")
    private WebElement birthYear;

    @FindBy(css = "#inputPhone")
    private WebElement phoneNumber;


    public String uploadResumeAndGetWrongMessage(String file) {
        uploadFile.sendKeys(System.getProperty("user.dir") + "/src/main/resources/" + file);
        return testClass.waitTillElementIsVisible(testClass.findElement(FindButton.XPATH, "//div[@id='up_file_name']/label[contains(.,'Ошибка: неверный формат файла')]")).getText();
    }

    public void setNameLastNameAndEmail() {
        name.sendKeys(DataUser.NAME.getValue());
        lastName.sendKeys(DataUser.LAST_NAME.getValue());
        email.sendKeys(DataUser.EMAIL.getValue());
    }

    public String setDataUserAndClickBySendResumeAndGetErrorMessage(Button button) {
        String xpathForClickBySendResume = "//div[@class='agree-btn container careere-info-block']//button[contains(., '" + button.getButon() + "')]";
        birthDay.sendKeys(DataUser.BIRTH_DAY.getValue());
        birthMonth.sendKeys(DataUser.BIRTH_MONTH.getValue());
        birthYear.sendKeys(DataUser.BIRTH_YEAR.getValue());
        phoneNumber.sendKeys(DataUser.PHONE_NUMBER.getValue());
        testClass.waitAndClickByElement(testClass.findElement(FindButton.XPATH, xpathForClickBySendResume));
        return testClass.waitTillElementIsVisible(testClass.findElement(FindButton.XPATH, ("//div[@class='form-group has-error']/p"))).getCssValue("color");
    }






}
