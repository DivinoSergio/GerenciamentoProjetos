Índice de Conteúdo
==================
   * [Aplicativo web CRUD com design responsivo](#aplicativo-web-crud-com-design-responsivo)
      * [Frameworks e ferramentas usadas](#frameworks-e-ferramentas-usadas)
      * [Linguagem](#linguagem)
      * [Persistência] (#persistência)
      * [Apresentação / Interface do usuário] (#apresentacao--interface-do-usuario)
      * [Servidor de aplicativos (contêiner de servlet, na verdade)] (#servidor-de-aplicacao--servlet-container-)
      * [Ferramenta de gerenciamento e construção de dependências] (#ferramenta-de-gerenciamento-e-construcao-de-dependencias)
      * [IDE](#ide)
   * [Objetivo](#objetivo)
   * [Banco de dados MySQL](#banco-de-dados-mysql)
   * [Como executar este projeto](#como-executar-este-projeto)

# Aplicativo web CRUD com design responsivo
Este projeto é uma aplicação web CRUD simples com design responsivo, usando Java, Spring Framework, JPA, JSF, PrimeFaces e outras tecnologias.

## Frameworks e ferramentas usadas
### Linguagem
* Java 17 (JDK 17)

### Persistência
* JPA 2.2
* Hibernate 5.6.x
* MySQL 8.0.x (Banco de dados relacional)

### Apresentação / UI
* JSF 2.3.x
* Primefaces 11.x

### Servidor de Aplicação (Servlet Container)
* Tomcat 8.5.x

### Dependency Management and Build Tool
* Maven 3.0

### IDE
* Eclipse (2023-06) 4.28.0

## Objetivo
Uma aplicação web de gerenciamento de projetos e tarefas que permita aos usuários visualizar, adicionar, editar e excluir projetos e suas respectivas tarefas. 

Também servirá como ponto de partida para aqueles que estão tendo dificuldades para colocar essas tecnologias mencionadas acima para funcionar em conjunto.

## Banco de dados MySQL
Este projeto foi configurado para o banco de dados "**MySQL**".
Veja META-INF o arqivo "**persistence.xml**" as configurações da base de dados.

Criar o banco de dados: 
    *CREATE DATABASE `gerenciamentoprojetos`;*
**Obs.:** Ao executar o projeto pela rimeira vez as tabelas serão criadas via *Hibernate*.

## Como executar este projeto
1. Download **Apache Tomcat 8.5.x** from https://tomcat.apache.org/download-80.cgi ([Windows](https://archive.apache.org/dist/tomcat/tomcat-8/v8.5.28/bin/apache-tomcat-8.5.28.zip) ou [Linux](https://archive.apache.org/dist/tomcat/tomcat-8/v8.5.28/bin/apache-tomcat-8.5.28.tar.gz)) e extraia para qualquer pasta do seu computador.
2. Open **IDE Eclipse**, vá para "**Preferences**", selecionar o nó "**Server**" e selecionar "**Runtime Environments**". Clicar em **Add...** escolha a pasta onde você extraiu o Tomcat no passo 1 acima. Clique em "**Apply and Close**".
3. Na aba "**Server**", cliar botão direito, seleione o item "**New**", clicar em  **Server**. Na janela selecione o item "**Apache**"", selecione o erção de Tomcat (tomcat-8.5.28).
4. Clone o projeto na sua maquina e importe o ("**File**" / "**Import...**")
5. No Eclipse, com botão direito do mouse selecione "**Properties**". Escolha "**Java Build Path**", selecione a aba "**Libraries**", em "**JRE System...**", adicionar o "**JavaSE-1.7**".
6. Na aba "**Server**"" do Eclipse, no servidor Tomcat, adicione o projeto e em seguida clicar em "**Debug / Start**".
7. No browser "**[http://localhost:8080/GerenciamentoProjetos/](http://localhost:8080/GerenciamentoProjetos/)**". 

