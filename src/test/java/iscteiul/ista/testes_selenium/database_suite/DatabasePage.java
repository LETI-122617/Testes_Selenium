package iscteiul.ista.testes_selenium.database_suite;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DatabasePage {
    private static final String BASE_URL = "https://www.themoviedb.org";
    private static final String MOVIE_PATH = "/movie/603-the-matrix";
    private static final String SEARCH_URL = BASE_URL + "/search?query=Matrix";

    private final SelenideElement cookieAcceptButton = $("#onetrust-accept-btn-handler");
    private final SelenideElement moviesTab = $("a#movie");
    private final SelenideElement resultLink = $("a.result[href='" + MOVIE_PATH + "']");

    @Step("Open TMDB search page")
    public void openSearchPage() {
        open(SEARCH_URL);
    }

    @Step("Accept cookies if the banner is visible")
    public void acceptCookiesIfPresent() {
        if (cookieAcceptButton.exists()) {
            cookieAcceptButton.shouldBe(visible).click();
        }
    }

    @Step("Switch to Movies tab in search results")
    public void selectMoviesTab() {
        moviesTab.shouldBe(visible).click();
    }

    @Step("Open movie from search results")
    public void openMovieFromResults() {
        resultLink.shouldBe(visible).click();
    }

    @Step("Assert movie title is {expectedTitle}")
    public void assertMovieTitle(String expectedTitle) {
        movieTitleLink().shouldBe(visible).shouldHave(text(expectedTitle));
    }

    @Step("Assert release year is {expectedYear}")
    public void assertReleaseYear(String expectedYear) {
        releaseYear().shouldBe(visible).shouldHave(text(expectedYear));
    }

    private SelenideElement movieTitleLink() {
        return $("h2 a[href='" + MOVIE_PATH + "']");
    }

    private SelenideElement releaseYear() {
        return movieTitleLink().parent().$("span.release_date");
    }
}
