package com.whiskdev.my.web.regres;

import com.codeborne.selenide.Selenide;
import com.whiskdev.my.libs.front.ShoppingList;
import com.whiskdev.my.properties.Users;
import com.whiskdev.my.steps.ShoppingListSteps;
import com.whiskdev.my.web.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.whiskdev.my.properties.Properties.urlFront;
import static com.whiskdev.my.properties.Properties.url_shopping_list_page;

public class UITests extends BaseTest {

    private static String email = Users.customer.login;
    private static String password = Users.customer.password;
    private static String[] items = new String[]{"Milk", "cucumber", "Eggs", "tomato", "potatoes"};
    private static String firstShippingList = "newNameList";
    private static String secondShippingList = "newSecondNameList";

    @Test
    @Tag("core")
    @Epic("Core")
    @Feature("Core")
    @DisplayName("Create shopping list and add five item")
    public void test_1() {

        Selenide.open(urlFront);
        ShoppingListSteps.login(email, password);
        Selenide.open(urlFront + url_shopping_list_page);
        ShoppingListSteps.createNewShoppingList(firstShippingList);
        ShoppingList.addItems(items);
        ShoppingList.checkItemsList(items);

    }

    @Test
    @Tag("core")
    @Epic("Core")
    @Feature("Core")
    @DisplayName("Delete shopping list")
    public void test_2() {

        Selenide.open(urlFront);
        ShoppingListSteps.login(email, password);
        Selenide.open(urlFront + url_shopping_list_page);
        ShoppingListSteps.createNewShoppingList(secondShippingList);
        ShoppingListSteps.deleteShoppingList(secondShippingList);
        ShoppingList.checkNotExistShoppingList(secondShippingList);

    }

}
