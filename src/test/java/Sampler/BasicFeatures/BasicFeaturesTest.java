package Sampler.BasicFeatures;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import iscteiul.ista.testes_selenium.support.BaseSelenideTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Sampler Basic Features")
public class BasicFeaturesTest extends BaseSelenideTest {

    BasicFeaturesPage basicFeaturesPage;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void setUp() {
        basicFeaturesPage = new BasicFeaturesPage();
        basicFeaturesPage.openPage();
    }

    @Test
    @Story("Página de login carrega")
    @Description("Verifica se a página de login carrega corretamente")
    public void testLoginPageLoads() {
        basicFeaturesPage.usernameInput.shouldBe(visible);
        basicFeaturesPage.passwordInput.shouldBe(visible);
        basicFeaturesPage.loginButton.shouldBe(visible);
    }

    @Test
    @Story("Login com credenciais válidas")
    @Description("Testa login com standard_user")
    public void testValidLogin() {
        basicFeaturesPage.login("standard_user", "secret_sauce");
        int productCount = basicFeaturesPage.countProducts();
        assertTrue(productCount > 0, "Nenhum produto encontrado!");
    }

    @Test
    @Story("Formulário de login existe")
    @Description("Valida que formulário de login está presente")
    public void testLoginFormExists() {
        boolean isLoginPage = basicFeaturesPage.isLoginPageDisplayed();
        assertTrue(isLoginPage, "Página de login não está presente!");
    }

    @Test
    @Story("Input fields visíveis")
    @Description("Verifica se campos de entrada estão visíveis")
    public void testInputFieldsVisible() {
        basicFeaturesPage.usernameInput.shouldBe(visible);
        basicFeaturesPage.passwordInput.shouldBe(visible);
        basicFeaturesPage.loginButton.shouldBe(visible);
    }

    @Test
    @Story("Entrar texto no username")
    @Description("Valida entrada de texto no campo username")
    public void testUsernameInput() {
        basicFeaturesPage.usernameInput.setValue("standard_user");
        String value = basicFeaturesPage.usernameInput.getValue();
        assertEquals("standard_user", value, "Username não foi inserido!");
    }

    @Test
    @Story("Entrar texto no password")
    @Description("Valida entrada de texto no campo password")
    public void testPasswordInput() {
        basicFeaturesPage.passwordInput.setValue("secret_sauce");
        String value = basicFeaturesPage.passwordInput.getValue();
        assertEquals("secret_sauce", value, "Password não foi inserida!");
    }
}
