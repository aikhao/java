package com.whiskdev.my.libs.front;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;

import static com.whiskdev.my.libs.uikit.PopupCreateShoppingList.waitEnabledInputNewNameList;
import static com.whiskdev.my.view.pages.ShoppingListPage.linkCreateNewShoppingList;
import static com.whiskdev.my.view.pages.ShoppingListPage.dropDownItem;
import static com.whiskdev.my.view.pages.ShoppingListPage.inputAddItemInList;
import static com.whiskdev.my.view.pages.ShoppingListPage.listItems;
import static com.whiskdev.my.view.pages.ShoppingListPage.listShoppingListsName;
import static com.whiskdev.my.view.pages.ShoppingListPage.spanItemName;

public class ShoppingList {

    public static void clickButtonCreateNewShoppingList(){
        linkCreateNewShoppingList.shouldBe(Condition.exist).click();
        waitEnabledInputNewNameList();
    }

    public static void addItems(String... values) {
        for(String value : values) {
            inputAddItemInList.setValue(value);
            dropDownItem.shouldBe(Condition.exist).shouldBe(Condition.text(value));
            inputAddItemInList.pressEnter();
        }
    }

    public static void checkItemsList(String... values) {
        for (String value:values) {
            listItems.shouldHave(
                    CollectionCondition.anyMatch("items not contains item with " + value,
                            e -> e.findElement(spanItemName)
                                    .getText()
                                    .matches(value)
                    )
            );
        }
    }

    public static void checkNotExistShoppingList(String value) {
        listShoppingListsName.filter(Condition.text(value)).shouldHaveSize(0);
    }
}
