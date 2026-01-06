package iscteiul.ista.testes_selenium.the_internet_app;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckboxesPage {
    // URL da página específica
    private static final String URL = "https://the-internet.herokuapp.com/checkboxes";

    // Mapeamento dos Elementos (Locators)
    // O formulário tem dois checkboxes. O seletor "input[type='checkbox']" apanha ambos.
    // Usamos :first-child e :last-child ou índices para distinguir.
    public SelenideElement checkbox1 = $("#checkboxes input:first-of-type");
    public SelenideElement checkbox2 = $("#checkboxes input:last-of-type");

    // Metodo para abrir a página
    @Step("Open checkboxes demo page")
    public void openPage() {
        open(URL);
    }

    // Ações (Métodos que interagem com a página)
    @Step("Toggle checkbox 1")
    public void toggleCheckbox1() {
        checkbox1.click();
    }

    @Step("Toggle checkbox 2")
    public void toggleCheckbox2() {
        checkbox2.click();
    }
}
