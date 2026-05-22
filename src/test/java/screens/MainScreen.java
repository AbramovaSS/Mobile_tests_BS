package screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class MainScreen {

    private final SelenideElement closeAlertUpdate = $(AppiumBy.id("android:id/button1")),
            navMenuBtn = $(id("org.wikipedia.alpha:id/menu_overflow_button"));

    @Step("Нажать на OK в диалоговом окне")
    public MainScreen tapOkAlert() {
        closeAlertUpdate.click();
        return this;
    }

    @Step("Нажать на меню в навбаре")
    public MainScreen tapNavMenuBtn() {
        navMenuBtn.click();
        return this;
    }
}
