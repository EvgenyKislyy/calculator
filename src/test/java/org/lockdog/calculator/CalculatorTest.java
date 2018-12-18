package org.lockdog.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testCalculator() {
        NumbersService numbersService = new NumbersService();
        numbersService.add(5.0);
        numbersService.add(8.0);
        numbersService.add(9.0);

        Calculator calculator = new Calculator();
        calculator.setNumbersService(numbersService);

        calculator.tryToParseMathSign("+");

        assertEquals(Double.valueOf(17.0), numbersService.getCurrent());

        calculator.tryToParseMathSign("-");

        assertEquals(Double.valueOf(-8.0), numbersService.getCurrent());

        calculator.tryToParseMathSign("*");

        assertEquals(Double.valueOf(-136.0), numbersService.getCurrent());

        calculator.tryToParseMathSign("/");

        assertEquals(Double.valueOf(0.058823529411764705), numbersService.getCurrent());

        assertEquals(7, numbersService.getHistory().size());

        calculator.tryToParseMathSign("sdfsfsddsfsfd");
        calculator.tryToParseMathSign("r");

        assertEquals(Double.valueOf(0.058823529411764705), numbersService.getCurrent());

        assertEquals(7, numbersService.getHistory().size());
    }

    @Test
    public void testCalculator2() {
        NumbersService numbersService = new NumbersService();


        Calculator calculator = new Calculator();
        calculator.setNumbersService(numbersService);

        calculator.tryToParseTheNumber("234", false);
        calculator.tryToParseTheNumber("2", false);
        calculator.tryToParseTheNumber("4", false);

        assertEquals(3, numbersService.getHistory().size());

        calculator.tryToParseTheNumber("55.4", false);
        calculator.tryToParseTheNumber("67.3", false);

        assertEquals(Double.valueOf(67.3), numbersService.getCurrent());

        assertEquals(Double.valueOf(55.4), numbersService.getPrevious());

    }


    @Test
    public void testCalculator3() {
        NumbersService numbersService = new NumbersService();
        Calculator calculator = new Calculator();
        calculator.setNumbersService(numbersService);

        calculator.parseInput("13 13 +");
        assertEquals(3, numbersService.getHistory().size());
        assertEquals(Double.valueOf(26), numbersService.getCurrent());

        calculator.parseInput("20 -");
        assertEquals(5, numbersService.getHistory().size());
        assertEquals(Double.valueOf(6), numbersService.getCurrent());

        calculator.parseInput("20 20 20 20 *");
        assertEquals(10, numbersService.getHistory().size());
        assertEquals(Double.valueOf(400), numbersService.getCurrent());

        calculator.parseInput("6 7 5 4 -");
        assertEquals(15, numbersService.getHistory().size());
        assertEquals(Double.valueOf(1), numbersService.getCurrent());

        calculator.parseInput("ff");
        assertEquals(15, numbersService.getHistory().size());
        assertEquals(Double.valueOf(1), numbersService.getCurrent());

        calculator.parseInput("");
        assertEquals(15, numbersService.getHistory().size());
        assertEquals(Double.valueOf(1), numbersService.getCurrent());

        calculator.parseInput("    sdfsf   f       r      sdfs    ");
        assertEquals(15, numbersService.getHistory().size());
        assertEquals(Double.valueOf(1), numbersService.getCurrent());

        calculator.parseInput("           10          ");
        assertEquals(16, numbersService.getHistory().size());
        assertEquals(Double.valueOf(10), numbersService.getCurrent());
    }
}
