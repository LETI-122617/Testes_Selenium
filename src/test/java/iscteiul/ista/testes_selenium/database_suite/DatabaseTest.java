package iscteiul.ista.testes_selenium.database_suite;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import iscteiul.ista.testes_selenium.support.BaseSelenideTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseTest extends BaseSelenideTest {

    private DatabasePage page;

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void init() {
        page = new DatabasePage();
        page.openSearchPage();
        page.acceptCookiesIfPresent();
        page.selectMoviesTab();
    }

    @Test
    @Description("Search for a movie and validate its title and release year.")
    public void testMovieInfoFromSearch() {
        page.openMovieFromResults();
        page.assertMovieTitle("Matrix");
        page.assertReleaseYear("1999");
    }
}
