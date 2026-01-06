package iscteiul.ista.testes_selenium.form_suite;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class CommunityPage {
    // Usamos o Swag Labs porque o site da Vaadin mudou e não tem campos simples
    // acessíveis
    private static final String URL = "https://www.saucedemo.com/";

    // Seletores (Username e Password)
    private final SelenideElement usernameField = $("#user-name");
    private final SelenideElement passwordField = $("#password");

    // Botão de Login
    private final SelenideElement loginButton = $("#login-button");

    // Elemento que aparece após sucesso (Título da loja)
    private final SelenideElement successElement = $(".app_logo");
    private final SelenideElement inventoryTitle = $(".title");
    private final SelenideElement inventoryContainer = $("#inventory_container");

    @Step("Open community page")
    public void openPage() {
        open(URL);
    }

    @Step("Fill community form with username: {user}")
    public void fillForm(String user, String pass) {
        usernameField.shouldBe(visible).setValue(user);
        passwordField.shouldBe(visible).setValue(pass);
    }

    @Step("Submit community form")
    public void submit() {
        loginButton.shouldBe(visible).click();
    }

    @Step("Assert login success on community page")
    public void assertLoginSuccess() {
        successElement.shouldBe(visible).shouldHave(text("Swag Labs"));
        inventoryTitle.shouldBe(visible).shouldHave(text("Products"));
        inventoryContainer.shouldBe(visible);
    }
}
