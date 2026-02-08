# Copilot Instructions for URL Shortener Project

## Project Overview
This project is a URL shortener built using Spring Boot and Maven. It allows users to shorten long URLs and retrieve them using a short URL. The architecture is based on a typical Spring Boot application structure, with clear separation of concerns across controllers, services, and repositories.

## Key Components
- **ShorturlApplication**: The main entry point of the application located in `src/main/java/com/apurva/shorturl/shorturl/ShorturlApplication.java`.
- **Controllers**: Handle HTTP requests and responses. The primary controller is `UrlController` located in `src/main/java/com/apurva/shorturl/shorturl/controller/UrlController.java`.
- **Services**: Business logic is encapsulated in services, primarily `UrlService` located in `src/main/java/com/apurva/shorturl/shorturl/service/UrlService.java`.
- **Repositories**: Data access is managed through JPA repositories, specifically `UrlRepository` located in `src/main/java/com/apurva/shorturl/shorturl/repository/UrlRepository.java`.
- **Models**: The data model is represented by the `Url` class located in `src/main/java/com/apurva/shorturl/shorturl/model/Url.java`.
- **Utilities**: The `ShortUrlGenerator` utility class generates short URLs, located in `src/main/java/com/apurva/shorturl/shorturl/util/ShortUrlGenerator.java`.

## Developer Workflows
- **Building the Project**: Use Maven to build the project. Run `mvn clean install` to compile the code and package it into a JAR file.
- **Running the Application**: Start the application using `mvn spring-boot:run` or by executing the generated JAR file.
- **Testing**: Unit tests are located in `src/test/java/com/apurva/shorturl/shorturl/ShorturlApplicationTests.java`. Run tests using `mvn test`.

## Integration Points
- **Database**: The application uses JPA for database interactions. Ensure that the database is configured in `src/main/resources/application.properties`.
- **External Dependencies**: The project relies on Spring Boot and Spring Data JPA. These dependencies are managed in the `pom.xml` file.

## Project Conventions
- **Naming Conventions**: Follow Java naming conventions for classes and methods. Use camelCase for method names and PascalCase for class names.
- **Error Handling**: Use `ResponseStatusException` for handling errors in services and controllers.

## Examples
- To shorten a URL, send a POST request to `/shorten` with a JSON body containing the long URL.
- To retrieve the original URL, send a GET request to `/url/{shortUrl}`.

## Additional Resources
- Refer to the [Official Apache Maven documentation](https://maven.apache.org/guides/index.html) for more details on Maven commands.
- Check the [Spring Boot documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) for in-depth understanding of Spring Boot features.
