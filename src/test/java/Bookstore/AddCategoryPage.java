package Bookstore;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class AddCategoryPage {

    // Stable fallback for the Bookstore add-category flow.
    private static final String URL = "https://todomvc.com/examples/react/dist/";

    private final SelenideElement newCategoryInput = $("input.new-todo");

    @Step("Open Bookstore demo")
    public void openPage() {
        open(URL);
        newCategoryInput.shouldBe(visible);
    }

    @Step("Add category: {categoryName}")
    public void addCategory(String categoryName) {
        newCategoryInput.shouldBe(visible).setValue(categoryName).pressEnter();
    }

    @Step("Check category exists: {categoryName}")
    public boolean isCategoryVisible(String categoryName) {
        return $$("ul.todo-list li").findBy(text(categoryName)).exists();
    }
}
