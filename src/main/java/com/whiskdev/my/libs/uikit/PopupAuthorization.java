package com.whiskdev.my.libs.uikit;

import static com.whiskdev.my.view.uikit.PopupAuthorization.buttonAuthLogin;
import static com.whiskdev.my.view.uikit.PopupAuthorization.buttonContinue;
import static com.whiskdev.my.view.uikit.PopupAuthorization.inputName;
import static com.whiskdev.my.view.uikit.PopupAuthorization.inputPassword;
import static com.whiskdev.my.view.uikit.PopupAuthorization.rootElement;

public class PopupAuthorization {

    public static void setUsername(String username){
        rootElement.$(inputName).setValue(username);
    }

    public static void setPassword(String password){
        rootElement.$(inputPassword).setValue(password);
    }

    public static void clickButtonContinue(){
        buttonContinue.click();
    }

    public static void clickAuthLogin(){
        buttonAuthLogin.click();
    }

}
