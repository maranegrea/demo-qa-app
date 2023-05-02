package navigation.menu;

import config.BaseTestConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.fasttrackit.DemoQaHomePage;
import org.fasttrackit.ElementsMenu.DemoQaInteractionsPage;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class NavigationMenuInteractionsTest extends BaseTestConfig {
    DemoQaHomePage page;
    DemoQaInteractionsPage interactionsPage = new DemoQaInteractionsPage();

    @BeforeMethod
    private void interactionsMenuSetup() {
        page = new DemoQaHomePage();
        page.openDemoQaApp();
        page.clickOnInteractionsList();
    }

    @Test
    @Description("Interactions menu list is displayed.")
    @Severity(SeverityLevel.CRITICAL)
    public void interactions_menu_list_is_displayed() {
        interactionsMenuSetup();
        Assert.assertTrue(page.viewInteractionsList(), "When clicking on interactions from navigation menu, interaction menu list is displayed.");

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Drag and drop small box into the bigger one.")
    public void drag_and_drop_small_box_into_the_big_box() {
        interactionsMenuSetup();
        interactionsPage.clickOnDroppableLink();
        interactionsPage.clickAndHoldDraggableElement();
        String dropMessage = interactionsPage.getTextFromDroppableElement();
        Assert.assertEquals(dropMessage, "Dropped!", "Small box was successfully dropped.");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Drag and drop small box.")
    public void drag_and_drop_simple_small_box() {
        interactionsMenuSetup();
        interactionsPage.clickOnDraggableLink();
        Point initialSmallBoxLocation = interactionsPage.getDraggableBoxLocation();
        interactionsPage.dragAndDropSmallBox();
        sleep(1000);
        Point draggedSmallBoxLocation = interactionsPage.getDraggableBoxLocation();
        System.out.println(draggedSmallBoxLocation);
        Assert.assertNotEquals(initialSmallBoxLocation, draggedSmallBoxLocation, "Small box was moved from initial location");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Resize box to maximum size.")
    public void resize_box_to_maximum() {
        interactionsMenuSetup();
        interactionsPage.clickOnResizableLink();
        Point initialBoxLocation = interactionsPage.getResizableBoxLocation();
        interactionsPage.dragAndDropBoxToMaximum();
        sleep(1000);
        Point finalBoxLocation = interactionsPage.getResizableBoxLocation();
        Assert.assertNotEquals(initialBoxLocation, finalBoxLocation, "The box was successfully resized to maximum size.");

    }
}


