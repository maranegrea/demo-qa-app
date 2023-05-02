package org.fasttrackit.ElementsMenu;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.fasttrackit.Page;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;


public class DemoQaWidgetsPage extends Page {

    private final SelenideElement accordianLink = $(byText("Accordian"));
    private final SelenideElement accordionSection1 = $("#section1Heading");
    private final SelenideElement accordionSection2 = $("#section2Heading");

    private final SelenideElement autoCompleteLink = $(byText("Auto Complete"));
    private final SelenideElement autoCompleteMultipleColoursField = $("#autoCompleteMultipleInput");
    private final SelenideElement autoCompleteSingleColourField = $("#autoCompleteSingleInput");
    private SelenideElement autoCompleteSingleColourFieldHasValue = $(".auto-complete__single-value");
    private final SelenideElement colourContainerArray = $("#autoCompleteMultipleContainer");
    private final SelenideElement deleteColourRedButton = colourContainerArray.find(".css-19bqh2r", 0);
    private final SelenideElement colourRed = colourContainerArray.find(".css-12jo7m5", 0);
    private final SelenideElement colourBlue = colourContainerArray.find(".css-12jo7m5", 1);
    private final SelenideElement colourBlack = colourContainerArray.find(".css-12jo7m5", 2);
    private final SelenideElement colourBlue1 = colourContainerArray.find(".css-12jo7m5", 0);
    private final SelenideElement colourBlack1 = colourContainerArray.find(".css-12jo7m5", 1);

    private SelenideElement datePickerLink = $(byText("Date Picker"));
    private SelenideElement selectDateField = $("#datePickerMonthYearInput");
    private SelenideElement dayPicker = $(".react-datepicker__day--selected");
    private SelenideElement monthPicker = $(".react-datepicker__month-select");
    private SelenideElement yearPicker = $(".react-datepicker__year-select");
    private SelenideElement month;
    private SelenideElement year;
    private SelenideElement selectCustomDay = $(byText("17"));
    private SelenideElement customDate = $("#datePickerMonthYearInput");

    private SelenideElement sliderLink = $(byText("Slider"));
    private SelenideElement slider = $(".range-slider--primary");
    private SelenideElement sliderValue = $("#sliderValue");

    private final SelenideElement progressBarLink = $(byText("Progress Bar"));
    private SelenideElement progressBar = $("div[role='progressbar']");
    private SelenideElement startStopButton = $("#startStopButton");
    private SelenideElement resetButton = $("#resetButton");

    private final SelenideElement toolTipsLink = $(byText("Tool Tips"));
    private SelenideElement toolTipsTextField = $("#toolTipTextField");
    private SelenideElement toolTipsTextFieldMessage = $("[aria-describedby='textFieldToolTip']");

    private SelenideElement selectMenuContainer = $("#selectMenuContainer");
    private final SelenideElement selectMenuLink = $(byText("Select Menu"));
    private final SelenideElement selectOptionDropDown = $("#withOptGroup");
    private final SelenideElement selectWantedOption = $("#react-select-2-option-1-0");
    private SelenideElement optionText = $(".css-1uccc91-singleValue");
    private final SelenideElement selectTitleDropDown = $(".css-1wa3eu0-placeholder");
    private final SelenideElement selectWantedTitle = $("#react-select-3-option-0-2");
    private SelenideElement titleText = $(".css-1uccc91-singleValue", 1);
    private final SelenideElement selectSingleColourDropDown = $("#oldSelectMenu");
    private SelenideElement colourText = $(".css-1uccc91-singleValue", 2);
    private final SelenideElement multiSelectDropdown = selectMenuContainer.$("[class=' css-tlfecz-indicatorContainer']", 2);
    private final SelenideElement colour1 = $("div.css-12jo7m5", 0);
    private final SelenideElement colour2 = $("div.css-12jo7m5", 1);
    private final SelenideElement colour3 = $("div.css-12jo7m5", 2);
    private final SelenideElement colour4 = $("div.css-12jo7m5", 3);
    private SelenideElement colours;


    public void clickOnAccordianLink() {
        accordianLink.scrollTo();
        accordianLink.click();
    }

    public void clickOnAccordionSection1() {
        accordionSection1.click();
    }

    public void clickOnAccordionSection2() {
        accordionSection2.scrollTo();
        accordionSection2.click();
    }

    public void clickOnAutoCompleteLink() {
        autoCompleteLink.scrollTo();
        autoCompleteLink.click();
    }

    public void fillInAutoCompleteMultipleColoursField(String colours) {
        autoCompleteMultipleColoursField.click();
        autoCompleteMultipleColoursField.sendKeys(colours);
        autoCompleteMultipleColoursField.pressEnter();
    }

