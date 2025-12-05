package iscteiul.ista.testes_selenium.the_internet_app;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class DynamicContentPage {
    private static final String URL = "https://the-internet.herokuapp.com/dynamic_content";

    // O conteúdo está dividido em 3 linhas (rows). Vamos capturar todas.
    // Usamos $$ para obter uma lista de elementos (ElementsCollection)
    private final ElementsCollection contentRows = $$("#content .row");

    public void openPage() {
        open(URL);
    }

    public void refreshPage() {
        Selenide.refresh();
    }

    /**
     * Obtém o texto de uma linha específica (0, 1 ou 2)
     */
    public String getRowText(int index) {
        // .get(index) vai buscar a linha
        // .text() extraitodo o texto visível dessa linha
        return contentRows.get(index).text();
    }
}
