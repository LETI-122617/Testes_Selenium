package sampler.datainput;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;

public class DataInputPage {

    private static final String URL = "https://demo.vaadin.com/sampler/";

    // Seletores
    private SelenideElement menuDataInput = $(byText("Data input"));
    private SelenideElement categoryTextual = $(byText("Textual"));
    private SelenideElement linkTextField = $(byText("Text field"));
    // Seletor específico para input de texto (não password)
    private SelenideElement inputField = $("input.v-textfield[type='text']");

    // Métodos
    public void openPage() {
        open(URL);
        // Navegar: Data input → Textual → Text field
        menuDataInput.shouldBe(visible).click();
        categoryTextual.shouldBe(visible).click();
        linkTextField.shouldBe(visible).click();
    }

    public void typeText(String text) {
        inputField.shouldBe(visible);
        inputField.setValue(text);
    }

    public String getInputValue() {
        return inputField.getValue();
    }
}
