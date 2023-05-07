package navigation.menu;

import config.BaseTestConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.fasttrackit.DemoQaHomePage;
import org.fasttrackit.ElementsMenu.DemoQaBookStoreApplicationPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NavigationMenuBookStoreTest extends BaseTestConfig {
    DemoQaHomePage page;
    DemoQaBookStoreApplicationPage bookStorePage = new DemoQaBookStoreApplicationPage();

    @BeforeMethod
    private void bookStoresMenuSetup() {
        page = new DemoQaHomePage();
        page.openDemoQaApp();
        page.clickOnBookSToreList();
    }

    @Test
    @Feature("Categories lists")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Book store menu list is displayed.")
    public void book_store_menu_list_is_displayed() {
        bookStoresMenuSetup();
        assertTrue(page.viewBookStoreList(), "When clicking on book store from navigation menu, book store menu list is displayed.");
    }

    @Test
    @Feature("Register new user")
    @Severity(SeverityLevel.CRITICAL)
    @Description("New user registers on book store page.")
    public void sign_up_on_book_store() {
        bookStoresMenuSetup();
        bookStorePage.clickOnLoginLink();
        bookStorePage.clickOnNewUserButton();
        bookStorePage.fillInFirstNameField("Negrea");
        bookStorePage.fillInLastNameField("Mara");
        bookStorePage.fillInUserNameField("mara.negrea17");
        bookStorePage.fillInPasswordField("Mara.negrea1989");

        String firstName = bookStorePage.getTextFromFirstNameField();
        assertEquals(firstName, "Negrea", "First name was successfully filled in first name field.");

        String lastName = bookStorePage.getTextFromLastNameField();
        assertEquals(lastName, "Mara", "Last name was successfully filled in last name field.");

        String userName = bookStorePage.getTextFromUserNameField();
        assertEquals(userName, "mara.negrea17", "User name was successfully filled in user name field.");

        String password = bookStorePage.getTextFromPasswordField();
        assertEquals(password, "Mara.negrea1989", "Password was successfully filled in password field.");

        bookStorePage.clickOnRegisterButton();
        bookStorePage.clickOnRecaptchaCheckBox();
        sleep(1000);
    }
}