    public void fillInAutoCompleteSingleColourField(String colour) {
        autoCompleteSingleColourField.click();
        autoCompleteSingleColourField.sendKeys(colour);
        autoCompleteSingleColourField.pressEnter();
    }

    public void clickOnDeleteRedColourButton() {
        deleteColourRedButton.click();
    }

    public void clickOnDataPickerLink() {
        datePickerLink.scrollTo();
        datePickerLink.click();
    }

    public void clickOnSelectDateField() {
        selectDateField.scrollTo();
        selectDateField.click();
    }

    public String selectCustomDayOfMonth() {
        selectCustomDay.scrollTo();
        selectCustomDay.click();
        return null;
    }


    public String selectCustomMonth(String month) {
        monthPicker.click();
        String customMonth = String.format("[value='%s']", month);
        this.month = $(customMonth);
        this.month.click();
        return customMonth;
    }

    public String selectCustomYear(String year) {
        String customYear = String.format("[value='%s']", year);
        this.year = $(customYear);
        this.year.click();
        return customYear;
    }

    public void loadSlider() {
        slider.scrollTo();
        int x = slider.getSize().width;
        int y = slider.getSize().height;
        actions().clickAndHold(slider).moveByOffset(x - 340, 0).release().build().perform();
    }

    public void clickOnProgressBarLink() {
        progressBarLink.scrollTo();
        progressBarLink.click();
    }

    public void loadProgressBarToMaximum() {
        progressBar.shouldHave(Condition.attributeMatching("aria-valuenow", "100"), Duration.ofSeconds(50));
    }

    public void clickOnResetButton() {
        resetButton.click();
    }

    public void clickOnStartStopButtonProgressBar() {
        startStopButton.click();
    }

    public void clickOnSlider() {
        sliderLink.scrollTo();
        sliderLink.click();
    }

    public void clickOnToolTips() {
        toolTipsLink.scrollTo();
        toolTipsLink.click();
    }

    public void hoverOverTextField() {
        toolTipsTextField.hover();
    }

    public void clickOnSelectedMenuLink() {
        selectMenuLink.scrollTo();
        selectMenuLink.click();
    }

    public void selectWantedOption() {
        selectOptionDropDown.scrollTo();
        selectOptionDropDown.click();
        selectWantedOption.scrollTo();
        selectWantedOption.click();
    }

    public void selectWantedTitle() {
        selectTitleDropDown.click();
        selectWantedTitle.click();
    }

    public void selectWantedColour() {
        selectSingleColourDropDown.click();
        selectSingleColourDropDown.selectOptionByValue("4");
        selectSingleColourDropDown.click();
    }

    public String selectMultipleColours(String colours) {
        String multipleColoursOption = String.format("#react-select-4-option-%s", colours);
        this.colours = $(multipleColoursOption);
        this.colours.click();
        return colours;

    }

    public void openMultiSelectDropdown() {
        multiSelectDropdown.scrollTo();
        multiSelectDropdown.click();
    }

    public String getTextFromAutoCompleteSingleColourField() {
        return autoCompleteSingleColourFieldHasValue.getText();
    }

    public String getTextFromColourRed() {
        return colourRed.getText();
    }

    public String getTextFromColourBlue() {
        return colourBlue.getText();
    }

    public String getTextFromColourBlack() {
        return colourBlack.getText();
    }

    public String getTextFromColourBlue1() {
        return colourBlue1.getText();
    }

    public String getTextFromColourBlack1() {
        return colourBlack1.getText();
    }

    public String getTextFromDayPicker() {
        dayPicker.scrollTo();
        return dayPicker.getText();
    }

    public String getTextFromMonthPicker() {
        return monthPicker.getText();
    }

    public String getTextFromYearPicker() {
        return yearPicker.getText();
    }

    public String getTextFromCustomDate() {
        return customDate.getAttribute("value");
    }

    public String getValueFromSlider() {
        return sliderValue.getAttribute("value");
    }

    public String getTextFromProgressBarValue() {
        return progressBar.getText();
    }

    public String getToolTipText() {
        return toolTipsTextFieldMessage.getAttribute("aria-describedby");
    }

    public String getTextFromSelectedWantedOption() {
        return optionText.getText();
    }

    public String getTextFromTitle() {
        return titleText.getText();
    }


    public String getTextFromColour1() {
        return colour1.getText();
    }

    public String getTextFromColour2() {
        return colour2.getText();
    }

    public String getTextFromColour3() {
        return colour3.getText();
    }

    public String getTextFromColour4() {
        return colour4.getText();
    }

    public String getTextFromSingleColourField() {
        return selectSingleColourDropDown.getText();
    }
}
