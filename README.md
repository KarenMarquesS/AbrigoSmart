# ![image](https://github.com/user-attachments/assets/670ca052-f736-4da2-b4a8-8ecd9ddb669a) AbrigoSmart - Assitente Virtual de Gestão de Abrigo Temporário

                                         “Quando o desastre chega, cada segundo conta. E cada vida importa.”

## ![image](https://github.com/user-attachments/assets/718d5a02-3963-46a6-83c8-2572fe4482d6) Missão
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
 - git clone https://github.com/KarenMarquesS/AbrigoSmart.git
 - cd abrigosmart
 - mvn clean install 


## 🏃 Execução
 - mvn spring-boot:run


## 📘 Documentação da API
A aplicação conta com uma interface interativa gerada pelo Swagger, permitindo testar os endpoints diretamente pelo navegador.
  - Acesse: `http://localhost:8080/swagger-ui.html`
  - Rotas de Acesso
    
  ![image](https://github.com/user-attachments/assets/a94ab4d5-d22e-4b21-808c-36f0c85f62b6)



## 🗂 Estrutura
```
src
└── main
├── java
│ └── org.example.abrigosmart
│ ├── control
| | ├── AutenticacaoController
│ │ ├── TriagemController
| | ├── UsuarioController
│ │ └── VitimaControler
│ ├── dto
│ │ ├── TriagemDTO
| | ├── UsuarioDTO
│ │ └── VitmiaDTO
│ ├── model
│ │ ├── FuncacaoEnum
│ │ ├── GeneroEnum
│ │ ├── PrioriEnum
│ │ ├── Triagem
│ │ ├── Usuario
│ │ └── Vitima
│ ├── repositorio
│ │ ├── TriagemRepositorio
│ │ ├── UsuarioRepositorio
│ │ └── VitimaRepositorio
│ ├── security
│ │ ├── AcessoConfig
│ │ ├── JWTAythFilter
│ │ ├── JWTUtil
│ │ └── SegurancaConfig
│ ├── service
│ │ ├── TriagemCachingService
│ │ ├── UsuarioCachingService
│ │ └── VitimaCachingService
│ ├── swagger
│ │ ├── SwaggerConfiguration
│ └── AbrigoSmartApplication
└── resources
├── application.properties
└── insert.sql
```


## 🚧 Status da Aplicação 
 - Aplicação Desenvolvida
   - Global Solutions
     - Entrega 06/06/2025    


## 👥 Desenvolvedores
           Nome	                RM                GitHub
    Fernanda Budniak de Seda  558274      https://github.com/Febudniak
    Lucas Lerri de Almeida    554635      https://github.com/lerri05
    Karen Marques dos Santos  554556      https://github.com/KarenMarquesS

