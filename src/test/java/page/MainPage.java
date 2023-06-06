package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement inputSearch = $("._input_1su1z_19");
    private final SelenideElement titleSearch = $("._title_641wy_6 h2");
    private final SelenideElement shoesSection = $("a[href='/c/17/shoes-men/?sitelink=topmenuM&l=4']");
    private final SelenideElement shoes = $("._area_552z7_8");
    private final SelenideElement dropdownListSizeShoes = $("._selectWrapper_1widv_10");
    private final SelenideElement sizeShoes = $$(".recaptcha").first().$("div");
    private final SelenideElement addToCartButton = $(withText("Добавить в корзину"));

    public MainPage openPage() {
        open("https://www.lamoda.ru/men-home/");
        return this;
    }

    public MainPage searchBox(String request) {
        inputSearch.setValue(request).pressEnter();
        return this;
    }

    public MainPage verifResultTitle(String expText) {
        titleSearch.shouldHave(text(expText));
        return this;
    }

    public MainPage openTheSneakersSection() {
        shoesSection.click();
        return this;
    }
    public MainPage chooseShoes() {
        shoes.click();
        return this;
    }
    public MainPage openDropdownListSizeShoes() {
        dropdownListSizeShoes.click();
        return this;
    }
    public MainPage chooseSizeShoes() {
        sizeShoes.click();
        return this;
    }
    public MainPage addToCart() {
        addToCartButton.click();
        return this;
    }
    public MainPage checkAddItemToTheCart(){
        $(".d-modal__frame").$(byText("Товар добавлен в корзину")).parent()
                .shouldHave(text("Товар добавлен в корзину"));
        return this;
    }



}
