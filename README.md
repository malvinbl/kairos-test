# Kairos Test

## Overview
The repo contains the implementation of a Rest API that provides a solution to the Kairos technical test.

## Guidelines

1. Clone this repository

2. Go to the project directory

3. Run the project
    ```sh
    .\gradlew bootRun
    ```

### Swagger
http://localhost:8080/pvp-api/v1/swagger-ui/index.html

#### Data to consult:

productId: 35455

brandId: 1

date:

    test_1: 2020-06-14T10:00:00

    test_2: 2020-06-14T16:00:00

    test_3: 2020-06-14T21:00:00

    test_4: 2020-06-15T10:00:00

    test_5: 2020-06-16T21:00:00

### View metrics
http://localhost:8080/pvp-api/v1/actuator/prometheus

### Run the project tests
```sh
.\gradlew test
```

## More Info
It is used:

Spring Boot v3.4.5

Java 17

A Hexagonal Architecture is implemented, taking into account the concepts of Clean Architecture and Clean Code.
These concepts are supported by the principles of good software development practices such as S.O.L.I.D, KISS, DRY.
This is done in order to create a computer system focused on separating business concerns from technical concerns.
And to obtain higher quality software, easy to test and easy to maintain over time.

Gradle is used to manage dependencies.

Git is used as a version control system.

Hibernate is used for persistence management.
The data schema is modeled as a relational database. Database performance is optimized by using indexes.

Different Java language options are taken into account, such as Stream, Records, to achieve more optimal code.

Exception handling is implemented with Spring advice.

Spring resource files are used.

A cache strategy is implemented to improve application performance.

Code, unit and integration tests are implemented. Using JUnit, Mockito, MockMvc.

Metrics are configured to monitor application performance. Log archiving is also configured.
