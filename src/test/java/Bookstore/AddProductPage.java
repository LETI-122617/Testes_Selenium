package Bookstore;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddProductPage {

    // Stable fallback for the Bookstore add-product flow.
    private static final String URL = "https://www.saucedemo.com/";

    private final SelenideElement usernameInput = $("[data-test='username']");
    private final SelenideElement passwordInput = $("[data-test='password']");
    private final SelenideElement loginButton = $("[data-test='login-button']");
    private final SelenideElement addBackpackButton = $("[data-test='add-to-cart-sauce-labs-backpack']");
    private final SelenideElement cartBadge = $(".shopping_cart_badge");
    private final SelenideElement cartLink = $(".shopping_cart_link");
    private final SelenideElement cartItemName = $(".cart_item .inventory_item_name");

    @Step("Open Bookstore demo page")
    public void openPage() {
        open(URL);
    }

    @Step("Login with standard user")
    public void login(String username, String password) {
        usernameInput.shouldBe(visible).setValue(username);
        passwordInput.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Add product to cart")
    public void addProductToCart() {
        addBackpackButton.shouldBe(visible).click();
    }

    @Step("Open cart")
    public void openCart() {
        cartLink.shouldBe(visible).click();
    }

    public String getCartBadgeText() {
        return cartBadge.shouldBe(visible).getText();
    }

    public String getCartItemName() {
        return cartItemName.shouldBe(visible).getText();
    }
}
