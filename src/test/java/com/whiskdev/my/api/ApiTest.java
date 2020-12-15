package com.whiskdev.my.api;

import static com.whiskdev.my.helper.Constants.ApiStatusMessages.shoppingListNotFound;
import static com.whiskdev.my.properties.Properties.urlApi;

import com.whiskdev.my.entities.List;
import com.whiskdev.my.entities.api.ShoppingList;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ApiTest {

    private static List newList = List.builder().name("string").primary(false).build();
    private static ShoppingList newShoppingList;

    @BeforeEach
    @Step("Preconditions")
    public void preconditions(){
        RestAssured.baseURI = urlApi;
        newShoppingList = ApiList.createShoppingList(newList);
    }

    @Test
    @Tag("api")
    @Epic("api")
    @Feature("Api")
    @DisplayName("Create shopping list")
    public void test_1() {
        ShoppingList verifyShoppingList = ApiList.getShoppingList(newShoppingList.getList().getId());
        verifyShoppingList.getList().getId().equals(newShoppingList.getList().getId());
        Assertions.assertTrue(verifyShoppingList.getContent().isEmpty(),"Content is not empty");

    }

    @Test
    @Tag("api")
    @Epic("api")
    @Feature("Api")
    @DisplayName("Create & delete shopping list")
    public void test_2() {
        ApiList.deleteShoppingList(newShoppingList.getList().getId());
        ShoppingList verifyShoppingList = ApiList.getShoppingList(newShoppingList.getList().getId());
        verifyShoppingList.getMessage().equals(shoppingListNotFound);
    }

}
