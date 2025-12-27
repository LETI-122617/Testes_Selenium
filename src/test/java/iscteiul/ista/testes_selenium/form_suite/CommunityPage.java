package iscteiul.ista.testes_selenium.form_suite;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
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

    public void openPage() {
        open(URL);
    }

    public void fillForm(String user, String pass) {
        usernameField.shouldBe(visible).setValue(user);
        passwordField.shouldBe(visible).setValue(pass);
    }

    public void submit() {
        loginButton.click();
    }

    public SelenideElement getSuccessMessage() {
        // Retornamos o logo da loja para verificar se o login funcionou
        return successElement;
    }
}