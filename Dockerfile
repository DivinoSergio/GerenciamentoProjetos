FROM tomcat:10.1.34-jdk17-temurin-jammy
LABEL maintainer="divinosergio.ms@gmail.com"

ADD ./target/GerenciamentoProjetos.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]