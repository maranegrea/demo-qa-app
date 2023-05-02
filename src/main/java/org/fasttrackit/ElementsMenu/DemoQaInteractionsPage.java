package org.fasttrackit.ElementsMenu;

import com.codeborne.selenide.SelenideElement;
import org.fasttrackit.Page;
import org.openqa.selenium.Point;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class DemoQaInteractionsPage extends Page {

    private final SelenideElement droppableLink = $(byText("Droppable"));
    private final SelenideElement draggableElement = $("#draggable");
    private final SelenideElement droppableElement = $("#droppable");
    private final SelenideElement draggableLink = $(byText("Dragabble"));
    private final SelenideElement dragSmallBox = $(byText("Drag me"));

    private final SelenideElement resizableLink = $(byText("Resizable"));
    private SelenideElement resizableHandle = $(".react-resizable-handle.react-resizable-handle-se");


    public void clickOnDroppableLink() {
        droppableLink.scrollTo();
        droppableLink.click();
    }

    public void clickAndHoldDraggableElement() {
        actions().dragAndDrop(draggableElement, droppableElement).build().perform();
    }

    public void clickOnDraggableLink() {
        draggableLink.scrollTo();
        draggableLink.click();
    }

    public void dragAndDropSmallBox() {
        actions().clickAndHold(dragSmallBox).moveByOffset(560, 200).release().build().perform();
    }

    public void clickOnResizableLink() {
        resizableLink.scrollTo();
        resizableLink.click();
    }

    public void dragAndDropBoxToMaximum() {
        resizableHandle.scrollTo();
        actions().clickAndHold(resizableHandle).moveByOffset(500, 300).release().build().perform();
    }

    public String getTextFromDroppableElement() {
        return droppableElement.getText();
    }

    public Point getResizableBoxLocation() {
        return resizableHandle.getLocation();
    }

    public Point getDraggableBoxLocation() {
        return dragSmallBox.getLocation();
    }

}