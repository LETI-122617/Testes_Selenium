package iscteiul.ista.testes_selenium.the_internet_app;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DynamicContentTest {

    DynamicContentPage page = new DynamicContentPage();

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
    public void testContentChangesOnRefresh() {
        // 1. Capturar o texto inicial da 3ª linha (índice 2)
        // (A 3ª linha costuma mudar mais frequentemente ou podemos testar todas)
        String initialText = page.getRowText(2);

        System.out.println("Texto Inicial: " + initialText);

        // 2. Ação: Recarregar a página
        page.refreshPage();

        // 3. Capturar o novo texto da mesma linha
        String newText = page.getRowText(2);

        System.out.println("Texto Novo: " + newText);

        // 4. Validação: O texto DEVE ser diferente
        assertNotEquals(initialText, newText, "O conteúdo devia ter mudado após o refresh!");
    }
}