package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.MainPage;
import pages.ResultSearchPage;

import static io.qameta.allure.Allure.step;

@Tag("UI")
public class SearchTest extends BaseTest {
    MainPage mainPage = new MainPage();
    ResultSearchPage resultSearchPage = new ResultSearchPage();

    @CsvSource({
            "Обувь аdidas , Товары по запросу «обувь аdidas»",
            "Обувь nike, Товары по запросу «обувь nike»"
    })
    @Owner("renat.khairullin")
    @ParameterizedTest(name = "По результату поиска запроса {0} должен отображаться title {1}")
    void searchResultByExpectedTitleText(String data, String expText) {

        step("Открытие главное страницы", () -> {
            mainPage.openPage();
        });
        step("В окне поиска на главное странице ввести:" + data, () -> {
            mainPage.searchBox(data);
        });
        step("Проверить наличие title " + expText + " по результатам поиска", () -> {
            resultSearchPage.verifyResultTitle(expText);
        });
    }
}
