package dev.erwin.coding;

import java.util.function.BiFunction;

/**
 * An Enum of Mathematical operations. The operations ar mapped to each BiFunction implementation.
 * When new operations added, only this Enum is updated.
 *
 * @author Erwin Cabral
 */
public enum Operation {

    ADD((a, b) -> a.doubleValue() + b.doubleValue()),
    SUBTRACT((a, b) -> a.doubleValue() - b.doubleValue()),
    MULTIPLY((a, b) -> a.doubleValue() * b.doubleValue()),
    DIVIDE((a, b) -> {
        if (b == null) {
            throw new NullPointerException("Denominator cannot be null");
        }
        if (b.doubleValue() == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        return a.doubleValue() / b.doubleValue();
    });

    private final BiFunction<Number, Number, Number> biFunction;

    /**
     * Constructor for Enum Operation
     *
     * @param biFunction two inputs and one output function
     */
    Operation(BiFunction<Number, Number, Number> biFunction) {
        this.biFunction = biFunction;
    }

    /**
     * @return the matching BiFunction for a given Enum
     */
    public BiFunction<Number, Number, Number> getBiFunction() {
        return biFunction;
    }
}
