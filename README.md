# How to Use JUnit in a Core Java Project

This guide will walk you through the steps to set up and use JUnit 5 in a core Java project using Maven as your build tool.

## Step 1: Create a Maven Project

### In IntelliJ IDEA:
1. Go to `File` -> `New` -> `Project`.
2. Select `Maven` from the list and click `Next`.
3. Specify the project SDK (e.g., Java 8 or higher) and click `Next`.
4. Enter your GroupId (e.g., `com.example`) and ArtifactId (e.g., `my-junit-project`), then click `Finish`.

## Step 2: Add JUnit 5 Dependencies to Your `pom.xml`

Open the `pom.xml` file in your project root and add the following dependencies inside the `<dependencies>` tag:

```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.8.1</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.8.1</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```
Make sure to update the version numbers to the latest versions available.

## Step 3: Create a Simple Test Class
Create a new Java class for your tests. For example, create src/test/java/com/example/MyTestClass.java:
```
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyTestClass {

    @Test
    void myTestMethod() {
        String message = "Hello, JUnit 5!";
        assertEquals("Hello, JUnit 5!", message);
    }
}
```
## Step 4: Run the Test
In IntelliJ IDEA:
Right-click on the test method (myTestMethod) or the test class (MyTestClass).
Choose Run 'MyTestClass' from the context menu.
Alternatively, you can run your tests from the command line using Maven:


``mvn test``