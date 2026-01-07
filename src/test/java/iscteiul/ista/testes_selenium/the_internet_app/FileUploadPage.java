package iscteiul.ista.testes_selenium.the_internet_app;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.text;

public class FileUploadPage {
    private static final String URL = "https://the-internet.herokuapp.com/upload";

    // Localizadores
    // O input do tipo 'file' é onde "enfiamos" o ficheiro
    private final SelenideElement fileInput = $("#file-upload");

    // O botão para submeter
    private final SelenideElement uploadButton = $("#file-submit");

    // A área onde aparece o nome do ficheiro após sucesso
    private final SelenideElement uploadedFilesList = $("#uploaded-files");

    // O título de sucesso (opcional, mas bom para validar)
    private final SelenideElement successHeader = $("div.example h3");

    @Step("Open file upload page")
    public void openPage() {
        open(URL);
    }

    @Step("Upload file")
    public void uploadFile(File file) {
        // O Selenide trata da magia de interagir com o input hidden/system dialog
        fileInput.uploadFile(file);
    }

    @Step("Submit upload")
    public void clickUpload() {
        uploadButton.click();
    }

    @Step("Read uploaded file name")
    public String getUploadedFileName() {
        return uploadedFilesList.getText().trim();
    }

    @Step("Read success message")
    public String getSuccessMessage() {
        successHeader.shouldHave(text("File Uploaded!"));
        return successHeader.getText().trim();
    }
}
