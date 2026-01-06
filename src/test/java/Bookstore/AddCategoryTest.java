package Bookstore;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import iscteiul.ista.testes_selenium.support.BaseSelenideTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddCategoryTest extends BaseSelenideTest {

    private AddCategoryPage page;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void setUp() {
        page = new AddCategoryPage();
        page.openPage();
    }

    @Test
    @Description("Add a new category (TodoMVC fallback) and verify it appears in the list.")
    public void testShouldAddCategory() {
        String categoryName = "Sci-Fi " + System.currentTimeMillis();
        page.addCategory(categoryName);
        assertTrue(page.isCategoryVisible(categoryName), "Category should be visible in the list.");
    }
}
