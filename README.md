# Universidade Estadual Paulista - UNESP
## Bacharelado em Ciência da Computação – Integral e Noturno
### Sistemas Orientados a Objetos
**Prof. Dr. Frank J. Affonso**

## Trabalho 02

Para o desenvolvimento deste trabalho, os seguintes projetos são fornecidos (EM ANEXO):

- **ArquivoUtils**: Permite salvar/ler o conteúdo de uma String em disco.
- **GsonUtils**: Permite converter um modelo orientado a objetos em String e vice-versa.
- **Modelo e Demo**: Projetos complementares para testar os projetos anteriores.

Veja o grafo de dependência abaixo:

Para executar o projeto Demo é necessário dar um Clean and Build nos projetos anteriores (nessa ordem):

1. Modelo
2. GsonUtils
3. ArquivoUtils
4. Demo

---

## Objetivo do Programa

Faça um programa completo em Java que receba, por exemplo, as seguintes informações:

### -- ENTRADA DE DADOS --

nome da classe: Pessoa <br>
nome do pacote: teste <br>
modificador: private <br>
tipo: String <br>
nome: nome <br>
modificador: private <br>
tipo: int <br>
nome: idade <br>
// Demais atributos

// Demais classes

Em seguida, como forma de avaliar/testar o código gerado, cada grupo poderá inserir o resultado no editor on-line [Planttext](https://www.planttext.com/) para geração do diagrama.

---

## Requisitos Funcionais do Programa

- O programa deve permitir que o usuário crie um projeto (ou seja, uma modelagem inicial) a partir da entrada de dados (veja exemplo acima). Cada grupo deve planejar como a entrada de dados deve ocorrer em seu programa.
- Um projeto deve permitir a modelagem de N classes, sendo que cada classe pode ter Y atributos. As classes podem/devem ser modeladas conforme relacionamentos definidos na Tabela 1. Outros relacionamentos (veja [PlantUML Class Diagram](https://plantuml.com/class-diagram)) também podem ser utilizados (a critério de cada grupo).
- O programa deve permitir que o usuário estabeleça os relacionamentos entre as classes de um projeto (veja Tabela 2).
- O programa deve permitir salvar um projeto em disco. Para isso, elabore uma solução a partir dos projetos fornecidos (ArquivoUtils e GsonUtils).
- O programa deve permitir abrir um projeto existente em disco. Para isso, os projetos fornecidos (ArquivoUtils e GsonUtils) devem ser utilizados.
- O programa deve permitir salvar o código gerado em um arquivo com extensão ".puml".

---

## Requisitos do Programa

O programa deve permitir a modelagem de classes com base nos seguintes relacionamentos:

- **Herança**
- **Composição**
- **Agregação**

### Tabela 1

| Código fonte | Diagrama |
|--------------|----------|
| @startuml    |          |
| Class01 <|-- Class02 | Class03 *-- Class04 |
| Class05 o-- Class06 | @enduml |

Veja mais em [PlantUML Class Diagram](https://plantuml.com/class-diagram).

---

## Tipos de Multiplicidade

O programa deve permitir a modelagem de classes com base nos seguintes tipos de multiplicidade:

### Tabela 2

| TIPOS              | COMBINAÇÕES                |
|--------------------|----------------------------|
| Um para Um         | 1 : 1                      |
| Um para muitos     | 1 : 1..*, 1 : 0..*         |
| Muitos para muitos | * : *, 0..* : 0..*, 1..* : 1..* |

### Exemplos

| Código fonte | Diagrama |
|--------------|----------|
| @startuml    |          |
| Class01 "1" ---> "1" Class02 | Class03 "1" ---> "1..*" Class04 |
| Class05 "1..*" ---> "1..*" Class06 | @enduml |

---

## Instruções para o Desenvolvimento

- Os grupos devem utilizar os projetos fornecidos (ArquivoUtils e GsonUtils).
- Se necessário, os grupos podem implementar adaptações nesses projetos.
- Os grupos podem optar pelo desenvolvimento visual (Java Swing) ou orientado a caracteres (Java em prompt de comando).

## Instrução para Apresentação

- O projeto será apresentado de maneira presencial pelo grupo (Laboratório de Informática).
- Cada grupo terá tempo máximo de 20 minutos para apresentação do programa.

---

## Observações Finais para Postagem do Projeto

- **(-1 pt)** Postar somente o código fonte (Não se esquecer de dar um “Clean” no projeto antes de empacotar o projeto em um arquivo .zip).
- **(-1 pt)** Cada grupo deverá utilizar o nome de projeto conforme exemplos abaixo:
  - IntegralGrupo0X
  - NoturnoGrupo0X
  - Onde X é o número do seu grupo.

Bom trabalho!
