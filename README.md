# JUnit Annotations

JUnit provides a set of annotations that help in writing and organizing tests effectively. Below are some commonly used annotations along with their explanations:

## Annotations

1. **@Test**: Denotes a test method.
    - **Usage**: Annotate a method with @Test to indicate that it's a test method. JUnit will execute methods annotated with this when running tests.

2. **@DisplayName**: Declares a custom display name for the test class or test method.
    - **Usage**: Provide a meaningful display name for better identification in test reports.

3. **@BeforeEach**: Denotes that the annotated method should be executed before each test method.
    - **Usage**: Initialize or set up resources required for each test method.

4. **@AfterEach**: Denotes that the annotated method should be executed after each test method.
    - **Usage**: Clean up or release resources after each test method.

5. **@BeforeAll**: Denotes that the annotated method should be executed before all test methods.
    - **Usage**: Initialize or set up resources common to all test methods in the test class.

6. **@AfterAll**: Denotes that the annotated method should be executed after all test methods.
    - **Usage**: Clean up or release resources common to all test methods in the test class.

7. **@Disabled**: Used to disable a test class or test method temporarily.
    - **Usage**: Temporarily exclude a test from the test suite.

8. **@Nested**: Denotes that the annotated class is a nested, non-static test class.
    - **Usage**: Group related tests within a nested class for better organization.

9. **@Tag**: Declare tags for filtering tests.
    - **Usage**: Add tags to tests and then run tests based on specific tags.
