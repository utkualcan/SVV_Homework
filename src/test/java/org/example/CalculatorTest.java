// B211202037
// Muhammet Utku Alcan
// Software Verification and Validation
// SVV Homework (creating a data-driven test (parameterized test) using JUnit5.)
// https://github.com/utkualcan/SVV_Homework

package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
    @ParameterizedTest
    @DisplayName("Division with different inputs")
    @CsvSource({
            "10, 2, 5",
            "10, 4, 2.5",
            "12.5f, 2.5f, 5",
            "10, 2.5f, 4",
            "12.5f, 5, 2.5f"
    })
    public void testDivide(float a, float b, float expectedResult) {
        float actualResult = Calculator.divide(a, b);
        Assertions.assertEquals(expectedResult, actualResult, 0.001);
    }

    @ParameterizedTest
    @DisplayName("Division by zero throws IllegalArgumentException")
    @CsvSource({
            "10, 0"
    })
    public void testDivideByZero(float a, float b) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Calculator.divide(a, b));
    }
}