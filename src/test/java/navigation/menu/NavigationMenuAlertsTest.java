package navigation.menu;

import config.BaseTestConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.fasttrackit.DemoQaHomePage;
import org.fasttrackit.ElementsMenu.DemoQaAlertsPage;
import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NavigationMenuAlertsTest extends BaseTestConfig {
    DemoQaHomePage page;
    DemoQaAlertsPage alertsPage = new DemoQaAlertsPage();

    @BeforeMethod
    private void alertsMenuSetup() {
        page = new DemoQaHomePage();
        page.openDemoQaApp();
        page.clickOnAlertsList();
    }

    @Test
    @Feature("Categories lists")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Alerts menu list is displayed")
    public void alerts_menu_list_is_displayed() {
        assertTrue(page.viewAlertsList(), "When clicking on widgets from navigation menu, widgets menu list is displayed.");
    }

    @Test
    @Feature("Browser windows")
    @Severity(SeverityLevel.NORMAL)
    @Description("A new tab is opened.")
    public void open_new_tab_from_browser_windows() {
        alertsPage.clickOnBrowserWindowsLink();
        alertsPage.openNewTab();
        switchTo().window(1).get("https://demoqa.com/sample");
        String samplePage = alertsPage.verifySamplePageTitle();
        assertEquals(samplePage, "This is a sample page", "When clicking on 'New Tab' button, a new tab is opened");
    }

    @Test
    @Feature("Alerts")
    @Severity(SeverityLevel.NORMAL)
    @Description("Simple alert is opened.")
    public void open_simple_alert_from_alerts_a_small_message_box_is_opened() {
        alertsPage.clickOnAlertsLink();
        alertsPage.clickOnSimpleAlertsButton();
        switchTo().alert().accept();
    }

    @Test
    @Feature("Alerts")
    @Severity(SeverityLevel.NORMAL)
    @Description("Confirmation alert is opened.")
    public void open_alert_box_a_confirmation_alert_is_opened() {
        alertsPage.clickOnAlertsLink();
        alertsPage.clickOnAlertBoxButton();
        switchTo().alert().dismiss();
        String confirmationMessage = alertsPage.getTextFromConfirmationMessage();
        assertEquals(confirmationMessage, "You selected Cancel", "Cancel button was clicked in the confirmation box alert.");
    }

    @Test
    @Feature("Alerts")
    @Severity(SeverityLevel.NORMAL)
    @Description("Prompt alert is opened.")
    public void open_prompt_box_alert_and_fill_in_alert_text_box() {
        alertsPage.clickOnAlertsLink();
        alertsPage.clickOnPromptBoxAlertButton();
        switchTo().alert().sendKeys("Mara Negrea");
        sleep(1000);
        Alert alert = new Alert() {
            @Override
            public void dismiss() {

            }

            @Override
            public void accept() {

            }

            @Override
            public String getText() {
                return null;
            }

            @Override
            public void sendKeys(String keysToSend) {

            }
        };
        alert.accept();
        String promptMessage = alertsPage.getTextFromPromptMessage();
        assertEquals(promptMessage, "You entered Mara Negrea", "Name was successfully filled in prompt alert box.");
    }

    @Test
    @Feature("Modals")
    @Severity(SeverityLevel.NORMAL)
    @Description("Small modal is opened.")
    public void open_small_modal_a_new_modal_dialogue_is_opened() {
        alertsPage.clickOnModalDialogsLink();
        alertsPage.clickOnSmallModal();
        String smallModalWindow = alertsPage.getTextFromSmallModalWindow();
        switchTo().activeElement();
        alertsPage.closeSmallModal();
        assertEquals(smallModalWindow, "Small Modal", "Small Modal is opened from modal dialogue.");
    }

    @Test
    @Feature("Modals")
    @Severity(SeverityLevel.NORMAL)
    @Description("Large modal is opened.")
    public void open_large_modal_a_new_modal_dialogue_is_opened() {
        alertsPage.clickOnModalDialogsLink();
        alertsPage.clickOnLargeModal();
        String largeModalWindow = alertsPage.getTextFromLargeModalWindow();
        switchTo().activeElement();
        alertsPage.closeLargeModal();
        assertEquals(largeModalWindow, "Large Modal", "Large Modal is opened from modal dialogue.");
    }
}
