package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.MainScreen;
import screens.SearchScreen;
import screens.SettingsScreen;

import static data.TestData.SEARCH_QUERY;


public class BrowserstackWikipediaTests extends TestBase {

    SearchScreen searchScreen = new SearchScreen();
    SettingsScreen settingsScreen = new SettingsScreen();
    MainScreen mainScreen = new MainScreen();

    @Tag("browserstack")
    @DisplayName("Поиск по валидному запросу и отображение списка результатов")
    @Test
    void successfulSearch() {
        searchScreen.skipStartScreen()
                .searchInput()
                .setKeyInput("Appium")
                .verifySearchResultsAreDisplayed();
    }

    @Tag("browserstack")
    @DisplayName("Удаление запроса в строке поиска")
    @Test
    void deletingQuerySearch() {
        searchScreen.skipStartScreen()
                .searchInput()
                .setKeyInput(SEARCH_QUERY)
                .tapSearchCloseBtn()
                .verifySearchSrcText();
    }

    @Tag("browserstack")
    @DisplayName("Переход в настройки Wiki")
    @Test
    void goToSettingsScreen() {
        mainScreen.tapOkAlert()
                .tapNavMenuBtn();
        settingsScreen.tapSettings()
                .checkScreenSetting();
    }

    @Tag("browserstack")
    @DisplayName("Переход на экран результата")
    @Test
    void successfulGoToResultScreen() {
        searchScreen.skipStartScreen()
                .searchInput()
                .setKeyInput("Appium")
                .tapFirstSearchResult();
        mainScreen.tapOkAlert();
        searchScreen.verifyTitleSearchResult();
    }
}
