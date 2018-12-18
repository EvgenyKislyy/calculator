package org.lockdog.calculator;

import java.util.ArrayList;
import java.util.List;

public class NumbersService {

    private List<Double> numbers = new ArrayList<Double>();

    public void add(Double integer) {
        numbers.add(integer);
    }

    public Double getCurrent() {
        return !numbers.isEmpty() ? numbers.get(numbers.size() - 1) : 0.0;
    }

    public Double getPrevious() {
        return numbers.size() > 1 ? numbers.get(numbers.size() - 2) : 0.0;
    }

    public List<Double> getHistory() {
        return numbers;
    }
}
