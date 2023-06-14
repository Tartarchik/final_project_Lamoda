package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import helpers.Attachments;


import java.util.Map;

import static config.WebDriverConfig.PROP;

public class BaseTest {
    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = PROP.getBaseUrl();
        Configuration.browser = PROP.getBrowserName();
        Configuration.browserVersion = PROP.getBrowserVersion();
        Configuration.browserSize = PROP.getBrowserSize();
        Configuration.pageLoadTimeout = PROP.getPageLoadTimeout();
        Configuration.timeout = PROP.getTimeout();
        Configuration.headless = PROP.isHeadless();

        if (PROP.isRemote()) {
            Configuration.remote = PROP.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void attach() {
        Attachments.pageSource();
        Attachments.screenShot();
        Attachments.addConsoleLog();
        Attachments.addVideo();
        Selenide.closeWebDriver();
    }


}
