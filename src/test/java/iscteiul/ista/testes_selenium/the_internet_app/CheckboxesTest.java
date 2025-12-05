package iscteiul.ista.testes_selenium.the_internet_app;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.not;

public class CheckboxesTest {

    CheckboxesPage page = new CheckboxesPage();

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
    public void testCheckboxInteraction() {
        // 1. Verificar estado inicial
        // Por defeito no site, o Checkbox 1 está unchecked e o 2 está checked
        page.checkbox1.shouldNotBe(checked);
        page.checkbox2.shouldBe(checked);

        // 2. Interagir (Clicar para inverter)
        page.toggleCheckbox1(); // Deve ficar checked
        page.toggleCheckbox2(); // Deve ficar unchecked

        // 3. Validar novo estado
        page.checkbox1.shouldBe(checked);
        page.checkbox2.shouldNotBe(checked);
    }
}