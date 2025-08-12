# 📚 Biblioteca

Sistema simples para controle de empréstimos de livros.  
Desenvolvido em **Java** com **Spring Boot**, **Lombok** e **Flyway** para gerenciamento de migrations do banco de dados.

---

## 🚀 Tecnologias utilizadas
- **Java 17+**
- **Spring Boot**
- **Lombok** (redução de código boilerplate)
- **Flyway** (controle de migrations)
- **MySql** (banco de dados)
- **Maven** (gerenciador de dependências)

---

## 🗂 Estrutura do Banco de Dados

O projeto utiliza **3 tabelas principais**:

### 1. Pessoa
| Campo        | Tipo        | Descrição             |
|--------------|------------|-----------------------|
| `pessoa_id`  | BIGINT PK  | Identificador único   |
| `nome`       | VARCHAR    | Nome completo         |
| `email`      | VARCHAR    | E-mail da pessoa      |

### 2. Livro
| Campo         | Tipo        | Descrição             |
|---------------|------------|-----------------------|
| `livro_id`    | BIGINT PK  | Identificador único   |
| `titulo`      | VARCHAR    | Título do livro       |
| `autor`       | VARCHAR    | Autor do livro        |
| `ano_publicacao` | INT     | Ano de publicação     |

### 3. Emprestimo
| Campo           | Tipo        | Descrição                          |
|-----------------|------------|------------------------------------|
| `emprestimo_id` | BIGINT PK  | Identificador único                |
| `pessoa_id`     | BIGINT FK  | Pessoa que fez o empréstimo        |
| `livro_id`      | BIGINT FK  | Livro emprestado                   |
| `data_emprestimo` | DATE     | Data do empréstimo                 |
| `data_devolucao` | DATE NULL | Data de devolução (se já devolvido) |

