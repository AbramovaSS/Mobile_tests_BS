package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static data.TestData.TITLE_SET;
import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static io.appium.java_client.AppiumBy.id;

public class SettingsScreen {

    private final SelenideElement settings = $(id("org.wikipedia.alpha:id/explore_overflow_settings")),
            screenSetting = $(androidUIAutomator("new UiSelector().text(\"Settings\")"));

    @Step("Нажать на Settings в открывшемся меню")
    public SettingsScreen tapSettings() {
        settings.click();
        return this;
    }

    @Step("Проверить, что открыватся экран Setting")
    public SettingsScreen checkScreenSetting() {
        screenSetting.shouldHave(Condition.text(TITLE_SET));
        return this;
    }
}
