package Sampler.DataPresentation;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import iscteiul.ista.testes_selenium.support.BaseSelenideTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Sampler Data Presentation")
public class DataPresentationTest extends BaseSelenideTest {

    private DataPresentationPage page;

    @BeforeAll
    static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    void setUp() {
        page = new DataPresentationPage();
        page.openDataPresentation();
    }

    @Test
    @Story("Render data presentation sample")
    @Description("Opens a data presentation sample and validates that rows are rendered")
    void testShouldDisplayDataPresentationSample() {
        page.openSample();
        int rowCount = page.countRows();
        assertTrue(rowCount > 0, "Expected at least one row in the data presentation sample.");
    }
}
