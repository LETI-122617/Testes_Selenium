package sampler.BasicFeatures;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasicFeaturesPage {

    public SelenideElement usernameInput = $("input[data-test='username']");
    public SelenideElement passwordInput = $("input[data-test='password']");
    public SelenideElement loginButton = $("input[type='submit']");
    public SelenideElement pageHeading = $("h1");

    public void login(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
    }

    public int countProducts() {
        return $$("div[data-test='inventory-item']").size();
    }

    public String getPageTitle() {
        return pageHeading.getText();
    }

    public boolean isLoginPageDisplayed() {
        return loginButton.exists();
    }
}
