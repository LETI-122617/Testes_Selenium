package iscteiul.ista.testes_selenium;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        open("https://www.jetbrains.com/");
        sleep(3000);

        try {
            executeJavaScript("document.querySelector('.ch2-container')?.remove()");
            System.out.println("✅ Popup removido");
        } catch (Exception e) {
            System.out.println("Popup não encontrado");
        }
        sleep(1000);
    }

    @Test
    public void pageLoads() {
        $("header").shouldBe(visible);
        System.out.println("✅ Página carregou com sucesso!");
    }

    @Test
    public void searchButtonExists() {
        mainPage.searchButton.shouldBe(visible);
        System.out.println("✅ Botão search encontrado!");
    }

    @Test
    public void toolsMenuExists() {
        mainPage.toolsMenu.shouldBe(visible);
        System.out.println("✅ Menu tools encontrado!");
    }
}
