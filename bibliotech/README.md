# BiblioTech

O BiblioTech é um sistema para organizar o acervo e os empréstimos da biblioteca do campus. A bibliotecária precisa controlar os livros disponíveis e saber quem está com cada exemplar, enquanto os leitores precisam consultar a disponibilidade dos livros sem precisar ir até o balcão.

## 1. O projeto

O BiblioTech é um sistema de gerenciamento de livros e empréstimos para uma biblioteca do campus.

O sistema permite cadastrar livros e leitores, consultar a disponibilidade dos livros, registrar empréstimos e registrar devoluções.

O projeto foi desenvolvido de forma iterativa e incremental, com a implementação das funcionalidades sendo realizada por etapas.

## 2. Histórias de usuário

| # | História de usuário |
|---|---|
| HU01 | Como leitor, quero consultar a disponibilidade de um livro, para saber se posso pegá-lo emprestado sem ir até o balcão. |
| HU02 | Como leitor, quero devolver um livro, para não ficar com pendência na biblioteca. |
| HU03 | Como bibliotecária, quero registrar um empréstimo, para saber quem está com cada exemplar. |
| HU04 | Como bibliotecária, quero cadastrar um livro novo, para que ele possa ser encontrado no sistema. |
| HU05 | Como bibliotecária, quero ver os empréstimos atrasados, para cobrar a devolução. |
| HU06 | Como leitor, quero reservar um livro que está emprestado, para ser o próximo a retirá-lo quando ele voltar. |

## 3. Requisitos

### 3.1 Requisitos funcionais

| # | Requisito funcional | Veio da | Situação |
|---|---|---|---|
| RF01 | O sistema deve permitir que a bibliotecária cadastre um livro no acervo. | HU04 | Implementado |
| RF02 | O sistema deve permitir que a bibliotecária cadastre um leitor. | Regra de acesso: só quem tem cadastro leva livro | Implementado |
| RF03 | O sistema deve permitir que o leitor consulte a disponibilidade de um livro. | HU01 | Implementado |
| RF04 | O sistema deve permitir que a bibliotecária registre a devolução de um livro. | HU02 | Implementado |
| RF05 | O sistema deve permitir que a bibliotecária registre um empréstimo. | HU03 | Implementado |
| RF06 | O sistema deve listar os empréstimos atrasados. | HU05 | Ainda não implementado |
| RF07 | O sistema deve calcular a data de devolução do empréstimo. | Escopo do projeto | Implementado |

### 3.2 Requisitos não funcionais

| # | Requisito não funcional |
|---|---|
| RNF01 | A consulta de disponibilidade deve responder em menos de três segundos. |
| RNF02 | Somente o perfil de bibliotecário pode alterar o acervo. |
| RNF03 | O sistema deve funcionar no navegador, tanto no computador do balcão quanto no celular do leitor. |

## 4. Diagramas

### 4.1 Diagrama de casos de uso

![Diagrama de casos de uso](diagramas/casos-de-uso.png)

### 4.2 Diagrama de classes

![Diagrama de classes](diagramas/classes.png)

### 4.3 Relacionamento entre Bibliotecário e Empréstimo

![Relacionamento entre Bibliotecário e Empréstimo](diagramas/decisao-bibliotecario-emprestimo.png)

### 4.4 Modelo de classes

~~~mermaid
classDiagram
    Usuario <|-- Leitor
    Usuario <|-- Bibliotecario

    Biblioteca "1" --> "*" Livro
    Biblioteca "1" --> "*" Leitor
    Biblioteca "1" --> "*" Emprestimo

    Emprestimo "*" --> "1" Livro
    Emprestimo "*" --> "1" Leitor
    Emprestimo "*" --> "1" Bibliotecario
~~~

## 5. Estrutura do projeto

| Arquivo | Função |
|---|---|
| `Livro.java` | Representa os livros do acervo e controla sua disponibilidade. |
| `Usuario.java` | Classe base dos usuários do sistema. |
| `Leitor.java` | Representa os leitores e controla a quantidade de livros que possuem emprestados. |
| `Bibliotecario.java` | Representa o bibliotecário do sistema. |
| `Emprestimo.java` | Representa um empréstimo, controla sua realização, devolução e calcula a data prevista de devolução. |
| `Biblioteca.java` | Mantém os livros, leitores e empréstimos e coordena as operações do sistema. |
| `TelaBiblioteca.java` | Interface gráfica do sistema. |
| `TesteEmprestimo.java` | Realiza testes das operações de empréstimo e devolução. |
| `TesteBiblioteca.java` | Realiza testes das operações da biblioteca. |
| `TesteRequisitos.java` | Verifica automaticamente os requisitos funcionais RF01 a RF05. |

