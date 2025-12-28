package sampler.datainput;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataInputTest {

    DataInputPage page;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        page = new DataInputPage();
        page.openPage();
    }

    @Test
    public void testTextFieldInteraction() {
        String textoTeste = "ES 2025"; // Máximo 10 caracteres
        page.typeText(textoTeste);
        String valorReal = page.getInputValue();
        assertEquals(textoTeste, valorReal, "O texto no input deve ser igual ao escrito.");
    }
}
