package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainScreen;
import pages.SearchScreen;
import pages.SettingsScreen;

import static data.TestData.SEARCH_QUERY;


public class LocalWikipediaTests extends TestBase {

    SearchScreen searchScreen = new SearchScreen();
    SettingsScreen settingsScreen = new SettingsScreen();
    MainScreen mainScreen = new MainScreen();

    @Tag("local")
    @DisplayName("Поиск по валидному запросу и отображение списка результатов")
    @Test
    void successfulSearch() {
        searchScreen.skipStartScreen()
                .searchInput()
                .setKeyInput(SEARCH_QUERY)
                .verifySearchResultsAreDisplayed();
    }

    @Tag("local")
    @DisplayName("Удаление запроса в строке поиска")
    @Test
    void deletingQuerySearch() {
        searchScreen.skipStartScreen()
                .searchInput()
                .setKeyInput(SEARCH_QUERY)
                .tapSearchCloseBtn()
                .verifySearchSrcText();
    }

    @Tag("local")
    @DisplayName("Переход в настройки Wiki")
    @Test
    void goToSettingsScreen() {
        mainScreen.tapOkAlert()
                .tapNavMenuBtn();
        settingsScreen.tapSettings()
                .checkScreenSetting();
    }

    @Tag("local")
    @DisplayName("Переход на экран результата")
    @Test
    void successfulGoToResultScreen() {
        searchScreen.skipStartScreen()
                .searchInput()
                .setKeyInput(SEARCH_QUERY)
                .tapFirstSearchResult();
        mainScreen.tapOkAlert();
        searchScreen.verifyTitleSearchResult();
    }
}
