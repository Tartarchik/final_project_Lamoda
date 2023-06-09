package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {
    private final SelenideElement addToCartButton = $("[aria-label='Добавить в корзину']");
    private final SelenideElement modalResultAddToTheCart = $(".d-modal__header");


    public BasketPage addToCart() {
        addToCartButton.click();
        return this;
    }
    public BasketPage checkAddItemToTheCart() {
        modalResultAddToTheCart.shouldHave(text("Товар добавлен в корзину"));
        return this;
    }
}
