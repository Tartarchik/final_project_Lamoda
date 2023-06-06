package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoesPage {
    private final SelenideElement shoesSection = $("a[href='/c/17/shoes-men/?sitelink=topmenuM&l=4']");
    private final SelenideElement shoes = $("._area_552z7_8");
    private final SelenideElement dropdownListSizeShoes = $("._selectWrapper_1widv_10");
    private final SelenideElement sizeShoes = $$(".recaptcha").first().$("div");
    private final ElementsCollection filterShoesList = $$("._filters_py6ob_19 span");


    public ShoesPage openTheShoesSection() {
        shoesSection.click();
        return this;
    }

    public ShoesPage chooseShoes() {
        shoes.click();
        return this;
    }

    public ShoesPage openDropdownListSizeShoes() {
        dropdownListSizeShoes.click();
        return this;
    }

    public ShoesPage chooseSizeShoes() {
        sizeShoes.click();
        return this;
    }

    public ShoesPage checkFilterList(List<String> list) {
        filterShoesList.shouldHave(texts(list));
        return this;
    }

}
