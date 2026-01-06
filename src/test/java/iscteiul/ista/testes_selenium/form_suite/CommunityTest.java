package iscteiul.ista.testes_selenium.form_suite;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import iscteiul.ista.testes_selenium.support.BaseSelenideTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommunityTest extends BaseSelenideTest {

    private CommunityPage page;

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void init() {
        page = new CommunityPage();
        page.openPage();
    }

    @Test
    @Description("Submit the community form and verify successful login state.")
    public void testFormSubmissionSuccess() {
        // 1. Preencher o formulário (Dados de teste oficiais do SauceDemo)
        page.fillForm("standard_user", "secret_sauce");

        // 2. Submeter
        page.submit();

        // 3. Validar Resultado
        // Verifica se entrou na loja
        page.assertLoginSuccess();
    }
}
