package iscteiul.ista.testes_selenium.the_internet_app;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileUploadTest {

    FileUploadPage page = new FileUploadPage();

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void init() {
        page.openPage();
    }

    @Test
    public void testFileUpload(@TempDir Path tempDir) throws IOException {
        // 1. Preparação: Criar um ficheiro falso para teste
        String fileName = "teste_upload.txt";
        Path filePath = tempDir.resolve(fileName);
        Files.write(filePath, List.of("Este é um ficheiro de teste para Selenium."));
        File fileToUpload = filePath.toFile();

        // 2. Ação: Fazer o upload
        page.uploadFile(fileToUpload);
        page.clickUpload();

        // 3. Validação
        // Verifica se o título diz "File Uploaded!"
        assertEquals("File Uploaded!", page.getSuccessMessage());

        // Verifica se o nome do ficheiro apresentado é o mesmo que enviámos
        assertEquals(fileName, page.getUploadedFileName());
    }
}