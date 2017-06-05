# XY-Inc

### Olá 
Seja bem vindo ao manual de instruções para execução e testes da aplicação desenvolvida para atender o desafio proposto de cadastro e listagem de pontos de interesse.

Antes de prosseguir, vamos aos pré requisitos. Certifique-se de que seu ambiente já possua o Java e o MAVEN devidamente instalados e configurados.

Se o seu ambiente está preparado, basta fazer uma cópia do projeto que está disponível através do link: [Download Fonte](https://github.com/duartelfelipe/xy-inc/archive/master.zip)

>Para testes sugerimos o uso do plugin POSTMAN com o GOOGLE CHROME

### Intalação, empacotamento e execução

Após ter feito a cópia do projeto, basta acessar via terminal o diretório do mesmo onde encontra-se o arquivo **‘pom.xml’**. Uma vez no diretório, executar os seguintes comandos:

- `mvn clean install` : para limpar e instalar a aplicação
- `mvn package` : para empacotar a aplicação

Em ambos os comando o resultado deve ser **BUILD SUCCESS**. Caso o resultado seja diferente disso, consulte o log do Maven para executar os ajustes necessários ao seu ambiente.


Após o empacotamento, a aplicação já está pronta para ser executada. Certifique­-se de que a porta **8080** não esteja sendo utilizada. Para executar a aplicação, basta acessar o diretório **‘/target’** e executar o comando: `java -­jar xyinc­pi­0.0.1­SNAPSHOT.jar`. Pronto! A aplicação já está no ar!


## Aplicação no ar, vamos em frente...

Nos próximos tópicos, vamos apresentar as funcionalidades que estão disponíveis, bem como a forma de utilizá-­las, explicando como cada uma funciona e para que serve.

### Cadastro de ponto de interesse

Esta funcionalidade permite cadastrar um ponto de interesse através do endereço: `http://localhost:8080/api/poi/cadastrar`

O método que deve ser utilizado é o **_POST_** e o parâmetro esperado deve ser em formato **_JSON_**, onde devem ser informados: o nome do ponto de interesse através do atributo **_‘nome’_**, a coordenada x através do atributo **_‘coordX’_** e a coordenada y através do atributo **_‘coordY’_**.

Exemplo de estrutura de envio:

```JSON
{
"nome":"Minha casa",
"coordX":28,
"coordY":29
}
```

Exemplo POSTMAN
![alt text](https://raw.githubusercontent.com/duartelfelipe/xy-inc/master/documentos/readme-imgs/cadastrar.png)

### Listagem de ponto de interesse por proximidade

Esta funcionalidade retorna uma lista no formato **_JSON_** de pontos de interesse dado um ponto de referência (coordenadas x e y) e uma distância máxima, através do endereço: `http://localhost:8080/api/poi/listar-por-proximidade`. Os parâmetros esperados são: **_x_** (coordenada x), **_y_** (coordenada y) e **_dMax_** (distância máxima para pesquisa de pontos mais próximos).

O chamada deve ser executada utilizando o método **_GET_**.

Exemplo de requisição:
`http://localhost:8080/api/poi/listar-por-proximidade?x=20&y=10&dMax=10`

Exemplo POSTMAN
![alt text](https://raw.githubusercontent.com/duartelfelipe/xy-inc/master/documentos/readme-imgs/listar_proximidade.png)

### Listagem de todos os pontos de interesse

Esta funcionalidade retorna uma lista no formato **_JSON_** de todos os pontos de interesse cadastrados através do endereço: `http://localhost:8080/api/poi/listar`

O chamada deve ser executada utilizando o método **_GET_**.

Exemplo POSTMAN
![alt text](https://raw.githubusercontent.com/duartelfelipe/xy-inc/master/documentos/readme-imgs/listar.png)