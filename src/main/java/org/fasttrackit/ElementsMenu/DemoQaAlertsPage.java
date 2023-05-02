package org.fasttrackit.ElementsMenu;

import com.codeborne.selenide.SelenideElement;
import org.fasttrackit.Page;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class DemoQaAlertsPage extends Page {

    private final SelenideElement browserWindowsLink = $(byText("Browser Windows"));
    private final SelenideElement newTabWindowButton = $("#tabButton");
    private final SelenideElement samplePageTitle = $("#sampleHeading");

    private final SelenideElement alertsLink = $(byText("Alerts"));
    private final SelenideElement simpleAlertsButton = $("#alertButton");
    private final SelenideElement alertsBoxButton = $("#confirmButton");
    private SelenideElement promptBoxAlertButton = $("#promtButton");
    private SelenideElement confirmMessage = $("#confirmResult");
    private SelenideElement promptMessage = $("#promptResult");

    private final SelenideElement modalDialogsLink = $(byText("Modal Dialogs"));
    private final SelenideElement smallModal = $("#showSmallModal");
    private final SelenideElement smallModalWindow = $("#example-modal-sizes-title-sm");
    private final SelenideElement smallModalCloseButton = $("#closeSmallModal");
    private final SelenideElement largeModal = $("#showLargeModal");
    private final SelenideElement largeModalWindow = $("#example-modal-sizes-title-lg");
    private final SelenideElement largeModalCloseButton = $("#closeLargeModal");

    public void clickOnBrowserWindowsLink() {
        browserWindowsLink.scrollTo();
        browserWindowsLink.click();
    }

    public void openNewTab() {
        newTabWindowButton.click();
    }

    public String verifySamplePageTitle() {
        return samplePageTitle.text();
    }

    public void clickOnAlertsLink() {
        alertsLink.scrollTo();
        alertsLink.click();
    }

    public void clickOnSimpleAlertsButton() {
        simpleAlertsButton.scrollTo();
        simpleAlertsButton.click();
    }

    public void clickOnAlertBoxButton() {
        alertsBoxButton.scrollTo();
        alertsBoxButton.click();
    }

    public void clickOnPromptBoxAlertButton() {
        promptBoxAlertButton.scrollIntoView(true);
        promptBoxAlertButton.click();
    }

    public void clickOnModalDialogsLink() {
        modalDialogsLink.scrollTo();
        modalDialogsLink.click();
    }

    public void clickOnSmallModal() {
        smallModal.click();
    }

    public void closeSmallModal() {
        smallModalCloseButton.click();
    }

    public void clickOnLargeModal() {
        largeModal.click();
    }

    public void closeLargeModal() {
        largeModalCloseButton.click();
    }

    public String getTextFromConfirmationMessage() {
        return confirmMessage.getText();
    }

    public String getTextFromPromptMessage() {
        return promptMessage.getText();
    }

    public String getTextFromSmallModalWindow() {
        return smallModalWindow.getText();
    }

    public String getTextFromLargeModalWindow() {
        sleep(1000);
        return largeModalWindow.getText();
    }
}
