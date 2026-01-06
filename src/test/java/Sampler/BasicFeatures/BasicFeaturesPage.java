package Sampler.BasicFeatures;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class BasicFeaturesPage {

    // Suite 8 uses Sauce Demo to cover basic login and input interactions.
    private static final String URL = "https://www.saucedemo.com/";

    public final SelenideElement usernameInput = $("[data-test='username']");
    public final SelenideElement passwordInput = $("[data-test='password']");
    public final SelenideElement loginButton = $("[data-test='login-button']");
    private final ElementsCollection inventoryItems = $$(".inventory_item");

    @Step("Open Sampler Basic Features page")
    public void openPage() {
        open(URL);
    }

    @Step("Login with username: {username}")
    public void login(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
    }

    @Step("Count inventory products")
    public int countProducts() {
        inventoryItems.shouldHave(sizeGreaterThan(0));
        return inventoryItems.size();
    }

    @Step("Check if login page is displayed")
    public boolean isLoginPageDisplayed() {
        return loginButton.shouldBe(visible).exists();
    }
}
