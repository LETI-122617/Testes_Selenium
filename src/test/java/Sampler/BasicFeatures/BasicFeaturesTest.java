package Sampler.BasicFeatures;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Feature("Sauce Labs - Basic Features")
public class BasicFeaturesTest {

    BasicFeaturesPage basicFeaturesPage = new BasicFeaturesPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void setUp() {
        open("https://www.saucedemo.com/");
        System.out.println("✅ Sauce Labs carregou!");
    }

    @Test
    @Story("Página de login carrega")
    @Description("Verifica se página de login do Sauce Labs carrega corretamente")
    public void testLoginPageLoads() {
        basicFeaturesPage.usernameInput.shouldBe(visible);
        basicFeaturesPage.passwordInput.shouldBe(visible);
        System.out.println("✅ Página de login carregou!");
    }

    @Test
    @Story("Login com credenciais válidas")
    @Description("Testa login com standard_user")
    public void testValidLogin() {
        basicFeaturesPage.login("standard_user", "secret_sauce");
        sleep(2000);

        int productCount = basicFeaturesPage.countProducts();
        assert productCount > 0 : "Nenhum produto encontrado!";
        System.out.println("✅ Login bem-sucedido! Produtos encontrados: " + productCount);
    }

    @Test
    @Story("Formulário de login existe")
    @Description("Valida que formulário de login está presente")
    public void testLoginFormExists() {
        boolean isLoginPage = basicFeaturesPage.isLoginPageDisplayed();
        assert isLoginPage : "Página de login não está presente!";
        System.out.println("✅ Formulário de login encontrado!");
    }

    @Test
    @Story("Input fields visíveis")
    @Description("Verifica se campos de entrada estão visíveis")
    public void testInputFieldsVisible() {
        basicFeaturesPage.usernameInput.shouldBe(visible);
        basicFeaturesPage.passwordInput.shouldBe(visible);
        basicFeaturesPage.loginButton.shouldBe(visible);
        System.out.println("✅ Todos os campos de entrada visíveis!");
    }

    @Test
    @Story("Entrar texto no username")
    @Description("Valida entrada de texto no campo username")
    public void testUsernameInput() {
        basicFeaturesPage.usernameInput.setValue("standard_user");
        String value = basicFeaturesPage.usernameInput.getValue();
        assert value.equals("standard_user") : "Username não foi inserido!";
        System.out.println("✅ Username inserido com sucesso!");
    }

    @Test
    @Story("Entrar texto no password")
    @Description("Valida entrada de texto no campo password")
    public void testPasswordInput() {
        basicFeaturesPage.passwordInput.setValue("secret_sauce");
        String value = basicFeaturesPage.passwordInput.getValue();
        assert value.equals("secret_sauce") : "Password não foi inserida!";
        System.out.println("✅ Password inserida com sucesso!");
    }
}
