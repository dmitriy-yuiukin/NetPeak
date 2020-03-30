package ua.netpeak;

import base.BaseTest;
import enums.Button;
import org.testng.annotations.Test;
import page.HirePage;
import page.JobPage;
import page.MainPage;

import static org.testng.Assert.assertEquals;

public class NetPeakTest extends BaseTest {

    @Test
    public void getJobTest() {
        MainPage mainPage = openWebApp();

        JobPage jobPage = mainPage.clickByCareerButtonAndTransferOnJobPage(Button.CAREER, JobPage.class);

        HirePage hirePage = jobPage.clickByIWatnToWorInNetPeakButtonAndTransferOnHirePage(Button.WANT_TO_WORK_IN_NETPEAK, HirePage.class);
        assertEquals("Ошибка: неверный формат файла (разрешённые форматы: doc, docx, pdf, txt, odt, rtf).",
                hirePage.uploadResumeAndGetWrongMessage("Resume.png"),
                "Error isn`t visible or error is wrong");
        hirePage.setNameLastNameAndEmail();
        assertEquals("rgba(255, 0, 0, 1)", hirePage.setDataUserAndClickBySendResumeAndGetErrorMessage(Button.SEND_CV),
                "Text isn`t visible or text isn`t red");

        hirePage.clickByLogoAndTransferOnMainPage(MainPage.class);

        assertEquals("https://netpeak.ua/", mainPage.getUrlPage(), "Url isn`t match");
    }
}
