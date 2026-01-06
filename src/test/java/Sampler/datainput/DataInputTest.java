package Sampler.datainput;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import iscteiul.ista.testes_selenium.support.BaseSelenideTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataInputTest extends BaseSelenideTest {

    DataInputPage page;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        page = new DataInputPage();
        page.openPage();
    }

    @Test
    @Description("Ensure the Sampler Data input text field accepts and returns the typed value.")
    public void testTextFieldInteraction() {
        String textoTeste = "ES 2025"; // Máximo 10 caracteres
        page.typeText(textoTeste);
        String valorReal = page.getInputValue();
        assertEquals(textoTeste, valorReal, "O texto no input deve ser igual ao escrito.");
    }
}
