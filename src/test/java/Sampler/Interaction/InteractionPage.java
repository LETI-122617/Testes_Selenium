package Sampler.Interaction;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class InteractionPage {
    private static final String URL = "https://demo.vaadin.com/sampler/";
    private static final String INTERACTION_CATEGORY = "Interaction";
    private static final String BUTTON_COMPONENT = "Button";

    private final SelenideElement listing = $("#listing");
    private final SelenideElement breadcrumbLast = $("#breadcrumbs .crumb.last");
    private final SelenideElement sampleContainer = $("#display .samplepanelcontainer");

    @Step("Open Vaadin Sampler")
    public void openPage() {
        open(URL);
        listing.shouldBe(visible);
    }

    @Step("Open Interaction -> Button")
    public void openInteractionButtonDemo() {
        SelenideElement interactionNode = listing.$$(".lowestlevelcategory-anchor")
                .findBy(text(INTERACTION_CATEGORY));
        interactionNode.shouldBe(visible).click();

        SelenideElement buttonNode = listing.$$(".samplelink .title")
                .findBy(text(BUTTON_COMPONENT));
        buttonNode.shouldBe(visible).click();
    }

    public void assertSampleTitle() {
        breadcrumbLast.shouldBe(visible).shouldHave(text(BUTTON_COMPONENT));
    }

    @Step("Click primary demo button")
    public void clickPrimaryButton() {
        primaryButton().shouldBe(visible).click();
    }

    public void assertPrimaryButtonVisible() {
        primaryButton().shouldBe(visible);
    }

    public String getPrimaryButtonLabel() {
        SelenideElement button = primaryButton().shouldBe(visible);
        SelenideElement caption = button.$(".v-button-caption");
        if (caption.exists()) {
            return caption.getText().trim();
        }
        return button.getText().trim();
    }

    private SelenideElement primaryButton() {
        return sampleContainer.$$(".v-button").findBy(visible);
    }
}
