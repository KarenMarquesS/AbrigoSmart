# AbrigoSmart - Assitente Virtual para Gerenciamento em Desastres Naturais.


                                         “Quando o desastre chega, cada segundo conta. E cada vida importa.”

## ![image](https://github.com/user-attachments/assets/e30c7ff1-06d0-4e13-96a7-0dabf854be07)
 Missão
  Oferecer acolhimento digno, seguro e eficiente às vítimas de desastres, por meio da tecnologia e da inteligência artificial, otimizando a triagem, a gestão de recursos e a coordenação entre equipes de resposta humanitária.


## 📌 Índice
- [Funcionalidades](#-funcionalidades)
- [Tecnologias](#-tecnologias)
- [Pré-requisitos](#-pré-requisitos)
- [Instalação](#-instalação)
- [Execução](#-execução)
- [Documantação da API](#-documentação-da-api)
- [Estrutura](#-estrutura)
- [Status da Aplicação](#-status-da-aplicação)
- [Autores](#-autores)
  

## 🚀 Funcionalidades
- **Gerenciamento**:
  - Triagem de Vítimas
  - Insumos alimentícios e estrutural(roupas, colchões, etc)
- ****:
  - Consultar a localização da Moto


## 💻 Tecnologias
 - Java (v.17)
 - Maven (v.17)
 - SpringBoot (v. 3.4.4)
 - Oracle SQL Developer (v.12)
 - Idea Intellij IDEA
  

## 📋 Pré-requisitos
- IDEA
  - Intellij, ou
  - Eclipse, ou outra da preferência
- JDK 22
- Maven 


## 🔧 Instalação
 - git clone https://github.com/KarenMarquesS/YardFlow.git
 - cd yardflow
 - mvn clean install 


## 🏃 Execução
 - mvn spring-boot:run


## 📘 Documentação da API
A aplicação conta com uma interface interativa gerada pelo Swagger, permitindo testar os endpoints diretamente pelo navegador.
  - Acesse: `http://localhost:8080/swagger-ui.html`


## 🗂 Estrutura
```
src
└── main
├── java
│ └── org.example.yardflow
│ ├── configuration
| | ├──MapperConfig
│ ├── control
| | ├──ClienteController
│ │ ├── MotoController
| | ├── PatioController
| | ├── Registro_in_outController
│ │ └── VagasControler
│ ├── dto
│ │ ├── ClienteDTO
| | ├── MotoDTO
| | ├── PatioDTO
| | ├── Registro_in_outDTO
│ │ └── VagaDTO
| | |__ PatioDTO
│ ├── exception
| | ├──ExceptionGlobal
│ ├── model
│ │ ├── Cliente
│ │ ├── ModeloEnum
│ │ ├── Moto
│ │ ├── Patio
│ │ ├── PlanoEnum
│ │ ├── Registro_check_in_Out
│ │ ├── SetorEnum
│ │ └── Vaga
│ ├── projection
| | ├──PermanenciaPorSetor
│ ├── repository
│ │ ├── ClienteRepositorio
│ │ ├── MotoRepositorio
│ │ ├── PatioRepositorio
│ │ ├── Registro_check_in_OutRepositorio
│ │ └── VagasRepositorio
│ ├── service
│ │ ├── ClienteCachingService
│ │ ├── MotoCachingService
│ │ ├── PatioCachingService
│ │ ├── Registro_check_in_OutCachingService
│ │ └── VagasCachingService
│ ├── swagger
│ │ ├── SwaggerConfig
│ └── YardFlowApplication
└── resources
├── application.properties
└── import.sql
```


## 🚧 Status da Aplicação 
 - Aplicação em Desenvolvimento
   - Cronograma de exceução
     - 30% finalizado até 23/05/2025 (1° e 2° sprint)
     - 30% finalizado em             (3° sprint)
     - 40% finalizado em             (4° sprint)     


## 👥 Autores
    Nome	                    RM          GitHub
    Fernanda Budniak de Seda  558274      https://github.com/Febudniak
    Lucas Lerri de Almeida    554635      https://github.com/lerri05
    Karen Marques dos Santos  554556      https://github.com/KarenMarquesS

