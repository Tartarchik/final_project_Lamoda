package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.BasketPage;
import page.MainPage;
import page.ShoesPage;

import static io.qameta.allure.Allure.step;
@Tag("UI")
public class AddItemToTheCartTest extends BaseTest {
    MainPage mainPage = new MainPage();
    ShoesPage shoesPage = new ShoesPage();
    BasketPage basketPage = new BasketPage();

    @Test
    @Owner("renat.khairullin")
    @DisplayName("Добавления товара в корзину из раздела обувь")
    void addItemToTheCart() {

        step("Открыть главную страницу Lamoda", () -> {
            mainPage.openPage();
        });
        step("Перейти в раздел кроссовки", () -> {
            shoesPage.openTheShoesSection();
        });
        step("Выбрать кроссовки в разделе", () -> {
            shoesPage.chooseShoes();
        });
        step("Выбрать размер", () -> {
            shoesPage.chooseSizeShoes();
        });
        step("Добавить кроссовки в корзину", () -> {
            basketPage.addToCart();
        });
        step("Проверка добавления товара в корнизу", () -> {
            basketPage.checkAddItemToTheCart();
        });
    }
}
