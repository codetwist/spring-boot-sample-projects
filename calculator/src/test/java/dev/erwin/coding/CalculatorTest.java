package dev.erwin.coding;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    void validateNullInput1() {
        Calculator calculator = new Calculator();
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> calculator.calculate(Operation.DIVIDE, null, 1),
                "Expected Null"
        );
        assertEquals("number1 cannot be null", exception.getMessage());
    }
    @Test
    void validateNullInput2() {
        Calculator calculator = new Calculator();
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> calculator.calculate(Operation.DIVIDE, 1, null),
                "Expected Null"
        );
        assertEquals("number2 cannot be null", exception.getMessage());
    }

    @Test
    void validateNullOperation() {
        Calculator calculator = new Calculator();
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> calculator.calculate(null, 1, 2),
                "Expected Null"
        );
        assertEquals("operation cannot be null", exception.getMessage());
    }
        @Test
    void calculateBasicAdd() {
        Calculator calculator = new Calculator();
        calculator.calculate(Operation.ADD, 23, 45);
        Optional<Number> result = calculator.getResult();
        Assertions.assertTrue(result.isPresent());
        assertEquals(68.0, result.get().intValue());
    }

    @Test
    void calculateBasicMultiply() {
        Calculator calculator = new Calculator();
        calculator.calculate(Operation.MULTIPLY, 40, 10);
        Optional<Number> result = calculator.getResult();
        Assertions.assertTrue(result.isPresent());
        assertEquals(400, result.get().intValue());
    }

    @Test
    void calculateBasicSubtraction() {
        Calculator calculator = new Calculator();
        calculator.calculate(Operation.SUBTRACT, 123, 76);
        Optional<Number> result = calculator.getResult();
        Assertions.assertTrue(result.isPresent());
        assertEquals(47, result.get().intValue());
    }

    @Test
    void calculateBasicDivision() {
        Calculator calculator = new Calculator();
        calculator.calculate(Operation.DIVIDE, 426, 3);
        Optional<Number> result = calculator.getResult();
        Assertions.assertTrue(result.isPresent());
        assertEquals(142, result.get().intValue());
    }

    @Test
    void testCalculateChained_START_DIVIDE() {
        Calculator calculator = new Calculator();
        calculator.calculate(Operation.DIVIDE, 100, 4)
                .calculate(Operation.MULTIPLY, 3)
                .calculate(Operation.ADD, 10)
                .calculate(Operation.SUBTRACT, 20);
        Optional<Number> result = calculator.getResult();
        Assertions.assertTrue(result.isPresent());
        assertEquals(65, result.get().intValue());
    }

    @Test
    void testCalculateChained_START_MULTIPLY() {
        Calculator calculator = new Calculator();
        calculator.calculate(Operation.MULTIPLY, 15, 4)
                .calculate(Operation.DIVIDE, 10)
                .calculate(Operation.ADD, 24)
                .calculate(Operation.SUBTRACT, 10);
        Optional<Number> result = calculator.getResult();
        Assertions.assertTrue(result.isPresent());
        assertEquals(20, result.get().intValue());
    }

    @Test
    void testCalculateChained_START_ADD() {
        Calculator calculator = new Calculator();
        calculator.calculate(Operation.ADD, 15, 5)
                .calculate(Operation.DIVIDE, 10)
                .calculate(Operation.MULTIPLY, 24)
                .calculate(Operation.SUBTRACT, 10);
        Optional<Number> result = calculator.getResult();
        Assertions.assertTrue(result.isPresent());
        assertEquals(38, result.get().intValue());
    }

    @Test
    void testCalculateChained_START_SUBTRACT() {
        Calculator calculator = new Calculator();
        calculator.calculate(Operation.SUBTRACT, 15, 5)
                .calculate(Operation.DIVIDE, 10)
                .calculate(Operation.MULTIPLY, 24)
                .calculate(Operation.ADD, 10);
        Optional<Number> result = calculator.getResult();
        Assertions.assertTrue(result.isPresent());
        assertEquals(34, result.get().intValue());
    }

    @Test
    void testDivideByZero() {
        Calculator calculator = new Calculator();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculate(Operation.DIVIDE, 10, 0),
                "Divisor cannot be zero"
        );

        assertEquals("Divisor cannot be zero", exception.getMessage());
    }

    @Test
    void callToSingleValueOperation_ADD() {
        Calculator calculator = new Calculator();
        calculator.calculate(Operation.ADD, 23);
        Optional<Number> result = calculator.getResult();
        Assertions.assertTrue(result.isPresent());
        assertEquals(23, result.get().intValue());
    }
    @Test
    void callToSingleValueOperation_SUBTRACT() {
        Calculator calculator = new Calculator();
        calculator.calculate(Operation.SUBTRACT, 23);
        Optional<Number> result = calculator.getResult();
        Assertions.assertTrue(result.isPresent());
        assertEquals(-23, result.get().intValue());
    }

    @Test
    void callToSingleValueOperation_DIVIDE() {
        Calculator calculator = new Calculator();
        calculator.calculate(Operation.DIVIDE, 23);
        Optional<Number> result = calculator.getResult();
        Assertions.assertTrue(result.isPresent());
        assertEquals(0, result.get().intValue());
    }

    @Test
    void callToSingleValueOperation_MULTIPLY() {
        Calculator calculator = new Calculator();
        calculator.calculate(Operation.MULTIPLY, 23);
        Optional<Number> result = calculator.getResult();
        Assertions.assertTrue(result.isPresent());
        assertEquals(25, result.get().intValue());
    }

}