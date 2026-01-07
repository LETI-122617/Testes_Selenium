package iscteiul.ista.testes_selenium;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import iscteiul.ista.testes_selenium.support.BaseSelenideTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest extends BaseSelenideTest {

    @BeforeAll
    public static void setUpAll() {
        // A tua versão (correta) usa 1920x1080
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void setUp() {
        // 1. Abrir a página
        open("https://www.jetbrains.com/");

        // 2. Esperar por um elemento estável do header
        $("[data-test='site-header-search-action']").shouldBe(visible);

        // 3. Fechar Cookies (se aparecerem) - Lógica robusta
        closeCookieDialogIfPresent();
    }

    @Test
    @Description("Verify the JetBrains homepage title contains the expected branding.")
    public void verifySiteTitle() {
        // Teste Simples: Verificar se o título contém "JetBrains"
        String title = Selenide.title();
        assertNotNull(title);
        assertTrue(title.contains("JetBrains"), "O título do site devia mencionar JetBrains");
    }

    @Test
    @Description("Open the Developer Tools menu and ensure it stays visible.")
    public void verifyDeveloperToolsMenu() {
        // Teste de Navegação
        SelenideElement menuDevTools = $(byText("Developer Tools"));

        closeCookieDialogIfPresent();
        menuDevTools.shouldBe(visible).click();

        // Verifica se continua visível/ativo
        menuDevTools.shouldBe(visible);
    }

    @Test
    @Description("Check that the site search button is visible.")
    public void verifySearchButtonExists() {
        // Teste de Existência atualizado
        $("[data-test='site-header-search-action']").shouldBe(visible);
    }

    private void closeCookieDialogIfPresent() {
        // Aguardar brevemente para o popup aparecer
        Selenide.sleep(100);
        
        // Tentar aceitar cookies se o botão existir
        SelenideElement acceptAllButton = $(".ch2-allow-all-btn");
        if (acceptAllButton.exists() && acceptAllButton.is(visible)) {
            try {
                acceptAllButton.click();
                Selenide.sleep(300);
            } catch (Exception ignored) {}
        }
        
        // Forçar remoção via JavaScript (mais fiável)
        Selenide.executeJavaScript(
            "document.querySelectorAll('.ch2-container, .ch2-dialog, [class*=\"cookie\"], [id*=\"cookie\"]').forEach(el => el.remove());"
        );
    }
}
