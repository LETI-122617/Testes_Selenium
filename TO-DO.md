# 📋 Ficha 5 – Test Suite 6 (Data Input)

**Aluno:** Francisco Monteiro (110331)  
**Objetivo:** Implementar testes E2E com Selenide + Page Object Model para a secção "Data Input" do Sampler.

---

## 🎫 Ticket 1: Preparação do Ambiente ✅

- [x] Abrir IntelliJ e fazer `git pull` para sincronizar o repositório
- [x] Executar `mvn test` e confirmar **BUILD SUCCESS**

---

## 🎫 Ticket 2: Criar Issue no GitHub ✅

- [x] Ir ao repositório GitHub → **Issues** → **New Issue**
- [x] **Título:** `Implementação do Test Suite 6 (Sampler - Data Input)`
- [x] **Descrição:** `Testes E2E com Selenide e POM para Data Input`
- [x] Anotar o número do Issue: `#_14_`

---

## 🎫 Ticket 3: Criar Branch Local ✅

- [x] No terminal do IntelliJ, executar:
  ```bash
  git checkout -b feature/issue-XX-suite-6-francisco
  ```
  _(substituir XX pelo número do Issue)_

---

## 🎫 Ticket 4: Estrutura de Código ✅

- [x] Em `src/test/java`, criar package: `sampler.datainput`

---

## 🎫 Ticket 5: Page Object – `DataInputPage.java` ✅

- [x] Criar ficheiro `DataInputPage.java` no package `sampler.datainput`:

```java
package sampler.datainput;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;

public class DataInputPage {

    private static final String URL = "https://demo.vaadin.com/sampler/";

    // Seletores
    private SelenideElement menuDataInput = $(byText("Data input"));
    private SelenideElement linkTextField = $(byText("Text field"));
    private SelenideElement inputField = $("input.v-textfield");

    // Métodos
    public void openPage() {
        open(URL);
        if (menuDataInput.exists()) {
            menuDataInput.click();
            linkTextField.click();
        }
    }

    public void typeText(String text) {
        inputField.shouldBe(visible);
        inputField.setValue(text);
    }

    public String getInputValue() {
        return inputField.getValue();
    }
}
```

---

## 🎫 Ticket 6: Classe de Teste – `DataInputTest.java` ✅

- [x] Criar ficheiro `DataInputTest.java` no package `sampler.datainput`:

```java
package sampler.datainput;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataInputTest {

    DataInputPage page;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        page = new DataInputPage();
        page.openPage();
    }

    @Test
    public void testTextFieldInteraction() {
        String textoTeste = "Teste ES 2025";
        page.typeText(textoTeste);
        String valorReal = page.getInputValue();
        assertEquals(textoTeste, valorReal, "O texto no input deve ser igual ao escrito.");
    }
}
```

---

## 🎫 Ticket 7: Executar Testes ✅

- [x] Clicar no ícone ▶️ (Play) em `DataInputTest.java`
- [x] Confirmar que o teste passa (barra verde)

---

## 🎫 Ticket 8: Gerar Relatório Allure ✅

- [x] **Opção A (Terminal):**
  ```bash
  mvn allure:report
  ```
- [ ] **Opção B (IntelliJ Plugin):** Botão direito na pasta `target/allure-results` → Allure → Generate

- [x] Copiar pasta do relatório para `reports/`
- [x] Renomear para: `report_suite_6_datainput_2025-12-27`

---

## 🎫 Ticket 9: Submeter Código

- [ ] Executar no terminal:
  ```bash
  git add .
  git commit -m "Closes #XX: Implementação Test Suite 6 (Data Input)"
  git push origin feature/issue-XX-suite-6-francisco
  ```

---

## 🎫 Ticket 10: Pull Request e Encerrar Issue

- [ ] Ir ao GitHub → **Pull Requests** → **New Pull Request**
- [ ] Selecionar branch `feature/issue-XX-suite-6-francisco` → `main`
- [ ] Criar PR com descrição clara
- [ ] Após merge, **encerrar o Issue** `#XX`

---

## 🎫 Ticket 11: Vídeo de Demonstração (Grupo)

- [ ] Participar na gravação do vídeo (máx. 5 min)
- [ ] Garantir que o vídeo mostra a execução do Test Suite 6
- [ ] Adicionar link do YouTube no topo do `README.md`

---

## ✅ Checklist Final

| Tarefa                         | Estado |
| ------------------------------ | ------ |
| Issue criado                   | ✅     |
| Branch criado                  | ✅     |
| Page Object implementado       | ✅     |
| Teste implementado             | ✅     |
| Teste passa                    | ✅     |
| Relatório Allure gerado        | ✅     |
| Relatório copiado para reports | ✅     |
| Push feito                     | ⬜     |
| Pull Request criado            | ⬜     |
| Issue encerrado                | ⬜     |
| Vídeo gravado                  | ⬜     |
