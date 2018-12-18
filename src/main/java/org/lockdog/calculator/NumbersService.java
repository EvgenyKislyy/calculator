package org.lockdog.calculator;

import java.util.ArrayList;
import java.util.List;

public class NumbersService {

    private List<Double> numbers = new ArrayList<Double>();

    /**
     * Adding new integer to the history
     *
     * @param integer
     */
    public void add(Double integer) {
        numbers.add(integer);
    }

    /**
     * get current number
     * @return
     */
    public Double getCurrent() {
        return !numbers.isEmpty() ? numbers.get(numbers.size() - 1) : 0.0;
    }


    /**
     * get previous number
     * @return
     */
    public Double getPrevious() {
        return numbers.size() > 1 ? numbers.get(numbers.size() - 2) : 0.0;
    }

    /**
     * get all the numbers history
     * @return
     */
    public List<Double> getHistory() {
        return numbers;
    }
}
