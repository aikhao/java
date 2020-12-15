package com.whiskdev.my.web;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.util.logging.Level;

public class BaseTest {

    @BeforeAll
    @Step("PreConfiguration")
    public static void preConfiguration() {

        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)
                        .includeSelenideSteps(true)
                        .enableLogs(LogType.BROWSER, Level.ALL)
                        .enableLogs(LogType.CLIENT, Level.ALL)
                        .enableLogs(LogType.DRIVER, Level.ALL));
    }

    @AfterEach
    @Step("Close browser")
    public void closeAndClear() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            if (WebDriverRunner.getSelenideProxy() != null && WebDriverRunner.getSelenideProxy().isStarted()) {
                WebDriverRunner.getSelenideProxy().shutdown();
            }
            WebDriverRunner.getWebDriver().quit();
        }
    }
}
