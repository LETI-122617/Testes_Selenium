# Engenharia de Software - Ficha Laboratorial 5
## Testes de Aceitação com Selenium

### Identificação do Grupo
* **Nome:** Tomás Cerveira | **Número:** 122617
* **Nome:** Eduardo Real | **Número:** 122608
* **Nome:** Francisco Monteiro | **Número:** 110331

**Vídeo YouTube:** https://youtu.be/0olt9KwNcso

---

### Relatórios Allure

Os relatórios Allure estão disponíveis na pasta `reports/`:

| Relatório | Descrição | 
|-----------|-----------|
| `allure-report-basic-features/` | Suite 8 - Sampler Basic Features |
| `relatorio-form-suite-LETI-122617/` | Suite 4 - Form Community |
| `report_suite_6/` | Suite 6 - Sampler Data Input |
`allure-report-final/` | Relatório consolidado com **todas as 8 suites** (17 testes) |

> **Nota:** O `allure-report-final` contém os resultados agregados de todas as suites executadas, incluindo Suites 1-8.

Para abrir um relatório localmente:
```bash
open reports/allure-report-final/index.html
```

---

### Testes Implementados

Foram implementadas **8 suites de teste** com **Selenide + Allure**:

| Suite | Descrição | Classe de Teste | Status |
|-------|-----------|-----------------|--------|
| Suite 1 | Bookstore - Adicionar Produto | `Bookstore.AddProductTest` | ✅ Pass |
| Suite 2 | Bookstore - Adicionar Categoria | `Bookstore.AddCategoryTest` | ✅ Pass |
| Suite 3 | Database - Informação de Filme | `database_suite.DatabaseTest` | ✅ Pass |
| Suite 4 | Form - Comunidade | `form_suite.CommunityTest` | ✅ Pass |
| Suite 5 | Sampler - Interaction | `Sampler.Interaction.InteractionTest` | ✅ Pass |
| Suite 6 | Sampler - Data Input | `Sampler.datainput.DataInputTest` | ✅ Pass |
| Suite 7 | Sampler - Data Presentation | `Sampler.DataPresentation.DataPresentationTest` | ✅ Pass |
| Suite 8 | Sampler - Basic Features | `Sampler.BasicFeatures.BasicFeaturesTest` | ✅ Pass |

**Resultado Final:** 19 testes executados, **100% success rate** ✅

#### Testes Auxiliares

Além das 8 suites obrigatórias, foram implementados **4 testes auxiliares**. Estes testes foram criados durante o desenvolvimento para **validar o ambiente de testes** e **diagnosticar problemas** antes de implementar as suites principais:

| Classe | Descrição | Propósito |
|--------|-----------|-----------|
| `MainPageTest` | Testes na página JetBrains | Validar navegação, menus e cookie handling |
| `DynamicContentTest` | Conteúdo dinâmico | Testar páginas com conteúdo que muda |
| `CheckboxesTest` | Interação com checkboxes | Validar inputs booleanos |
| `FileUploadTest` | Upload de ficheiros | Testar funcionalidade de upload |

> **Nota:** O Allure mostra **12 suites** porque conta cada classe de teste como uma suite separada (8 obrigatórias + 4 auxiliares).

### Ordem de Execução dos Testes

> ⚠️ **Nota:** O Maven Surefire Plugin **não garante a ordem de execução**. A ordem observada pode variar entre execuções.

Ao executar `mvn test`, os testes são tipicamente executados por ordem alfabética de package/classe:

| # | Classe de Teste | Suite | Nº Testes | Tempo |
|---|-----------------|-------|-----------|-------|
| 1 | `MainPageTest` | - (auxiliar) | 3 | ~4.2s |
| 2 | `DynamicContentTest` | - (auxiliar) | 1 | ~2.0s |
| 3 | `CheckboxesTest` | - (auxiliar) | 1 | ~0.3s |
| 4 | `FileUploadTest` | - (auxiliar) | 1 | ~0.7s |
| 5 | `DatabaseTest` | **Suite 3** | 1 | ~4.1s |
| 6 | `CommunityTest` | **Suite 4** | 1 | ~1.0s |
| 7 | `AddCategoryTest` | **Suite 2** | 1 | ~0.5s |
| 8 | `AddProductTest` | **Suite 1** | 1 | ~0.5s |
| 9 | `DataInputTest` | **Suite 6** | 1 | ~2.9s |
| 10 | `BasicFeaturesTest` | **Suite 8** | 6 | ~0.6s |
| 11 | `DataPresentationTest` | **Suite 7** | 1 | ~3.7s |
| 12 | `InteractionTest` | **Suite 5** | 1 | ~1.8s |

**Total:** 19 testes • ~25 segundos

> **Porquê esta ordem?**  
> O Maven Surefire ordena os testes pelo **nome completo da classe** (package + classe) em ordem alfabética:
> 1. `iscteiul.ista.testes_selenium.*` vem primeiro (package mais longo)
> 2. Dentro do package, `MainPageTest` vem antes de `the_internet_app.*`
> 3. `Bookstore.*` e `Sampler.*` vêm depois (packages mais curtos, ordem alfabética)

---

### Como Executar os Testes

> **📁 Estrutura Allure:**  
> - `target/allure-results/` → Dados brutos (JSONs gerados pelo `mvn test`)  
> - `reports/allure-report-*/` → Relatório HTML (gerado pelo `allure generate`)

```bash
# Executar todos os testes
mvn clean test

# Executar suite específica
mvn -Dtest=<NomeClasse> test
```

**Comandos por Suite:**
| Suite | Comando |
|-------|---------|
| 1 | `mvn -Dtest=Bookstore.AddProductTest test` |
| 2 | `mvn -Dtest=Bookstore.AddCategoryTest test` |
| 3 | `mvn -Dtest=iscteiul.ista.testes_selenium.database_suite.DatabaseTest test` |
| 4 | `mvn -Dtest=iscteiul.ista.testes_selenium.form_suite.CommunityTest test` |
| 5 | `mvn -Dtest=Sampler.Interaction.InteractionTest test` |
| 6 | `mvn -Dtest=Sampler.datainput.DataInputTest test` |
| 7 | `mvn -Dtest=Sampler.DataPresentation.DataPresentationTest test` |
| 8 | `mvn -Dtest=Sampler.BasicFeatures.BasicFeaturesTest test` |

#### Visualizar Relatório Allure

**Opção 1: Maven Plugin** (recomendado se já tens Maven configurado)
```bash
mvn allure:serve
```

**Opção 2: NPX** (recomendado se não tens o plugin Maven)
```bash
npx allure-commandline serve target/allure-results
```

**Opção 3: Gerar relatório estático**
```bash
# Gerar HTML para pasta específica
npx allure-commandline generate target/allure-results -o reports/allure-report --clean

# Abrir o relatório gerado (requer servidor HTTP)
npx allure-commandline open reports/allure-report
```

> **Quando usar cada:**
> - `mvn allure:serve` → Mais simples, usa o plugin já configurado no `pom.xml`
> - `npx allure-commandline serve` → Útil se não tens o plugin Maven ou queres usar fora do projeto
> - `allure generate` → Quando precisas de um relatório HTML permanente para partilhar

---

### Tecnologias Utilizadas
- **Selenide** 7.6.0 - Framework de testes E2E
- **Allure** - Relatórios de teste
- **JUnit 5** - Framework de testes
- **Maven** - Gestão de dependências