package org.lockdog.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumbersServiceTest {

    @Test
    public  void testNumber(){
        NumbersService numbersService = new NumbersService();
        assertEquals(Double.valueOf(0.0), numbersService.getCurrent());
        assertEquals(Double.valueOf(0.0), numbersService.getPrevious());
        assertTrue(numbersService.getHistory().isEmpty());

        numbersService.add(4.0);
        numbersService.add(6.0);
        assertEquals(2, numbersService.getHistory().size());

        assertEquals(Double.valueOf(6), numbersService.getCurrent());
        assertEquals(Double.valueOf(4), numbersService.getPrevious());

        numbersService.add(1000.0);
        numbersService.add(-6.0);
        assertEquals(4, numbersService.getHistory().size());

        assertEquals(Double.valueOf(-6), numbersService.getCurrent());
        assertEquals(Double.valueOf(1000), numbersService.getPrevious());

        numbersService.add(1.2);
        numbersService.add(3.5);
        numbersService.add(7.8);
        numbersService.add(-3.5);
        numbersService.add(0.0);
        assertEquals(9, numbersService.getHistory().size());

        assertEquals(Double.valueOf(0.0), numbersService.getCurrent());
        assertEquals(Double.valueOf(-3.5), numbersService.getPrevious());


    }
}
