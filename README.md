# Roman Numeral
Dockerized web service that takes in an integer number and outputs a Roman Numeral.

## Installation

Use the package manager [pip](https://pip.pypa.io/en/stable/) to install foobar.

```bash
pip install foobar
```

## Usage

```python
import foobar

foobar.pluralize('word') # returns 'words'
foobar.pluralize('goose') # returns 'geese'
foobar.singularize('phenomena') # returns 'phenomenon'
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## Logging
- Logback
- Sent to host

## Monitoring
- Prometeus - running on port 9090
http://localhost:9090/targets

## License
[MIT](https://choosealicense.com/licenses/mit/)


## Tech Overview
- Programming Language: [Java](https://openjdk.java.net/projects/jdk/11/)
- Application Framework: [Spring](https://spring.io/projects/spring-framework)  
- Buid and Dependency Manager: [Maven](https://maven.apache.org/)

## Java
- Implementation: OpenJDK
- Version: 11

## Spring Boot
[Spring Initializr](https://start.spring.io/) was used to generate a project using the Spring Boot framework
- Version: 2.4.2

##### Dependencies:
- Spring Web: adds support for RESTful applications using Spring MVC. Uses Apache Tomcat as the embedded container.
- Spring Boot Actuator: Includes endpoints to monitor the application.
- Prometheus: Exposes Micrometer metrics in Prometheus format. Includes simple built-in UI, and a query language.

## Maven




FUTURE:
Centralized Log aggregator like splunk
Centralized Monitoring, Grafana?




Requirements:
Java 11 _ LTS, tested using OpenJDK

>java --version
>
>
Docker
- Prometheus and others?


BUILD:
mvn clean install

docker-compose build

docker-compose up


Use EXAMPLE: http://localhost:8080/romannumeral?query=2


---------------
OLD

-----------------
# Roman Numeral Conversion
Dockerized web service that takes in a number and outputs a Roman numeral.



## Build New Container with Tag roman-numerals
docker build -f Dockerfile -t roman-numeral .

## Run Container
docker run -p 8080:8080 -it -v C:\Users\tatoh\workspace\roman-numeral-conversion\logs:/logs roman-numerals



> Spring boot
> Spring boot web dependency
> Spring boot ops dependency
> Docker > java open jdk


why java 8

why code style check


Configure prometheus

docker pull prom/prometheus
verify with
docker image ls

docker run -d --name prometheus -p 9090:9090 -v C:\Users\tatoh\workspace\roman-numeral-conversion\prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus --config.file=/etc/prometheus/prometheus.yml


FUTURE ENHANCEMENTS:
- Jenkins 
- Grafana
- Splunk

docker run -d --name grafana -p 3000:3000 grafana/grafana