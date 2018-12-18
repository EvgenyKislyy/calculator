package org.lockdog.calculator;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {

    @Test
    public void testSum() {
        Operation operation = Operation.PLUS;
        assertEquals(Double.valueOf(10.0), operation.execute(5.0, 5.0));
        assertEquals(Double.valueOf(0), operation.execute(-5.0, 5.0));
        assertEquals(Double.valueOf(5.0), operation.execute(0.0, 5.0));
        assertEquals(Double.valueOf(5.0), operation.execute(5.0, 0.0));

        assertEquals(Double.valueOf(101.11), operation.execute(100.0, 1.11));
        assertEquals(Double.valueOf(0.457), operation.execute(0.456, 0.001));
        assertEquals(Double.valueOf(0.0), operation.execute(0.0, 0.0));
        assertEquals(Double.valueOf(-4.0), operation.execute(-5.0, 1.0));
    }

    @Test
    public void testMinus() {
        Operation operation = Operation.MINUS;
        assertEquals(Double.valueOf(0.0), operation.execute(5.0, 5.0));
        assertEquals(Double.valueOf(-10.0), operation.execute(-5.0, 5.0));
        assertEquals(Double.valueOf(-5.0), operation.execute(0.0, 5.0));
        assertEquals(Double.valueOf(5.0), operation.execute(5.0, 0.0));

        assertEquals(Double.valueOf(98.89), operation.execute(100.0, 1.11));
        assertEquals(Double.valueOf(0.455), operation.execute(0.456, 0.001));
        assertEquals(Double.valueOf(0.0), operation.execute(0.0, 0.0));
        assertEquals(Double.valueOf(-6.0), operation.execute(-5.0, 1.0));
    }

    @Test
    public void testMultiply() {
        Operation operation = Operation.MULTIPLY;
        assertEquals(Double.valueOf(25), operation.execute(5.0, 5.0));
        assertEquals(Double.valueOf(-25), operation.execute(-5.0, 5.0));
        assertEquals(Double.valueOf(0), operation.execute(0.0, 5.0));
        assertEquals(Double.valueOf(5.0), operation.execute(5.0, 1.0));

        assertEquals(Double.valueOf(1000), operation.execute(100.0, 10.0));
        assertEquals(Double.valueOf(45.6), operation.execute(0.456, 100.0));

        assertEquals(Double.valueOf(-5.0), operation.execute(-5.0, 1.0));
    }

    @Test
    public void testDivide() {
        Operation operation = Operation.DIVIDE;
        assertEquals(Double.valueOf(1.0), operation.execute(5.0, 5.0));
        assertEquals(Double.valueOf(-1.0), operation.execute(-5.0, 5.0));
        assertEquals(Double.valueOf(0.0), operation.execute(0.0, 5.0));
       // assertEquals(Double.valueOf(5.0), operation.execute(5.0, 0.0));

        assertEquals(Double.valueOf(100), operation.execute(100.0, 1.00));
        assertEquals(Double.valueOf(500), operation.execute(0.500, 0.001));
//        assertEquals(Double.valueOf(0.0), operation.execute(0.0, 0.0));
        assertEquals(Double.valueOf(-5.0), operation.execute(-5.0, 1.0));
    }

    @Test
    public void testParsing() {
        assertEquals(Operation.DIVIDE, Operation.fromCharacter('/').get());
        assertEquals(Operation.MINUS, Operation.fromCharacter('-').get());
        assertEquals(Operation.MULTIPLY, Operation.fromCharacter('*').get());
        assertEquals(Operation.PLUS, Operation.fromCharacter('+').get());

        assertEquals(Optional.empty(), Operation.fromCharacter('d'));
        assertEquals(Optional.empty(), Operation.fromCharacter('5'));
        assertEquals(Optional.empty(), Operation.fromCharacter(':'));
    }

}
