package iscteiul.ista.testes_selenium.the_internet_app;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class DynamicContentPage {
    private static final String URL = "https://the-internet.herokuapp.com/dynamic_content";

    // O conteúdo está dividido em 3 linhas (rows). Vamos capturar todas.
    // Usamos $$ para obter uma lista de elementos (ElementsCollection)
    private final ElementsCollection contentRows = $$("#content .row");

    @Step("Open dynamic content page")
    public void openPage() {
        open(URL);
    }

    @Step("Refresh page content")
    public void refreshPage() {
        Selenide.refresh();
    }

    @Step("Wait for dynamic content rows")
    public void waitForContentRows() {
        contentRows.shouldHave(sizeGreaterThanOrEqual(3));
        contentRows.first().shouldBe(visible);
    }

    /**
     * Obtém o texto de uma linha específica (0, 1 ou 2)
     */
    @Step("Read dynamic content row {index}")
    public String getRowText(int index) {
        waitForContentRows();
        // .get(index) vai buscar a linha
        // .text() extraitodo o texto visível dessa linha
        return contentRows.get(index).text();
    }
}
