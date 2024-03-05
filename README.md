# StudyFlow

API do projeto StudyFlow = Sistema de gestão de estudos

## Requisitos

- [ ] CRUD de Matérias
- [ ] CRUD de Professores
- [ ] CRUD de Lições de casa
- [ ] CRUD de Calendário
- [ ] CRUD de Usuários
- [ ] Autenticação
- [ ] Dashboard
- [ ] Buscar Matérias

## Documentação

### Endpoints

- [Listar Matérias](#listar-materias)
- [Cadastrar Matéria](#cadastrar-materia)
- [Detalhes da Matéria](#detalhe-materia)
- [Apagar Matéria](#apagar-materia)
- [Atualizar Matéria](#atualizar-materia)

### Listar Matérias

`GET` /materia

Retorna um array com todas as matérias cadastradas.

### Exemplo de Resposta

```js
[
  {
    id: 1,
    nome: "Java Advanced",
    icone: "Java",
  },
  {
    id: 2,
    nome: "Computational Thinking using Python",
    icone: "Python",
  },
];
```

#### Código de Status

| código | descricao                                                 |
| ------ | --------------------------------------------------------- |
| 200    | Matérias retornadas com sucesso                           |
| 401    | Usuário não autenticado. Realize a autenticação em /login |

---

### Cadastrar Matéria

`POST` /materia

Cadastrar uma nova matéria para o usuário logado com os dados
enviados no corpo da requisição.

#### Corpo da Requisição

| campos | tipo   | obrigatório | descrição                               |
| ------ | ------ | :---------: | --------------------------------------- |
| nome   | string |     ✅      | Um nome curto para a matéria           |
| icone  | string |     ❌      | O nome do ícone conforme Material Icons |

```js
{
    "nome": "Java Advanced",
    "icone": "java"
}
```

### Exemplo de Resposta

```js

{
    "id": 1,
    "nome": "Java Advanced",
    "icone": "java"
},

```

#### Código de Status

| código | descricao                                                        |
| ------ | ---------------------------------------------------------------- |
| 200    | Matéria cadastrada com sucesso                                   |
| 400    | Validação falhou. Verifique as regras para o corpo da requisição |
| 401    | Usuário não autenticado. Realize a autenticação em /login        |

---

### Detalhes da Matéria

`GET` /materia/`{id}`

Retorna os dados detalhados da matéria com o `id` informado no
parâmetro de path.

### Exemplo de Resposta

```js
// requisição para /materia/1
{
    "id": 1,
    "nome": "Java Advanced",
    "icone": "java"
},

```

#### Código de Status

| código | descricao                                                      |
| ------ | -------------------------------------------------------------- |
| 200    | Dados da matéria retornados com sucesso                      |
| 401    | Usuário não autenticado. Realize a autenticação em /login      |
| 404    | Não existe matéria com o `id` informado. Consulte lista em / |

---

### Apagar Matéria

`DELETE` /materia/`{id}`

Apaga a matéria indicada pelo `id` enviado no parâmetro de path.

#### Código de Status

| código | descricao                                                      |
| ------ | -------------------------------------------------------------- |
| 200    | Matéria apagada com sucesso                                  |
| 401    | Usuário não autenticado. Realize a autenticação em /login      |
| 404    | Não existe matéria com o `id` informado. Consulte lista em / |

---

### Atualizar Matéria

`PUT` /materia/`{id}`

Atualizar os dados da matéria com o `id` informado no path,
utilizando os novos dados enviados no corpo da requisição

#### Corpo da Requisição

| campos | tipo   | obrigatório | descrição                               |
| ------ | ------ | :---------: | --------------------------------------- |
| nome   | string |     ✅      | Um nome curto para a matéria          |
| icone  | string |     ✅      | O nome do ícone conforme Material Icons |

```js
{
    "nome": "Java-Advanced",
    "icone": "java"
}
```

### Exemplo de Resposta

```js

{
    "id": 1,
    "nome": "Java-Advanced",
    "icone": "java"
},

```

#### Código de Status

| código | descricao                                                        |
| ------ | ---------------------------------------------------------------- |
| 200    | Matéria atualizada com sucesso                                 |
| 400    | Validação falhou. Verifique as regras para o corpo da requisição |
| 401    | Usuário não autenticado. Realize autenticação em /login          |
| 404    | Não existe matéria com o `id` informado. Consulte lista em /   |

