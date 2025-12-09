package dev.crean.daysix;

import java.util.HashMap;
import java.util.Map;

class CephalopodPartOneCalculator {
    private final Map<Integer, CephalopodSum> sums;

    public CephalopodPartOneCalculator() {
        this.sums = new HashMap<>();
    }

    public void addElement(int columnIndex, String value) {
        sums.computeIfAbsent(columnIndex, _ -> new CephalopodSum()).addElement(value);
    }

    public Long calculate() {
        return sums.values().stream().mapToLong(CephalopodSum::calculate).sum();
    }
}
