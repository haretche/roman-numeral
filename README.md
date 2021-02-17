# Roman Numeral
Dockerized web service that takes in an integer number and outputs a Roman Numeral.

## Requirements
#### Java 11 - OpenJDK preferred

Verify with:
```bash
$ java -version
```
Expected response:
```bash
java version "11.0.10" 2021-01-19 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.10+8-LTS-162)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.10+8-LTS-162, mixed mode)
```
     
#### Maven 3
 
Verify with:
```bash
$ mvn -version
```
Expected response:
```bash
Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
Maven home: C:\Program Files (x86)\apache-maven-3.6.3\bin\..
Java version: 11.0.10, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-11.0.10
Default locale: en_US, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```
  
#### Docker

Verify with:
```bash
$ docker --version
```
Expected response:
```bash
Docker version 20.10.2, build 2291f61
```

## Installation

1. Download source code, and extract into a folder in workspace.

2. Open a terminal and navigate to project folder.
    ```bash
    $ cd ~/workspace/roman-numeral
    ```

3. Use Maven to build the Java project and generate a Jar.
    ```bash
    $ mvn clean install
    ```

4. Build a Docker image and start a container with it.
    ```bash
    $ docker-compose up
    ```

## Usage
The application is available on port 8080.
- E.g. http://localhost:8080/romannumeral?query=123

Prometheus is used for monitoring and published on port 9090.
- E.g. http://localhost:9090/graph?g0.expr=romannumeral_get_request_seconds_sum&g0.tab=0&g0.stacked=1&g0.range_input=5m

Alerts are avilable in Prometheus.
- http://localhost:9090/alerts

## About Roman Numerals
Roman numerals use a series of symbols with different values:

| Symbol | Value  |
| :----: | :----: |
| I      | 1      |
| V      | 5      |
| X      | 10     |
| L      | 50     |
| C      | 100    |
| D      | 500    |
| M      | 1000   |

Lower value symbols placed to the left of a higher value symbol substract from the total, whereas if the order is inverted, then the total is the sum of the components.

For example:

| Numeral | Value   |
| :-----: | :-----: |
| IX      | 9       |
| XI      | 11      |

 
Please view the Wikipedia article on [Roman Numerals](https://en.wikipedia.org/wiki/Roman_numerals) for more information.

## Technical Overview
This application was built using the [Spring Framework](https://spring.io/projects/spring-framework) and on
[Java](https://openjdk.java.net/projects/jdk/11/).

It relies on [Maven](https://maven.apache.org/) for build automation and dependency management.

#### Testing

This code is covered by Unit tests on all business logic.
The web layer (Controllers) are tested using Integration tests, provided by Spring Boot.
Mockito shall be used in the future when there are new dependencies on other systems. E.g. a database. 

#### Logging
Docker logs are available outside of the container, in the host, under the logs folder: [./logs](logs).

Archived log files are retained for up to 90 days.

#### Monitoring
Metrics are collected by [Micrometer](https://micrometer.io/), exposed here http://localhost:8080/actuator/prometheus.

Prometheus runs on port 9090 and polls that endpoint periodically. It can show multiple metrics in its UI. It is also used to define alert rules and thresholds. 

#### Spring Boot Dependencies:
- Spring Web: adds support for RESTful applications using Spring MVC. Ads Apache Tomcat as the embedded container.
- Spring Boot Actuator: Includes endpoints to monitor the application.
- Prometheus: Exposes Micrometer metrics in Prometheus format. Includes simple built-in UI, and a query language.

## Roadmap
- Setup Splunk to aggregate logs and add the ability to create alerts on those logs. 
- Stand up an alert manager that polls alert information form Prometheus and triggers incidents in Pager Duty.
- Add CI/CD using existing corporate Jenkins infrastructure.
- Create Dashboards in Grafana to display Prometheus information for all nodes.

## License
[GNU GPLv3](https://choosealicense.com/licenses/gpl-3.0/)

