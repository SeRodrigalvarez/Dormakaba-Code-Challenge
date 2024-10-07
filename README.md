# Dormakaba-Code-Challenge

## Description

This project is my Dormakaba Conding Challenge. The app uses Java 21, Spring Boot 3.3 and Gradle. SOLID principles, Hexagonal Architecture and DDD have been applied. Conventional/Standarized commit messages have been used.

## Running the app

The only requirement for running the app is Java 21.

To start the app:

```bash
$ ./gradlew bootRun
```

`Dormakaba.postman_collection.json` contains all the REST requests with pre-request and post-response scripts to populate collection variables (USER_ID, CREDENTIAL_ID, DOOR_ID and CODE).

## Running the tests

This will run the integration tests:

```bash
$ ./gradlew test
```

The integration tests only contains the happy path.

## Pending issues
- Create non-happy path integration tests to check the implemented error handling.
- Use Set instead of List in domain classes for cross-referencing.
- Use Map instead of List for in-memory repository implementations.