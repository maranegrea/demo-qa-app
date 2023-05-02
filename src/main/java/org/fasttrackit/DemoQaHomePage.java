package org.fasttrackit;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DemoQaHomePage extends Page {
    private final SelenideElement bannerImage = $(".banner-image");
    private final SelenideElement toolsQaPageTitle = $(".enroll__heading");
    private final SelenideElement cardsCategory = $(".category-cards");
    private final SelenideElement elementsCard = cardsCategory.find(".card-body>h5", 0);
    private final SelenideElement alertsCard = cardsCategory.find(".card-body>h5", 2);
    private final SelenideElement widgetsCard = cardsCategory.find(".card-body>h5", 3);
    //$(".card.top-card:nth-child(4)");
    private final SelenideElement interactionsCard = cardsCategory.find(".card-body>h5", 4);
    private final SelenideElement bookStoreCard = cardsCategory.find(".card-body>h5", 5);

    private final SelenideElement elementsList = $(".element-list.collapse.show");
    private final SelenideElement alertsList = $(".element-list.collapse.show");
    private final SelenideElement widgetsList = $(".element-list.collapse.show");
    private final SelenideElement interactionsList = $(".element-list.collapse.show");
    private final SelenideElement bookStoreList = $(".element-list.collapse.show");

    public void clickOnBannerImage() {
        bannerImage.click();
    }

    public void clickOnElementsList() {
        elementsCard.scrollTo();
        elementsCard.click();
    }

    public void clickOnAlertsList() {
        alertsCard.scrollTo();
        alertsCard.click();
    }

    public void clickOnWidgetsList() {
        widgetsCard.scrollTo();
        widgetsCard.click();
    }

    public void clickOnInteractionsList() {
        interactionsCard.scrollTo();
        interactionsCard.click();
    }

    public void clickOnBookSToreList() {
        bookStoreCard.scrollTo();
        bookStoreCard.click();
    }

    public boolean checkToolsQaPageTitlePresence() {
        return toolsQaPageTitle.isDisplayed();
    }

    public boolean viewElementsList() {
        return elementsList.isDisplayed();
    }

    public boolean viewAlertsList() {
        return alertsList.isDisplayed();
    }

    public boolean viewWidgetsList() {
        return widgetsList.isDisplayed();
    }

    public boolean viewInteractionsList() {
        return interactionsList.isDisplayed();
    }

    public boolean viewBookStoreList() {
        return bookStoreList.isDisplayed();
    }
}

