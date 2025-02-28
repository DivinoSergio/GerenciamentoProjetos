Índice de Conteúdo
==================
* [Aplicativo web CRUD com design responsivo](#aplicativo-web-crud-com-design-responsivo)
* [Frameworks e ferramentas usadas](#frameworks-e-ferramentas-usadas)
    * [Linguagem](#linguagem)
    * [Persistência](#Persistência)
    * [UI Interface do usuário](#ui-interface-do-usuário)
    * [Servidor de Aplicação (Servlet Container)](#Servidor-de-Aplicação--Servlet-Container-)
    * [Ferramenta de gerenciamento e construção de dependências](#ferramenta-de-gerenciamento-e-construcao-de-dependências)
    * [IDE](#ide)
* [Objetivo](#objetivo)
* [Banco de dados MySQL](#banco-de-dados-mysql)
* [Como executar este projeto](#como-executar-este-projeto)

# Aplicativo web CRUD com design responsivo
Este projeto é uma aplicação web CRUD simples com design responsivo, usando Java, JPA, JSF, PrimeFaces e outras tecnologias.

## Frameworks e ferramentas usadas
### Linguagem
* Java 17 (JDK 17)

### Persistência
* JPA 2.2
* Hibernate 5.6.x
* MySQL 8.0.x (Banco de dados relacional)

### UI Interface do usuário
* JSF 2.3.x
* Primefaces 12.x
* <b>Porque não usou Richfaces?</b><br/>
	RichFaces, desde 2016, foi descontinuado pela Red Hat, o que significa que não há mais suporte oficial.<br/>
	Tornando o projeto custoso de se configurar junto as novas tecnologias.

### Servidor de Aplicação (Servlet Container)
* Tomcat 10.1.x

### Ferramenta de gerenciamento e construção de dependências
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
1. Download **Apache Tomcat 8.5.x** from https://tomcat.apache.org/download-10.cgi ([Windows](https://archive.apache.org/dist/tomcat/tomcat-10/v10.1.34/bin/apache-tomcat-10.1.34-windows-x64.zip) ou [Linux](https://archive.apache.org/dist/tomcat/tomcat-10/v10.1.34/bin/apache-tomcat-10.1.34.tar.gz)) e extraia para qualquer pasta do seu computador.
2. Open **IDE Eclipse**, vá para "**Preferences**", selecionar o nó "**Server**" e selecionar "**Runtime Environments**". Clicar em **Add...** escolha a pasta onde você extraiu o Tomcat no passo 1 acima. Clique em "**Apply and Close**".
3. Na aba "**Server**", cliar botão direito, seleione o item "**New**", clicar em  **Server**. Na janela selecione o item "**Apache**"", selecione o versão de Tomcat (tomcat-10.1.34).
4. Clone o projeto na sua maquina e importe o ("**File**" / "**Import...**")
5. No Eclipse, com botão direito do mouse selecione "**Properties**". Escolha "**Java Build Path**", selecione a aba "**Libraries**", em "**JRE System...**", adicionar o "**JavaSE-1.7**".
6. Na aba "**Server**"" do Eclipse, no servidor Tomcat, adicione o projeto e em seguida clicar em "**Debug / Start**".
7. No browser "**[http://localhost:8080/GerenciamentoProjetos/](http://localhost:8080/GerenciamentoProjetos/)**". 


### Requisitos

<p align="center">
	<img loading="lazy" src="https://img.shields.io/badge/Eclipse-v2023--06-blue?logo=eclipse"/>
	<img loading="lazy" src="https://img.shields.io/badge/Tomcat-v10.0.34-blue?logo=apachetomcat"/>
	<img loading="lazy" src="https://img.shields.io/badge/Java-v17-blue?logo=openjdk"/>
	<img loading="lazy" src="https://img.shields.io/badge/Git-v2.43.0-blue?logo=git"/>
	<img loading="lazy" src="https://img.shields.io/badge/Maven-v3.0.1-blue?logo=apachemaven"/>
	<img loading="lazy" src="https://img.shields.io/badge/MySQL-v8.0.1-blue?logo=mysql"/>
	<img loading="lazy" src="https://img.shields.io/badge/Primefaces-v12.0-blue?logo=primefaces"/>
</p>

### Referências de apoio.
	https://simpleicons.org/
	https://shields.io/

<div>
  <a href="https://github.com/DivinoSergio">
  <img height="180em" src="https://github-readme-stats.vercel.app/api?username=DivinoSergio&show_icons=true&theme=highcontrast&include_all_commits=true&count_private=true"/>
  <img height="180em" src="https://github-readme-stats.vercel.app/api/top-langs/?username=DivinoSergio&layout=compact&langs_count=7&theme=highcontrast"/>
</div>

<div> 
  <br/>
  <a href="https://www.linkedin.com/in/divinosergiomendes/" target="_blank">
  	 <img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank">
  </a> 
</div>