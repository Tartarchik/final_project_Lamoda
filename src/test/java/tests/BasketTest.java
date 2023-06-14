package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ProductCardPage;
import pages.MainPage;
import pages.ResultSearchPage;

import static io.qameta.allure.Allure.step;

@Tag("UI")
public class BasketTest extends BaseTest {
    MainPage mainPage = new MainPage();
    ProductCardPage productCardPage = new ProductCardPage();
    ResultSearchPage resultSearchPage = new ResultSearchPage();

    @Test
    @Owner("renat.khairullin")
    @DisplayName("Добавления товара в корзину")
    void addItemToTheCart() {

        step("Открыть главную страницу Lamoda", () -> {
            mainPage.openPage();
        });
        step("Найти товары для дома", () -> {
            mainPage.searchBox("Товары для дома");
        });
        step("Выбрать товар", () -> {
            resultSearchPage.chooseProduct();
        });
        step("Добавить товар в корзину", () -> {
            productCardPage.addToCart();
        });
        step("Проверка добавления товара в корзину", () -> {
            productCardPage.checkAddItemToTheCart();
        });
    }
}
