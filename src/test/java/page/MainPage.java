package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement inputSearch = $("._input_1su1z_19");
    private final SelenideElement titleSearch = $("._title_641wy_6 h2");
    private final SelenideElement inputEmail = $("[name='Электронная почта']");
    private final SelenideElement subscriptionButton = $(byText("Для него"));
    private final ElementsCollection subscriptionMessage = $$("._body_1ud0a_107");
    private final SelenideElement panelHelp = $("div").$(".details__panel");

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

    public MainPage emailBox(String email) {
        inputEmail.setValue(email);
        return this;
    }

    public MainPage subscription() {
        subscriptionButton.click();
        return this;
    }

    public MainPage verifySubscription(String expText) {
        subscriptionMessage.shouldHave(texts(expText));
        return this;
    }

    public MainPage verifyPanelHelp(String expText) {
        panelHelp.shouldHave(text(expText));
        return this;
    }

}
