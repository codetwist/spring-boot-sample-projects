package dev.erwin.coding;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * This class simulates a Calculator which initially accepts two numbers and can subsequently chain the operations
 * until the result is retrieved.
 *
 * @author Erwin Cabral
 */
public class Calculator {

    private Number computedResult;

    public Calculator(){
        this.computedResult = 0;
    }

    /**
     * Performs a given operation on two input numbers
     *
     * @param operation an enum of the type of operation
     * @param number1 first input number
     * @param number2 2nd input number
     * @return an instance of this Calculator
     */
    public Calculator calculate(Operation operation, Number number1, Number number2) {
        Objects.requireNonNull(number1, "number1 cannot be null");
        Objects.requireNonNull(number2, "number2 cannot be null");
        Objects.requireNonNull(operation, "operation cannot be null");
        BiFunction<Number, Number, Number> biFunction = operation.getBiFunction();
        this.computedResult = biFunction.apply(number1, number2);
        return this;
    }

    /**
     * Performs a given operation on two input numbers - but the other input has already been a computed result of
     * the previous operation. If initially called, the value of the computed result is initialized to 0.
     *
     * @param operation an enum of the type of operation
     * @param number input number
     * @return an instance of this Calculator
     */
    public Calculator calculate(Operation operation, Number number) {
        Objects.requireNonNull(number, "number cannot be null");
        Objects.requireNonNull(operation, "operation cannot be null");
        BiFunction<Number, Number, Number> biFunction = operation.getBiFunction();
        this.computedResult = biFunction.apply(this.computedResult, number);
        return this;
    }

    /**
     * Return computed result
     *
     * @return computed result
     */
    public Optional<Number> getResult() {
        return Optional.ofNullable(this.computedResult);
    }

}
