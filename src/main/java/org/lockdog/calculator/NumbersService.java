package org.lockdog.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NumbersService<T> {

    private List<T> numbers = new ArrayList<T>();

    public void add(T integer) {
        numbers.add(integer);
    }

    public Optional<T> getCurrent() {
        return !numbers.isEmpty() ? Optional.of(numbers.get(numbers.size()-1)) : Optional.empty();
    }

    public Optional<T> getPrevious() {
        return numbers.size() > 1 ? Optional.of(numbers.get(numbers.size()-2)) : Optional.empty();
    }

    public List<T> getHistory() {
        return numbers;
    }
}
