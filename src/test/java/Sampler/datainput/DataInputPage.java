package Sampler.datainput;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DataInputPage {

    private static final String URL = "https://demo.vaadin.com/sampler/";

    // Seletores
    private final SelenideElement menuListing = $("#listing");
    private final SelenideElement menuDataInput = menuListing.$(byText("Data input"));
    private final SelenideElement linkTextField = menuListing.$$("div.samplelink").findBy(text("Text field"));
    private final SelenideElement sampleContainer = $("#display .samplepanelcontainer");
    private final SelenideElement inputField = sampleContainer.$("input.v-textfield[type='text']");

    // Métodos
    @Step("Open Sampler Data input -> Text field")
    public void openPage() {
        open(URL);
        menuListing.shouldBe(visible);
        // Navegar: Data input → Text field
        menuDataInput.shouldBe(visible).click();
        linkTextField.shouldBe(visible).click();
    }

    @Step("Type text in text field: {text}")
    public void typeText(String text) {
        inputField.shouldBe(visible);
        inputField.setValue(text);
    }

    @Step("Read text field value")
    public String getInputValue() {
        return inputField.getValue();
    }
}
