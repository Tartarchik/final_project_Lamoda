package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultSearchPage {
    private final SelenideElement product = $$(".grid__catalog").first().$("div");
    private final SelenideElement titleSearch = $(".width-wrapper h2");

    public ResultSearchPage verifyResultTitle(String expText) {
        titleSearch.shouldHave(text(expText));
        return this;
    }
    public ResultSearchPage chooseProduct() {
        product.click();
        return this;
    }

}
