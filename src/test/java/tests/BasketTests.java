package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static io.qameta.allure.Allure.step;

public class BasketTests extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Добавления товара в корнизу")
    void addItemToTheCart() {

        step("Открыть главную страницу Lamoda", () -> {
            mainPage.openPage();
        });
        step("Перейти в раздел кроссовки", () -> {
            mainPage.openTheSneakersSection();
        });
        step("Выбрать кроссовки в разделе", () -> {
            mainPage.chooseShoes();
        });
        step("Открыть список размеров", () -> {
            mainPage.openDropdownListSizeShoes();
        });
        step("Выбрать размер", () -> {
            mainPage.chooseSizeShoes();
        });
        step("Добавить кроссовки в корзину", () -> {
            mainPage.addToCart();
        });
        step("Проверка добавления товара в корнизу", () -> {
            mainPage.checkAddItemToTheCart();
        });
    }
}
