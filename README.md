# 🎓 Plataforma de Cursos Comunitários

## 👤 Dados do Aluno

| **Nome** | Adriane Tranhaqui |

| **Tema** | Plataforma de Cursos Comunitários |

| **GitHub** | https://github.com/AdrianeTranhaqui/Trabalho_individual_API_Restful |

---

## 📋 Descrição do Projeto

API RESTful desenvolvida com Java e Spring Boot para gerenciamento de uma **Plataforma de Cursos Comunitários**. O sistema permite o cadastro e gerenciamento de alunos, professores, cursos e matrículas, com controle de perfil social dos alunos, aplicando boas práticas de desenvolvimento backend com arquitetura em camadas.

---

## 📁 Estrutura de Pacotes

```
src/main/java/org/serratec/cursos/
├── 📦 Controller/        → Recebe requisições HTTP e delega ao Service
├── 📦 Service/           → Contém a lógica de negócio da aplicação
├── 📦 Repository/        → Comunicação com o banco de dados via JPA
├── 📦 Domain/            → Mapeamento das tabelas do banco (JPA Entities)
├── 📦 dto/
│   ├── Request/          → Objetos de entrada com validações
│   └── Response/         → Objetos de saída retornados ao cliente
├── 📦 Enum/              → Enumerações (ex: Escolaridade)
├── 📦 Exception/         → Exceções customizadas e handler global
└── 📦 Config/            → Configurações gerais (Swagger)
```

---

## 🔗 Relacionamentos JPA

| Tipo | Entidades | Annotation |
|------|-----------|------------|
| `@OneToOne` | Aluno ↔ PerfilSocial | `@OneToOne` / `@JoinColumn` |
| `@OneToMany` / `@ManyToOne` | Professor → Cursos | `@OneToMany` / `@ManyToOne` |
| `@OneToMany` / `@ManyToOne` | Aluno/Curso ↔ Matricula | `@OneToMany` / `@ManyToOne` |

---

## ▶️ Como Executar

### Pré-requisitos
- Java 17+
- Maven
- PostgreSQL rodando na porta 5432

### 1. Clonar o repositório
```bash
git clone https://github.com/AdrianeTranhaqui/Trabalho_individual_API_Restful.git
```

### 2. Criar o banco de dados
```sql
CREATE DATABASE cursos;
```

### 3. Configurar o application.properties
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/cursos
spring.datasource.username=postgres
spring.datasource.password=sua_senha
```

### 4. Rodar o projeto
```bash
mvn spring-boot:run
```

### 5. Acessar o Swagger
```
http://localhost:8080/swagger-ui.html
```

---

## 📡 Exemplos de Endpoints

### 👤 Alunos `/alunos`
| Método | URL | Descrição |
|--------|-----|-----------|
| GET | `/alunos` | Listar todos os alunos |
| GET | `/alunos/{id}` | Buscar aluno por ID |
| POST | `/alunos` | Cadastrar novo aluno |
| PUT | `/alunos/{id}` | Atualizar aluno |
| DELETE | `/alunos/{id}` | Remover aluno |

**POST `/alunos` — Body:**
```json
{
  "nome": "Maria da Silva",
  "email": "maria@email.com",
  "telefone": "(21) 99999-9999",
  "dataNascimento": "2000-05-15"
}
```

**Resposta (201 Created):**
```json
{
  "id": 1,
  "nome": "Maria da Silva",
  "email": "maria@email.com",
  "telefone": "(21) 99999-9999",
  "dataNascimento": "2000-05-15",
  "createdAt": "2026-05-21"
}
```

---

### 👨‍🏫 Professores `/professores`
| Método | URL | Descrição |
|--------|-----|-----------|
| GET | `/professores` | Listar todos os professores |
| GET | `/professores/{id}` | Buscar professor por ID |
| POST | `/professores` | Cadastrar novo professor |
| PUT | `/professores/{id}` | Atualizar professor |
| DELETE | `/professores/{id}` | Remover professor |

**POST `/professores` — Body:**
```json
{
  "nome": "Carlos Souza",
  "email": "carlos@email.com",
  "especialidade": "Desenvolvimento Web",
  "telefone": "(21) 98888-7777"
}
```

---

### 📚 Cursos `/cursos`
| Método | URL | Descrição |
|--------|-----|-----------|
| GET | `/cursos` | Listar todos os cursos |
| GET | `/cursos/{id}` | Buscar curso por ID |
| POST | `/cursos` | Cadastrar novo curso |
| PUT | `/cursos/{id}` | Atualizar curso |
| DELETE | `/cursos/{id}` | Remover curso |

**POST `/cursos` — Body:**
```json
{
  "nome": "Java para Iniciantes",
  "descricao": "Curso introdutório de Java",
  "cargaHoraria": 40,
  "dataInicio": "2026-06-01",
  "dataFim": "2026-08-01",
  "preco": 99.90,
  "professorId": 1
}
```

---

### 📝 Matrículas `/matriculas`
| Método | URL | Descrição |
|--------|-----|-----------|
| GET | `/matriculas` | Listar todas as matrículas |
| GET | `/matriculas/{id}` | Buscar matrícula por ID |
| POST | `/matriculas` | Criar matrícula |
| PUT | `/matriculas/{id}` | Atualizar matrícula |
| DELETE | `/matriculas/{id}` | Cancelar matrícula |

**POST `/matriculas` — Body:**
```json
{
  "alunoId": 1,
  "cursoId": 1,
  "status": "ATIVA"
}
```

---

### 🪪 Perfis Sociais `/perfis-sociais`
| Método | URL | Descrição |
|--------|-----|-----------|
| GET | `/perfis-sociais` | Listar todos os perfis |
| GET | `/perfis-sociais/{id}` | Buscar perfil por ID |
| POST | `/perfis-sociais` | Criar perfil social |
| PUT | `/perfis-sociais/{id}` | Atualizar perfil |
| DELETE | `/perfis-sociais/{id}` | Remover perfil |

**POST `/perfis-sociais` — Body:**
```json
{
  "rendaFamiliar": "Até 2 salários mínimos",
  "escolaridade": "Ensino_Medio_Completo",
  "alunoId": 1
}
```

---

## ⚠️ Tratamento de Erros

| Status | Situação | Exemplo |
|--------|----------|---------|
| 400 | Dados inválidos | Campo obrigatório não preenchido |
| 404 | Recurso não encontrado | Aluno com id inexistente |
| 409 | Conflito | E-mail já cadastrado |
| 500 | Erro interno | Erro inesperado no servidor |

**Exemplo de resposta de erro:**
```json
{
  "timestamp": "2026-05-21T01:01:10",
  "status": 409,
  "error": "Conflict",
  "message": "Já existe um professor cadastrado com o e-mail: carlos@email.com",
  "details": null
}
```

---

## ✅ Validações Implementadas

| Annotation | Uso |
|------------|-----|
| `@NotBlank` | Campos de texto obrigatórios |
| `@NotNull` | Campos obrigatórios (IDs, Enums) |
| `@Email` | Validação de formato de e-mail |
| `@Pattern` | Validação de telefone com regex |
| `@Size` | Tamanho mínimo e máximo de strings |
| `@Positive` | Valores numéricos positivos |
| `@Past` | Datas no passado |

---

## 🎯 Diferenciais do Projeto

- ✅ Enum `Escolaridade` para controle de valores válidos
- ✅ `@JsonPropertyOrder` para ordenação dos campos no JSON
- ✅ `createdAt` com `@PrePersist` para auditoria de registros
- ✅ Verificação de duplicidade de e-mail e matrícula
- ✅ Respostas padronizadas de erro com timestamp
