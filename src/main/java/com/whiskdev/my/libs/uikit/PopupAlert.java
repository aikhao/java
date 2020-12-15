package com.whiskdev.my.libs.uikit;

import com.codeborne.selenide.Condition;

import static com.whiskdev.my.view.uikit.PopupAlert.buttonConfirmDelete;

public class PopupAlert {

    public static void clickConfirmDelete(){
        buttonConfirmDelete.shouldBe(Condition.visible).click();
        buttonConfirmDelete.shouldNotBe(Condition.visible);
    }

}
