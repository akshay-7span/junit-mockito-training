# Simple Testing with Java

If you're looking to perform basic testing without using a testing framework like JUnit, you can achieve that through simple method testing within your Java code.

## SimpleMath Class

The `SimpleMath` class contains basic arithmetic methods for addition and subtraction.

```java
public class SimpleMath {
    // Adds two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Subtracts one integer from another
    public int subtract(int a, int b) {
        return a - b;
    }
}
