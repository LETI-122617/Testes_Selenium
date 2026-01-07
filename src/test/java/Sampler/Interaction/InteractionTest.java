package Sampler.Interaction;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import iscteiul.ista.testes_selenium.support.BaseSelenideTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class InteractionTest extends BaseSelenideTest {

    private InteractionPage page;

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void init() {
        page = new InteractionPage();
        page.openPage();
    }

    @Test
    @Description("Access Interaction component and click a demo button")
    void testInteractionButtonDemo() {
        page.openInteractionButtonDemo();
        page.assertSampleTitle();
        String label = page.getPrimaryButtonLabel();
        assertFalse(label.isEmpty(), "Button label should not be empty");
        page.clickPrimaryButton();
        page.assertPrimaryButtonVisible();
    }
}
