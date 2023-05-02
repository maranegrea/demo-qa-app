package org.fasttrackit.ElementsMenu;

import com.codeborne.selenide.SelenideElement;
import org.fasttrackit.Page;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DemoQaBookStoreApplicationPage extends Page {
    private final SelenideElement loginLink = $(byText("Login"));
    private final SelenideElement newUserButton = $("#newUser");
    private final SelenideElement firstNameField = $("#firstname");
    private final SelenideElement lastNameField = $("#lastname");
    private final SelenideElement userNameField = $("#userName");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement recaptchaCheckBox = $("#g-recaptcha");
    private final SelenideElement registerButton = $("#register");

    public void clickOnLoginLink() {
        loginLink.scrollTo();
        loginLink.click();
    }

    public void clickOnNewUserButton() {
        newUserButton.click();
    }

    public void fillInFirstNameField(String firstName) {
        firstNameField.click();
        firstNameField.sendKeys(firstName);
    }

    public void fillInLastNameField(String lastName) {
        lastNameField.click();
        lastNameField.sendKeys(lastName);
    }

    public void fillInUserNameField(String user) {
        userNameField.click();
        userNameField.sendKeys(user);
    }

    public void fillInPasswordField(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickOnRecaptchaCheckBox() {
        recaptchaCheckBox.scrollTo();
        recaptchaCheckBox.click();
    }

    public void clickOnRegisterButton() {
        registerButton.click();
    }

    public String getTextFromFirstNameField() {
        firstNameField.scrollTo();
        return firstNameField.getAttribute("value");
    }

    public String getTextFromLastNameField() {
        return lastNameField.getAttribute("value");
    }

    public String getTextFromUserNameField() {
        return userNameField.getAttribute("value");
    }

    public String getTextFromPasswordField() {
        return passwordField.getAttribute("value");
    }
}
