package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.MainPage;

import java.util.List;

import static io.qameta.allure.Allure.step;

public class FilterTest extends BaseTest {
    MainPage mainPage = new MainPage();
    List<String> expectedFilterList = List.of("По популярности", "Материалы", "Цвет", "Размер", "Бренд", "Цена",
            "Помогаю планете", "Сезон", "Стиль", "Только со скидкой");

    @Test
    @DisplayName("Проверка наличия фильтров в разделе обувь")
    void searchResultByExpectedList() {
        step("Открыть главную страницу Lamoda", () -> {
            mainPage.openPage();
        });
        step("Перейти в раздел обувь", () -> {
            mainPage.openTheSneakersSection();
        });
        step("Проверить наличие фильтров в разделе обувь", () -> {
            mainPage.checkFilterList(expectedFilterList);
        });
    }
}
