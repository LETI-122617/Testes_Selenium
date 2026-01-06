package iscteiul.ista.testes_selenium.support;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseSelenideTest {

    @BeforeAll
    protected static void setUpAllureListener() {
        SelenideLogger.removeListener("allure");
        SelenideLogger.addListener(
                "allure",
                new AllureSelenide().screenshots(true).savePageSource(true)
        );
    }

    @AfterAll
    protected static void tearDownAllureListener() {
        SelenideLogger.removeListener("allure");
    }
}