## 6. Como executar

### 6.1 Compilação

Entre na pasta `bibliotech` e execute:

~~~bash
javac *.java
~~~

Se não aparecer nenhuma mensagem de erro, a compilação foi realizada corretamente.

### 6.2 Teste da Biblioteca

Execute:

~~~bash
java TesteBiblioteca
~~~

Esse teste verifica as principais operações da classe `Biblioteca`, incluindo cadastro, busca, empréstimos e devoluções.

### 6.3 Teste dos requisitos

Execute:

~~~bash
java TesteRequisitos
~~~

O teste verifica automaticamente os requisitos funcionais RF01, RF02, RF03, RF04 e RF05.

O resultado atual é:

~~~text
12 passaram, 0 falharam.
~~~

### 6.4 Interface gráfica

Execute:

~~~bash
java TelaBiblioteca
~~~

A interface gráfica permite realizar empréstimos e devoluções e atualizar a situação dos livros no acervo.

## 7. Rastreabilidade dos requisitos

| Requisito | Origem | Implementação | Verificação |
|---|---|---|---|
| RF01 | HU04 | `Biblioteca` / `Livro` | `TesteRequisitos` |
| RF02 | Regra de acesso | `Biblioteca` / `Leitor` | `TesteRequisitos` |
| RF03 | HU01 | `Biblioteca` / `Livro` | `TesteRequisitos` |
| RF04 | HU02 | `Biblioteca` / `Emprestimo` | `TesteRequisitos` |
| RF05 | HU03 | `Biblioteca` / `Emprestimo` | `TesteRequisitos` |
| RF06 | HU05 | Ainda não implementado | Ainda não verificado |
| RF07 | Escopo do projeto | `Emprestimo` | Data prevista calculada para 7 dias |

## 8. Verificação dos requisitos

O arquivo `TesteRequisitos.java` realiza verificações automáticas dos requisitos funcionais RF01 a RF05.

| Requisito | Verificação |
|---|---|
| RF01 | Verifica se um livro cadastrado aparece na busca. |
| RF02 | Verifica se um leitor cadastrado aparece na busca. |
| RF03 | Verifica se um livro novo está disponível e se um título inexistente não é encontrado. |
| RF04 | Verifica se uma devolução de empréstimo ativo é aceita, se o livro volta a ficar disponível e se uma segunda devolução é recusada. |
| RF05 | Verifica se um empréstimo de livro disponível é aceito, se o livro fica indisponível, se o leitor passa a ter um livro em mãos e se empréstimos que não podem ser realizados são recusados. |
| RF07 | O `Emprestimo` calcula a data prevista de devolução como 7 dias após a data de retirada. |

### Resultado da verificação

~~~text
12 passaram, 0 falharam.
~~~

## 9. O que ainda não faz

Nesta etapa, o sistema ainda não implementa todas as funcionalidades previstas no levantamento de requisitos.

| Funcionalidade | Situação |
|---|---|
| Cadastro de livros | Implementado |
| Cadastro de leitores | Implementado |
| Consulta de disponibilidade | Implementado |
| Registro de empréstimos | Implementado |
| Registro de devoluções | Implementado |
| Cálculo da data prevista de devolução em 7 dias | Implementado |
| Listagem de empréstimos atrasados | Ainda não implementado |
| Reserva de livros | Ainda não implementado |
| Persistência dos dados em banco de dados | Ainda não implementado |
| Sistema de login e autenticação de usuários | Ainda não implementado |

As funcionalidades que ainda não foram implementadas ficam registradas para possíveis evoluções futuras do sistema.

## 10. Uso de ferramentas

| Ferramenta | Utilização |
|---|---|
| Java | Desenvolvimento do sistema. |
| Visual Studio Code | Edição dos arquivos do projeto. |
| GitHub Codespaces | Ambiente de desenvolvimento. |
| Git | Controle de versão do projeto. |
| GitHub | Armazenamento e entrega do repositório. |
| draw.io | Criação dos diagramas do sistema. |
| ChatGPT | Apoio na organização das verificações dos requisitos, esclarecimento de dúvidas sobre a implementação e documentação do projeto. |