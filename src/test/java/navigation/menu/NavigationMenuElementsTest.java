
package navigation.menu;

import config.BaseTestConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.fasttrackit.DemoQaHomePage;
import org.fasttrackit.ElementsMenu.DemoQaElementsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NavigationMenuElementsTest extends BaseTestConfig {
    DemoQaHomePage page;
    DemoQaElementsPage elementsPage = new DemoQaElementsPage();

    @BeforeMethod
    private void elementsMenuSetup() {
        page = new DemoQaHomePage();
        page.openDemoQaApp();
        page.clickOnElementsList();
    }

    @Test
    @Feature("Categories lists")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Elements menu list is displayed")
    public void elements_menu_list_is_displayed() {
        assertTrue(page.viewElementsList(), "When clicking on elements from navigation menu, elements menu list is displayed.");
    }

    @Test
    @Feature("Text box")
    @Severity(SeverityLevel.CRITICAL)
    @Description("User's details were filled in text box fields.")
    public void select_textBox_and_fill_in_fields_a_message_confirmation_is_displayed() {
        elementsPage.clickOnTextBox();
        elementsPage.fillInFullNameField("Mara Negrea");
        elementsPage.fillInEmailField("mara.negrea17@gmail.com");
        elementsPage.fillInCurrentAddressField("Eugen Ionesco Street, Cluj");
        elementsPage.clickOnSubmitButton();
        String userName = elementsPage.getTextFromUserName();
        assertEquals(userName, "Name:Mara Negrea", "Name was filled in the full name field");
        String userEmail = elementsPage.getTextFromUserEmail();
        assertEquals(userEmail, "Email:mara.negrea17@gmail.com", "Email was filled in the email field");
        String userCurrentAddress = elementsPage.getTextFromUserCurrentAddress();
        assertEquals(userCurrentAddress, "Current Address :Eugen Ionesco Street, Cluj", "Current Address was filled in the current address ");
    }

    @Test
    @Feature("Check box")
    @Severity(SeverityLevel.NORMAL)
    @Description("Click on downloads from check box.")
    public void click_on_downloads_from_check_box_a_success_message_is_displayed() {
        elementsPage.clickOnCheckBoxLink();
        elementsPage.clickOnToogleButton();
        elementsPage.clickOnDownloadCheckBox();
        String message = elementsPage.getTextFromMessageResult();
        assertEquals(message, "You have selected :\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile", "A success message is displayed after clicking on Downloads");
    }

    @Test
    @Feature("Radio button")
    @Severity(SeverityLevel.NORMAL)
    @Description("Select impressive radio button.")
    public void select_impressive_radio_from_radioButton_a_success_message_is_displayed() {
        elementsPage.clickOnRadioButtonLink();
        elementsPage.selectImpressiveRadio();
        sleep(1000);
        String impressiveRadioButtonName = elementsPage.getTextFromImpressiveRadioButton();
        String impressiveRadioSuccessMessage = elementsPage.getTextFromSuccessMessage();
        assertEquals(impressiveRadioButtonName, impressiveRadioSuccessMessage, "A success message is displayed after selecting Impressive Radio");
    }

    @Test
    @Feature("Upload file")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Upload a file.")
    public void upload_a_file_from_download_and_upload() {
        elementsPage.clickOnUploadAndDownloadLink();
        File testFile = $("[id='uploadFile']").uploadFile(new File("src/Files/file.png"));
        String uploadedFile = elementsPage.getTextFromUploadedFile();
        elementsPage.clickOnDownloadFile();
        assertEquals(uploadedFile, "C:\\fakepath\\file.png", "The file was successfully uploaded");
    }
}
