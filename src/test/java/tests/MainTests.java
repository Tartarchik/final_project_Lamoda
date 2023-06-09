package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.MainPage;

import java.util.Locale;

import static io.qameta.allure.Allure.step;
@Tag("UI")
public class MainTests {
    public Faker fakerEn = new Faker(new Locale("en"));
    public String email = fakerEn.internet().emailAddress();
    public String expText = "Спасибо!\n" +
            "Письмо с промокодом уже на почте";
    public String expPanelHelp = "Статус заказа по номеру\n" + "Центр поддержки Lamoda\n" + "Как оформить заказ\n" +
            "Как выбрать размер\n" + "Условия доставки\n" + "Мои заказы\n" + "Возврат\n" + "Публичная оферта\n" +
            "Программа лояльности\n" + "Часто задаваемые вопросы";
    MainPage mainPage = new MainPage();


    @Test
    @Owner("renat.khairullin")
    @DisplayName("Проверка формы подписки на новости на главной странице для получения скидки")
    void checkSubscribeToNewsForSale() {

        step("Открыть главную страницу Lamoda", () -> {
            mainPage.openPage();
        });
        step("Ввести email в форму для подписки", () -> {
            mainPage.emailBox(email);
        });
        step("Кликнуть кнопку \"Для него\" для подписки", () -> {
            mainPage.subscription();
        });
        step("Проверка сообщения об успешной подписки", () -> {
            mainPage.verifySubscription(expText);
        });
    }

    @Test
    @Owner("renat.khairullin")
    @DisplayName("Проверка наличия элементов блока \"Помощь\" на главной страницы")
    void checkItemPanelHelp() {

        step("Открыть главную страницу Lamoda", () -> {
            mainPage.openPage();
        });
        step("Проверка элементов в блоке помощь", () -> {
            mainPage.verifyPanelHelp(expPanelHelp);
        });
    }
}
