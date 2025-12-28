# 🕵️ Guia para Encontrar Seletores (Vaadin Sampler)

Este guia ajuda-te a encontrar os seletores CSS necessários para o **Ticket 5** (Data Input), conforme instruído na Ficha 5 (focada no uso do _Web Inspector_).

## 1. Aceder ao Site

1.  Abre o teu browser (Chrome recomendado).
2.  Vai a: `https://demo.vaadin.com/sampler/`

## 2. Encontrar a Secção 'Data Input'

O menu lateral pode estar recolhido ou ter um nome ligeiramente diferente.

1.  Olha para a coluna da esquerda ou para a grelha principal.
2.  Procura por **"Data input"** (pode ser um grupo).
    - _Dica:_ Se não vires o texto, procura ícones.
3.  **Para obter o Seletor:**
    - Clica com o botão direito no texto "Data input".
    - Escolhe **Inspect** (Inspecionar).
    - No painel que abre, vê se é um `<span>`, `<div>` ou `<td>`.
    - Procura um texto único ou uma classe (ex: `v-tree-node-caption`).
    - _Nota:_ O seletor `$(byText("Data input"))` geralmente funciona se o texto for exatamente esse.

## 3. Encontrar a Opção 'Text Field'

1.  Depois de clicares em "Data input", deve expandir uma lista ou mostrar ícones.
2.  Clica em **"Text field"** (Texto simples).
3.  **Para obter o Seletor:**
    - Clica com o botão direito em "Text field".
    - Escolhe **Inspect**.
    - Verifica o HTML. Se for um texto clicável, `$(byText("Text field"))` deve funcionar.

## 4. Encontrar o Campo de Input

Esta é a parte crucial para o teu teste (`typeText`).

1.  Na página do "Text field", verás um exemplo de formulário.
2.  Clica com o botão direito na caixa de texto onde podes escrever.
3.  Escolhe **Inspect**.
4.  Copia a **Class** ou **ID**.
    - Geralmente em Vaadin, os inputs têm classes como `v-textfield`.
    - Confirma se é `<input class="v-textfield" ...>`.
    - Se for, o seletor `$("input.v-textfield")` está correto.

---

## ✅ Resumo para o teu Código

Se confirmares estes passos, o código poderá ser mantido ou ajustado:

- **Menu:** `$(byText("Data input"))` -> Se o texto for exatamente "Data input".
- **Sub-menu:** `$(byText("Text field"))` -> Se o texto for exatamente "Text field".
- **Input:** `$("input.v-textfield")` -> Se a classe do input for `v-textfield`.

**Se os nomes forem diferentes (ex: maiúsculas/minúsculas), tens de alterar o código Java para igualar o que vês no site (Inspecionar).**
