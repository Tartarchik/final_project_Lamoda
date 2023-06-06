package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {
    private final SelenideElement addToCartButton = $(withText("Добавить в корзину"));
    private final SelenideElement modalResultAddToTheCart = $(".d-modal__frame").$(byText("Товар добавлен в корзину"));


    public BasketPage addToCart() {
        addToCartButton.click();
        return this;
    }
    public BasketPage checkAddItemToTheCart() {
        modalResultAddToTheCart.parent()
                .shouldHave(text("Товар добавлен в корзину"));
        return this;
    }
}
