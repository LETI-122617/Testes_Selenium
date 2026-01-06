package iscteiul.ista.testes_selenium.the_internet_app;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import iscteiul.ista.testes_selenium.support.BaseSelenideTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DynamicContentTest extends BaseSelenideTest {

    DynamicContentPage page = new DynamicContentPage();

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void init() {
        page.openPage();
    }

    @Test
    @Description("Refresh dynamic content and verify the text changes.")
    public void testContentChangesOnRefresh() {
        // 1. Capturar o texto inicial da 3ª linha (índice 2)
        // (A 3ª linha costuma mudar mais frequentemente ou podemos testar todas)
        String initialText = page.getRowText(2);

        String newText = initialText;
        for (int attempt = 0; attempt < 3 && newText.equals(initialText); attempt++) {
            page.refreshPage();
            newText = page.getRowText(2);
        }

        // 4. Validação: O texto DEVE ser diferente
        assertNotEquals(initialText, newText, "O conteúdo devia ter mudado após o refresh!");
    }
}
