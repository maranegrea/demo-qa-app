package navigation.menu;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.BaseTestConfig;
import data.provider.CalendarDate;
import data.provider.CalendarDateDateProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.fasttrackit.DemoQaHomePage;
import org.fasttrackit.ElementsMenu.DemoQaWidgetsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NavigationMenuWidgetsTest extends BaseTestConfig {
    DemoQaHomePage page;
    DemoQaWidgetsPage widgetsPage = new DemoQaWidgetsPage();

    @BeforeMethod
    public void widgetsMenuSetup() {
        page = new DemoQaHomePage();
        page.openDemoQaApp();
        page.clickOnWidgetsList();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Widgets menu list is displayed")
    public void widgets_menu_list_is_displayed() {
        assertTrue(page.viewWidgetsList(), "When clicking on widgets from navigation menu, widgets menu list is displayed.");

    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Collapse heading.")
    public void select_accordion_and_collapse_section1_heading() {
        widgetsPage.clickOnAccordianLink();
        widgetsPage.clickOnAccordionSection1();
        sleep(1000);
        SelenideElement section1Content = $("#section1Content");
        assertTrue(section1Content.is(Condition.hidden), "Section 1 heading is collapsed");
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Expand heading.")
    public void select_accordion_and_expand_section2_heading() {
        widgetsPage.clickOnAccordianLink();
        widgetsPage.clickOnAccordionSection2();
        sleep(1000);
        SelenideElement section2Content = $("#section2Content");
        section2Content.shouldBe(Condition.visible);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Add multiple colours in autocomplete container.")
    public void type_red_blue_black_in_autocomplete_container_multiple_colours() {
        widgetsPage.clickOnAutoCompleteLink();
        widgetsPage.fillInAutoCompleteMultipleColoursField("Red");
        widgetsPage.fillInAutoCompleteMultipleColoursField("Blue");
        widgetsPage.fillInAutoCompleteMultipleColoursField("Black");
        String red = widgetsPage.getTextFromColourRed();
        String blue = widgetsPage.getTextFromColourBlue();
        String black = widgetsPage.getTextFromColourBlack();
        assertEquals(red + " " + blue + " " + black, "Red Blue Black", "Colours red, blue and black are successfully added in autocomplete container.");
    }

    @Test(dependsOnMethods = "type_red_blue_black_in_autocomplete_container_multiple_colours")
    @Severity(SeverityLevel.NORMAL)
    @Description("Add multiple colours in autocomplete container and delete one of them.")
    public void type_red_blue_black_in_autocomplete_container_and_delete_red() {
        widgetsPage.clickOnAutoCompleteLink();
        widgetsPage.fillInAutoCompleteMultipleColoursField("Red");
        widgetsPage.fillInAutoCompleteMultipleColoursField("Blue");
        widgetsPage.fillInAutoCompleteMultipleColoursField("Black");
        widgetsPage.clickOnDeleteRedColourButton();
        String blue1 = widgetsPage.getTextFromColourBlue1();
        String black1 = widgetsPage.getTextFromColourBlack1();
        assertEquals(blue1 + " " + black1, "Blue Black", "Colour red is successfully removed from the autocomplete container.");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Add one colour in autocomplete container.")
    public void type_single_colour_white_in_autocomplete_container() {
        widgetsPage.clickOnAutoCompleteLink();
        widgetsPage.fillInAutoCompleteSingleColourField("White");
        String singleColour = widgetsPage.getTextFromAutoCompleteSingleColourField();
        assertEquals(singleColour, "White", "Colour white was added in autocomplete container.");
    }

    @Test(dataProviderClass = CalendarDateDateProvider.class, dataProvider = "validPredefinedDate")
    @Severity(SeverityLevel.NORMAL)
    @Description("Choose a predefined date from data picker.")
    public void choose_a_predefined_date_in_data_picker(CalendarDate calendarDate) {
        widgetsPage.clickOnDataPickerLink();
        widgetsPage.clickOnSelectDateField();
        widgetsPage.selectCustomMonth(calendarDate.getMonth());
        widgetsPage.selectCustomYear(calendarDate.getYear());
        widgetsPage.selectCustomDayOfMonth();
        String predefinedDate = widgetsPage.getTextFromCustomDate();
        System.out.println(predefinedDate);

        assertEquals(predefinedDate, calendarDate.getExpectedResults(), "Predefined date is successfully chosen from data picker.");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Check the current date from data picker.")
    public void current_date_is_correctly_displayed_in_data_picker() {
        widgetsPage.clickOnDataPickerLink();
        widgetsPage.clickOnSelectDateField();
        String dayPicker = widgetsPage.getTextFromDayPicker();
        String monthPicker = widgetsPage.getTextFromMonthPicker();
        String yearPicker = widgetsPage.getTextFromYearPicker();
        String month = String.format(monthPicker);
        LocalDate currentDate = LocalDate.now();
        int day = currentDate.getDayOfMonth();
        int year = currentDate.getYear();
        System.out.println("Actual: " + yearPicker + "-" + monthPicker + "-" + dayPicker);
        System.out.println("Expected: " + year + "-" + month + "-" + day);
        assertEquals(yearPicker + "-" + monthPicker + "-" + dayPicker, year + "-" + month + "-" + day, "Current date is correctly displayed in data picker");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Load slider.")
    public void load_slider_to_79() {
        widgetsPage.clickOnSlider();
        widgetsPage.loadSlider();
        String sliderValue = widgetsPage.getValueFromSlider();
        assertEquals(sliderValue, "79", "Slider was successfully loaded to 79");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Load progress bar and reset.")
    public void load_progress_bar_to_maximum_and_reset() {
        widgetsPage.clickOnProgressBarLink();
        widgetsPage.clickOnStartStopButtonProgressBar();
        widgetsPage.loadProgressBarToMaximum();
        widgetsPage.clickOnResetButton();
        String ariaValueNow = widgetsPage.getTextFromProgressBarValue();
        assertEquals(ariaValueNow, "0%", "Progress bar has been reset after it has been loaded to maximum.");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Hover over a text field.")
    public void hover_over_empty_text_field_from_tool_tips() {
        widgetsPage.clickOnToolTips();
       widgetsPage.hoverOverTextField();
        sleep(1000);
        String toolTipTextFieldMessage = widgetsPage.getToolTipText();
        assertEquals(toolTipTextFieldMessage, "textFieldToolTip", "Hover action was done successfully");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Choose desired options from dropdown containers.")
    public void click_on_select_menu_and_choose_from_available_options() {
        widgetsPage.clickOnSelectedMenuLink();
        widgetsPage.selectWantedOption();
        String option = widgetsPage.getTextFromSelectedWantedOption();
        System.out.println(option);
        assertEquals(option, "Group 2, option 1", "Wanted option was successfully chosen.");

        widgetsPage.selectWantedTitle();
        String title = widgetsPage.getTextFromTitle();
        System.out.println(title);
        assertEquals(title, "Mrs.", "Wanted title was successfully chosen.");

        widgetsPage.selectWantedColour();
        String colour = widgetsPage.getTextFromSingleColourField();
        System.out.println(colour);
        assertEquals(colour, "Purple", "Colour purple was successfully chosen.");

        widgetsPage.openMultiSelectDropdown();
        widgetsPage.selectMultipleColours("1");
        widgetsPage.selectMultipleColours("3");
        widgetsPage.selectMultipleColours("0");
        widgetsPage.selectMultipleColours("2");
        String c1 = widgetsPage.getTextFromColour1();
        String c2 = widgetsPage.getTextFromColour2();
        String c3 = widgetsPage.getTextFromColour3();
        String c4 = widgetsPage.getTextFromColour4();
        System.out.println(c1 + " " + c2 + " " + " " + c3 + " " + c4);
        assertEquals(c1 + " " + c2 + " " + c3 + " " + c4, "Blue Red Green Black","Multiple colours were successfully chosen.");

    }
}
