package com.whiskdev.my.view.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingListPage {
    public static SelenideElement linkCreateNewShoppingList
            = $("a[data-testid='create-new-shopping-list-button']");
    public static SelenideElement dropDownItem = $("div[data-testid='desktop-add-item-autocomplete']");
    public static SelenideElement buttonDeleteShoppingList
            = $("button[data-testid='shopping-list-delete-menu-button']");
    public static SelenideElement inputAddItemInList
            = $("input[data-testid='desktop-add-item-autocomplete']");
    public static By spanItemName
            = By.cssSelector("span[data-testid='shopping-list-item-name']");

    public static ElementsCollection listItems = $$("div[data-testid='shopping-list-item']");
    public static ElementsCollection listShoppingListsName = $$("div[data-testid='shopping-lists-list-name']");

}
