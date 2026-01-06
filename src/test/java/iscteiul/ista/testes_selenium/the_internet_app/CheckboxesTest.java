package iscteiul.ista.testes_selenium.the_internet_app;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import iscteiul.ista.testes_selenium.support.BaseSelenideTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.not;

public class CheckboxesTest extends BaseSelenideTest {

    CheckboxesPage page = new CheckboxesPage();

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void init() {
        page.openPage();
    }

    @Test
    @Description("Toggle both checkboxes and confirm their final states.")
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
