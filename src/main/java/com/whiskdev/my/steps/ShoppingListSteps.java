package com.whiskdev.my.steps;

import com.codeborne.selenide.Condition;
import com.whiskdev.my.libs.front.ShoppingList;
import com.whiskdev.my.libs.uikit.PopupAlert;
import com.whiskdev.my.libs.uikit.PopupAuthorization;
import com.whiskdev.my.libs.uikit.PopupCreateShoppingList;

import static com.whiskdev.my.helper.Constants.Attributes.attributeButton;
import static com.whiskdev.my.properties.Properties.timeoutWaitStep;
import static com.whiskdev.my.view.pages.ShoppingListPage.buttonDeleteShoppingList;
import static com.whiskdev.my.view.pages.ShoppingListPage.listShoppingListsName;
import static com.whiskdev.my.view.uikit.PopupAuthorization.inputPassword;
import static com.whiskdev.my.view.uikit.PopupAuthorization.rootElement;

public class ShoppingListSteps {

    public static void login(String email, String password) {
        PopupAuthorization.setUsername(email);
        PopupAuthorization.clickButtonContinue();
        rootElement.$(inputPassword).waitUntil(Condition.visible, timeoutWaitStep);
        PopupAuthorization.setPassword(password);
        PopupAuthorization.clickAuthLogin();
        rootElement.waitWhile(Condition.visible, timeoutWaitStep);
    }

    public static void createNewShoppingList(String value) {
        ShoppingList.clickButtonCreateNewShoppingList();
        PopupCreateShoppingList.setNewShoppingListName(value);
        PopupCreateShoppingList.clickCreateNewListButton();
    }

    public static void deleteShoppingList(String value) {
        listShoppingListsName
                .find(Condition.text(value))
                .parent()
                .sibling(0)
                .find(attributeButton)
                .shouldBe(Condition.visible)
                .click();
        buttonDeleteShoppingList.shouldBe(Condition.visible).click();
        PopupAlert.clickConfirmDelete();
    }
}
