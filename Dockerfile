FROM openjdk:11
ADD target/roman-numeral.jar roman-numeral.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "roman-numeral.jar"]
