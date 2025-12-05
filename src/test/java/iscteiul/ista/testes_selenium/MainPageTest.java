package iscteiul.ista.testes_selenium;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {

    @BeforeAll
    public static void setUpAll() {
        // A tua versão (correta) usa 1920x1080 e configura o Allure
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        // 1. Abrir a página
        open("https://www.jetbrains.com/");

        // 2. Dar tempo para carregar
        Selenide.sleep(1000);

        // 3. Fechar Cookies (se aparecerem) - Lógica robusta
        SelenideElement cookieButton = $(byText("Accept All"));
        if (cookieButton.exists()) {
            cookieButton.click();
            cookieButton.shouldNotBe(visible);
        }
    }

    @Test
    public void verifySiteTitle() {
        // Teste Simples: Verificar se o título contém "JetBrains"
        String title = Selenide.title();
        assertNotNull(title);
        assertTrue(title.contains("JetBrains"), "O título do site devia mencionar JetBrains");
    }

    @Test
    public void verifyDeveloperToolsMenu() {
        // Teste de Navegação
        SelenideElement menuDevTools = $(byText("Developer Tools"));

        menuDevTools.shouldBe(visible).click();

        // Verifica se continua visível/ativo
        menuDevTools.shouldBe(visible);
    }

    @Test
    public void verifySearchButtonExists() {
        // Teste de Existência atualizado
        $("[data-test='site-header-search-action']").shouldBe(visible);
    }
}