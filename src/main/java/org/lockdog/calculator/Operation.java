package org.lockdog.calculator;

import java.util.Optional;

public enum Operation {
    PLUS('+') {
        @Override
        Double execute(final Double num1, final Double num2) {
            return num1 + num2;
        }
    },
    MINUS('-') {
        @Override
        Double execute(final Double num1, final Double num2) {
            return num1 - num2 ;
        }
    },

    DIVIDE('/') {
        @Override
        Double execute(final Double num1, final Double num2) {
            return   num1 / num2;
        }
    },

    MULTIPLY('*') {
        @Override
        Double execute(final Double num1, final Double num2) {
            return num1 * num2;
        }
    };

    private final Character sign;


    Operation(Character sign) {
        this.sign = sign;
    }


    abstract Double execute(Double num1, Double num2);

    public static Optional<Operation> fromCharacter(Character sign) {
        for (Operation operation : Operation.values()) {
            if (operation.sign.equals(sign)) {
                return Optional.of(operation);
            }
        }
        return Optional.empty();
    }
}
