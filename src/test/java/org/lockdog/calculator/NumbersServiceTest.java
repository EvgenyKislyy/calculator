package org.lockdog.calculator;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumbersServiceTest {

    @Test
    public  void testNumber(){
        NumbersService<Double> numbersService = new NumbersService<>();
        assertEquals(Optional.empty(), numbersService.getCurrent());
        assertEquals(Optional.empty(), numbersService.getPrevious());
        assertTrue(numbersService.getHistory().isEmpty());

        numbersService.add(4.0);
        numbersService.add(6.0);
        assertEquals(2, numbersService.getHistory().size());

        assertEquals(Double.valueOf(6), numbersService.getCurrent().get());
        assertEquals(Double.valueOf(4), numbersService.getPrevious().get());

        numbersService.add(1000.0);
        numbersService.add(-6.0);
        assertEquals(4, numbersService.getHistory().size());

        assertEquals(Double.valueOf(-6), numbersService.getCurrent().get());
        assertEquals(Double.valueOf(1000), numbersService.getPrevious().get());


    }
}
