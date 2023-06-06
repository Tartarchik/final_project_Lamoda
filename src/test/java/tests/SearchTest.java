package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.MainPage;

import static io.qameta.allure.Allure.step;

public class SearchTest extends BaseTest {
    MainPage mainPage = new MainPage();

    @CsvSource({
            "Обувь аdidas , Товары по запросу «обувь аdidas»",
            "Обувь nike, Товары по запросу «обувь nike»"
    })
    @ParameterizedTest(name = "По результату поиска запроса {0} должен отображаться title {1}")
    void searchResultByExpectedTitleText(String data, String expText) {

        step("Открытие главное страницы", () -> {
            mainPage.openPage();
        });
        step("В окне поиска на главное странице ввести:" + data, () -> {
            mainPage.searchBox(data);
        });
        step("Проверить наличие title" + expText + "по результатам поиска", () -> {
            mainPage.verifyResultTitle(expText);
        });
    }
}
