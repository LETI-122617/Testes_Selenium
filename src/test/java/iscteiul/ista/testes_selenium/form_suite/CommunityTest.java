package iscteiul.ista.testes_selenium.form_suite;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.text;

public class CommunityTest {

    CommunityPage page = new CommunityPage();

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void init() {
        page.openPage();
    }

    @Test
    public void testFormSubmissionSuccess() {
        // 1. Preencher o formulário (Dados de teste oficiais do SauceDemo)
        page.fillForm("standard_user", "secret_sauce");

        // 2. Submeter
        page.submit();

        // 3. Validar Resultado
        // Verifica se entrou na loja
        page.getSuccessMessage().shouldBe(visible).shouldHave(text("Swag Labs"));
    }
}