# employeeApi

Criei esta api no intuito de começar meus estudos com springboot, e, para dizer a verdade, acabei gostando bastante.

## Documentação

Apesar de ser uma aplicação simples, vou escrever uma documentação, também simples, para ajudar no entendimento.

- **Base URL**: localhost:8080/employee

## Endpoints

### getEmployee
Retorna todas as informações salvas no banco de dados, de acordo com o parâmetro passado pela query na URL.

- **URL**: `/employee/{name}`
- **Método**: GET
- **Parâmetros de consulta**:
  - `name`: Nome do 'employee' a ser consultado no banco de dados.
- **Exemplo de Requisição**:

  ```bash
  curl -X GET localhost:8080/employee/Joao
  
### createEmployee
Retorna todas as informações salvas no banco de dados, de acordo com o parâmetro passado pela query na URL.

- **URL**: /employee
- **Método**: POST
- **Formato dos dados**: JSON
- **Parâmetros do corpo**:
  - `name`: Nome do 'employee' a ser criado.
  - `age`: Idade do 'employee' a ser criado.
  - `office`: Cargo do 'employee' a ser criado.
  - `wage`: Salario do 'employee' a ser criado.

- **Exemplo de Requisição**:

  ```bash
  curl -X POST -H "Content-Type: application/json" -d '{"name": "Joao", "age": 21, "office": "tech lead", "wage": "5000."}' localhost:8080/employee
