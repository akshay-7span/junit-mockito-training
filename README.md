# JUnit Assertions

JUnit provides a set of assertion methods useful for writing tests. Here are some commonly used assertions along with their explanations:

## Assertions

1. **assertEquals(expected, actual)**
    - **Description**: Fails when the expected value does not equal the actual value.
    - **Usage**: Compare expected and actual values for equality.

2. **assertFalse(expression)**
    - **Description**: Fails when the expression is not false.
    - **Usage**: Verify that a condition is false.

3. **assertNull(actual)**
    - **Description**: Fails when the actual value is not null.
    - **Usage**: Ensure that a reference is null.

4. **assertNotNull(actual)**
    - **Description**: Fails when the actual value is null.
    - **Usage**: Ensure that a reference is not null.

5. **assertAll()**
    - **Description**: Groups many assertions and every assertion is executed even if one or more of them fail.
    - **Usage**: Execute multiple assertions and collect all failures.

6. **assertThrows(expectedType, executable)**
    - **Description**: Checks if executing a specific code block throws an expected exception.
    - **Usage**: Ensure that a specific exception is thrown during the execution of a code block.

7. **assertArrayEquals(expected, actual)**
    - **Description**: Compares two arrays for equality.
    - **Usage**: Verify that two arrays are equal element-wise.
