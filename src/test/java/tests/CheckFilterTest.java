package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ShoesPage;

import java.util.List;

import static io.qameta.allure.Allure.step;

@Tag("UI")
public class CheckFilterTest extends BaseTest {
    MainPage mainPage = new MainPage();
    ShoesPage shoesPage = new ShoesPage();
    List<String> expectedFilterList = List.of("По популярности", "Материалы", "Цвет", "Размер", "Бренд", "Цена",
            "Помогаю планете", "Сезон", "Стиль", "Только со скидкой");

    @Test
    @Owner("renat.khairullin")
    @DisplayName("Проверка наличия фильтров в разделе обувь")
    void checkingForFiltersInTheShoesSection() {
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
}
