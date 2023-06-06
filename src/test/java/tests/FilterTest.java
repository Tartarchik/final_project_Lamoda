package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import page.MainPage;
import page.ShoesPage;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class FilterTest extends BaseTest {
    MainPage mainPage = new MainPage();
    ShoesPage shoesPage = new ShoesPage();
    List<String> expectedFilterList = List.of("По популярности", "Материалы", "Цвет", "Размер", "Бренд", "Цена",
            "Помогаю планете", "Сезон", "Стиль", "Только со скидкой");

    @Test
    @DisplayName("Проверка наличия фильтров в разделе обувь")
    void searchResultByExpectedList() {
        step("Открыть главную страницу Lamoda", () -> {
            mainPage.openPage();
        });
        step("Перейти в раздел обувь", () -> {
            shoesPage.openTheShoesSection();
        });
        step("Проверить наличие фильтров в разделе обувь", () -> {
            shoesPage.checkFilterList(expectedFilterList);
        });
    }

    static Stream<Arguments> searchResultByExpectedListManufacturers() {
        return Stream.of(
                Arguments.of("phone", List.of("Apple", "Xiaomi", "Samsung", "Google", "Baseus")),
                Arguments.of("hi.fi", List.of("Denon", "Bowers & Wilkins", "Audio Pro", "DIGMA", "Ruizu"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "По результату поиска запроса {0} должен отображаться список производителей {1}")
    void searchResultByExpectedListManufacturers(String data, List<String> a) {
        $("#header-search").setValue(data).pressEnter();
        $$(".XkAMv span ._1ZDAA").shouldHave(texts(a));
    }
}
