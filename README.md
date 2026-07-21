
## 🛠️ Technologies and Dependencies
This project is built with a modern automated testing architecture using the **Screenplay Pattern** to ensure the code is scalable, maintainable, and highly readable.
The project runs on **Java 21** and is managed via **Gradle**.
The main dependencies used are:
*   **[Serenity BDD (v4.3.2)](https://serenity-bdd.github.io/):** The core framework of the project, used for generating Living Documentation and natively implementing the Screenplay Pattern.
    *   `serenity-core` and `serenity-screenplay`: The foundation of the Screenplay pattern.
    *   `serenity-screenplay-rest`: Native Serenity interactions for testing REST APIs.
    *   `serenity-ensure`: Fluent assertion tasks integrated with Screenplay.
    *   `serenity-junit5`: Official integration for writing and executing tests using JUnit 5.
*   **[JUnit 5 (v5.11.2)](https://junit.org/junit5/):** The test execution framework (Jupiter API and Platform Suite).
*   **[Lombok (v1.18.34)](https://projectlombok.org/):** Used to reduce boilerplate code in models (DTOs), tasks, and object instantiation (e.g., `@Data`, `@Builder`).
*   **[Jackson Databind (v3.0.4)](https://github.com/FasterXML/jackson):** Responsible for the serialization and deserialization of API requests and responses into our domain objects (Java Beans).
*   **[AssertJ (v3.27.7)](https://assertj.github.io/doc/) and [JsonUnit (v5.1.0)](https://github.com/lukas-krecan/JsonUnit):** Complementary tools for performing fluent assertions and working with complex JSON object validations (JSON Nodes).
---
## 🚀 Running the Tests
The execution of the test classes (`@Test`) developed under the **JUnit 5** platform is seamlessly integrated into the Gradle build lifecycle.
To run the tests and collect the results for the Serenity report, open your terminal at the root of the project and use one of the following commands:
**1. Run the entire test suite:**
```bash
./gradlew test
This command will compile the code and execute all classes marked with the JUnit 5 @Test annotation.

2. Run from a clean build (Recommended):

bash
./gradlew clean test
This ensures that no caches or data from previous runs interfere with your test execution.

3. Run a specific test class:

bash
./gradlew test --tests "TestRegisterUser"
Replace TestRegisterUser with the specific name of the class you wish to test.

📊 Report Generation
Once the tests have finished running, you can generate the aggregated report (or Living Documentation) from Serenity BDD by running the following command:

bash
./gradlew aggregate
The detailed HTML report will be automatically generated and hosted in the following path: target/site/serenity/index.html (or build/reports/serenity/index.html depending on your final Serenity configuration).




##
./gradlew openSerenityReport      
./gradlew clean test aggregate --info
./gradlew clean compileJava          