# HeatWatch — Monitoramento de Calor e Energia

##  Sobre o projeto

O HeatWatch é um sistema desenvolvido para monitorar temperaturas, consumo de energia e possíveis sobrecargas elétricas em diferentes regiões.

O objetivo é identificar situações de risco por meio de sensores simulados, registros de medições, previsões e geração de alertas.

##  Objetivo

Desenvolver uma solução utilizando Programação Orientada a Objetos para auxiliar no monitoramento territorial e na identificação de possíveis riscos relacionados ao calor intenso e à sobrecarga elétrica.

##  Funcionalidades

- Registro de temperatura.
- Registro de consumo de energia.
- Registro de sobrecarga elétrica.
- Consulta de medições.
- Consulta de alertas.
- Consulta de medições por tipo de sensor.
- Geração de previsões.
- Classificação de alertas em ATENÇÃO, ALERTA e CRÍTICO.
- Armazenamento de dados em banco de dados.

##  Tecnologias utilizadas

- Java 17
- Spring Boot
- Maven
- Spring Data JPA
- H2 Database
- JUnit
- Mockito
- Visual Studio Code

##  Conceitos de Programação Orientada a Objetos

- **Abstração:** utilização de classes abstratas.
- **Herança:** classes que herdam características de outras classes.
- **Polimorfismo:** diferentes implementações de sensores e estratégias de previsão.
- **Encapsulamento:** proteção dos atributos da classe DadosTerritorio.
- **Interfaces:** utilização da interface Sensor.
- **Tratamento de exceções:** criação de exceções personalizadas.
- **Factory:** padrão utilizado para criar alertas conforme os dados recebidos.


## Testes

Para executar os testes automatizados, utilize:

```bash
.\mvnw.cmd test
```

O projeto utiliza JUnit e Mockito para verificar o funcionamento das funcionalidades e validar os dados.

##  Integrantes

- Larissa Machado RM564168
- Anny Elly RM565055
- Raira Costa RM564850

##  Uso de Inteligência Artificial

A Inteligência Artificial foi utilizada como ferramenta de apoio durante o desenvolvimento do projeto, auxiliando na compreensão dos conceitos de programação, organização do código, identificação de erros e documentação.

##  Considerações finais

O HeatWatch demonstra como a tecnologia pode contribuir para o monitoramento territorial, auxiliando na identificação de situações de calor intenso e sobrecarga elétrica por meio de sensores, previsões e alertas.
