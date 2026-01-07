package Sampler.DataPresentation;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class DataPresentationPage {

    private static final String URL = "https://demo.vaadin.com/sampler/";
    private static final List<String> SAMPLE_LINKS = List.of("Table", "Grid", "Tree", "TreeTable");

    private final SelenideElement menuListing = $("#listing");
    private final SelenideElement menuDataPresentation = menuListing.$(byText("Data presentation"));
    private final ElementsCollection sampleLinks = menuListing.$$("div.samplelink");
    private final SelenideElement sampleContainer = $("#display .samplepanelcontainer");
    private final SelenideElement dataContainer = sampleContainer.$(
            ".v-table-table, .v-grid-tablewrapper, table"
    );
    private final ElementsCollection tableRows = sampleContainer.$$("table tr");
    private final ElementsCollection gridRows = sampleContainer.$$(".v-grid-row");

    @Step("Open Sampler Data presentation section")
    public void openDataPresentation() {
        open(URL);
        menuListing.shouldBe(visible);
        menuDataPresentation.shouldBe(visible).click();
        sampleLinks.shouldHave(sizeGreaterThan(0));
    }

    @Step("Open a data presentation sample")
    public void openSample() {
        SelenideElement link = pickSampleLink();
        link.shouldBe(visible).click();
    }

    @Step("Count data rows in sample")
    public int countRows() {
        dataContainer.shouldBe(visible);
        return Math.max(tableRows.size(), gridRows.size());
    }

    private SelenideElement pickSampleLink() {
        for (String label : SAMPLE_LINKS) {
            SelenideElement link = sampleLinks.findBy(text(label));
            if (link.exists()) {
                return link;
            }
        }
        return sampleLinks.findBy(visible);
    }
}
