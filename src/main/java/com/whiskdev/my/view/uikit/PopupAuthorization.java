package com.whiskdev.my.view.uikit;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PopupAuthorization {

    public static SelenideElement rootElement = $("div[data-testid='authentication-modal']");
    public static SelenideElement buttonAuthLogin = $("button[data-testid='auth-login-button']");
    public static SelenideElement buttonContinue = $("button[data-testid='auth-continue-button']");

    public static By inputName = By.name("username");
    public static By inputPassword = By.name("password");

}
