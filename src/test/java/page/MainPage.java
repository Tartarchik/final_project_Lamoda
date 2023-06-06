package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement inputSearch = $("._input_1su1z_19");
    private final SelenideElement titleSearch = $("._title_641wy_6 h2");

    public MainPage openPage() {
        open("https://www.lamoda.ru/men-home/");
        return this;
    }

    public MainPage searchBox(String request) {
        inputSearch.setValue(request).pressEnter();
        return this;
    }

    public MainPage verifyResultTitle(String expText) {
        titleSearch.shouldHave(text(expText));
        return this;
    }

}
