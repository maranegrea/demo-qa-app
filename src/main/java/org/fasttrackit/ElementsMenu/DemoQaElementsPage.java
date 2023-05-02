
package org.fasttrackit.ElementsMenu;

import com.codeborne.selenide.SelenideElement;
import org.fasttrackit.Page;

import static com.codeborne.selenide.Selenide.$;

public class DemoQaElementsPage extends Page {

    private final SelenideElement textBoxLink = $("#item-0");
    private final SelenideElement fullName = $("[placeholder='Full Name']");
    private final SelenideElement email = $("[placeholder='name@example.com']");
    private final SelenideElement currentAddress = $("[placeholder='Current Address']");
    private final SelenideElement userName = $("#name");
    private final SelenideElement userEmail = $("#email");
    private final SelenideElement userCurrentAddress = $("[id=currentAddress][class=mb-1]");
    private final SelenideElement submitButton = $("#submit");

    private final SelenideElement checkBoxLink = $("#item-1");
    private final SelenideElement toggleButton = $("[aria-label='Toggle']");
    private final SelenideElement downloadCheckBox = $("[for='tree-node-downloads']");
    private SelenideElement checkBoxMessageResult = $("#result");

    private final SelenideElement radioButtonLink = $("#item-2");
    private final SelenideElement impressiveRadio = $("[for='impressiveRadio']");
    private final SelenideElement successMessageFromImpressiveRadio = $(".text-success");

    private final SelenideElement uploadAndDownloadLink = $("#item-7");
    private final SelenideElement downloadButton = $("#downloadButton");
    private final SelenideElement uploadedFile = $("#uploadedFilePath");


    public void clickOnTextBox() {
        textBoxLink.click();
    }

    public void fillInFullNameField(String name) {
        fullName.click();
        fullName.sendKeys(name);
    }

    public void fillInEmailField(String validEmail) {
        email.click();
        email.sendKeys(validEmail);
    }

    public void fillInCurrentAddressField(String address) {
        currentAddress.click();
        currentAddress.sendKeys(address);
    }

    public void clickOnSubmitButton() {
        submitButton.scrollTo();
        submitButton.click();
    }

    public void clickOnCheckBoxLink() {
        checkBoxLink.click();
    }

    public void clickOnToogleButton() {
        toggleButton.click();
    }

    public void clickOnDownloadCheckBox() {
        downloadCheckBox.click();
    }

    public void clickOnRadioButtonLink() {
        radioButtonLink.click();
    }

    public void selectImpressiveRadio() {
        impressiveRadio.click();
    }

    public void clickOnUploadAndDownloadLink() {
        uploadAndDownloadLink.scrollTo();
        uploadAndDownloadLink.click();
    }

    public void clickOnDownloadFile() {
        downloadButton.click();
    }

    public String getTextFromImpressiveRadioButton() {
        return impressiveRadio.getText();
    }

    public String getTextFromSuccessMessage() {
        successMessageFromImpressiveRadio.scrollTo();
        return successMessageFromImpressiveRadio.getText();
    }

    public String getTextFromUserName() {
        return userName.getText();
    }

    public String getTextFromUserEmail() {
        return userEmail.getText();
    }

    public String getTextFromUserCurrentAddress() {
        return userCurrentAddress.getText();
    }

    public String getTextFromUploadedFile() {
        return uploadedFile.getText();
    }

    public String gettextFromMessageResult() {
        return checkBoxMessageResult.getText();
    }
}
