package com.whiskdev.my.libs.uikit;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;

import static com.whiskdev.my.helper.Constants.keyA;
import static com.whiskdev.my.properties.Properties.keysForClear;
import static com.whiskdev.my.view.uikit.PopupCreateShoppingList.buttonCreateNewShoppingList;
import static com.whiskdev.my.view.uikit.PopupCreateShoppingList.inputNewNameList;

public class PopupCreateShoppingList {

    public static void setNewShoppingListName(String value){
        inputNewNameList.sendKeys(keysForClear + keyA);
        inputNewNameList.sendKeys(Keys.BACK_SPACE);
        inputNewNameList.setValue(value);
    }

    public static void clickCreateNewListButton(){
        buttonCreateNewShoppingList.click();
    }

    public static void waitEnabledInputNewNameList(){
        inputNewNameList.shouldBe(Condition.exist);
    }
}
