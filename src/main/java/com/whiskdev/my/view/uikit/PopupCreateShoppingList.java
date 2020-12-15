package com.whiskdev.my.view.uikit;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PopupCreateShoppingList {

    public static SelenideElement inputNewNameList = $("input[data-testid='UI_KIT_INPUT']");
    public static SelenideElement buttonCreateNewShoppingList
            = $("button[data-testid='create-new-shopping-list-create-button']");

}
