package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.BasketPage;
import page.MainPage;

import static io.qameta.allure.Allure.step;

@Tag("UI")
public class AddItemToTheCartTest extends BaseTest {
    MainPage mainPage = new MainPage();
    BasketPage basketPage = new BasketPage();

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
            mainPage.chooseProduct();
        });
        step("Добавить товар в корзину", () -> {
            basketPage.addToCart();
        });
        step("Проверка добавления товара в корнизу", () -> {
            basketPage.checkAddItemToTheCart();
        });
    }
}
