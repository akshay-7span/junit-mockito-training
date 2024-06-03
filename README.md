# JUnit 5 Assumptions

JUnit 5 provides a set of static methods in the `org.junit.jupiter.api.Assumptions` class known as assumptions. These methods are used to execute a test only when the specified condition is met; otherwise, the test will be aborted. Unlike assertions, aborted tests will not cause a build failure. When an assumption fails, an `org.opentest4j.TestAbortedException` is thrown, and the test is skipped.

## Assumptions

1. **assumeTrue(condition)**
    - **Description**: Execute the body of the lambda when the positive condition holds; otherwise, the test will be skipped.

2. **assumeFalse(condition)**
    - **Description**: Execute the body of the lambda when the negative condition holds; otherwise, the test will be skipped.

3. **assumingThat(condition, executable)**
    - **Description**: Portion of the test method will execute if an assumption holds true, and everything after the lambda will execute irrespective of the assumption in `assumingThat()` holds.
