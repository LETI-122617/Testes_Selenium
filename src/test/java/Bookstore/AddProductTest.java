package Bookstore;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import iscteiul.ista.testes_selenium.support.BaseSelenideTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Bookstore - Add Product")
public class AddProductTest extends BaseSelenideTest {

    private static final String PRODUCT_NAME = "Sauce Labs Backpack";
    private AddProductPage page;

    @BeforeAll
    static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    void setUp() {
        page = new AddProductPage();
        page.openPage();
    }

    @Test
    @Story("Add a product to cart")
    @Description("Logs in, adds a product, and verifies cart count and item name")
    void testShouldAddProductToCart() {
        page.login("standard_user", "secret_sauce");
        page.addProductToCart();

        assertEquals("1", page.getCartBadgeText(), "Cart badge should show 1 item.");

        page.openCart();
        assertEquals(PRODUCT_NAME, page.getCartItemName(), "Cart should contain the expected product.");
    }
}
