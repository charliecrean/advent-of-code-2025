package dev.crean.daysix.calculators;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class CephalopodCalculatorV1 implements CephalopodCalculator {
    private final Map<Integer, CephalopodSum> sums = new HashMap<>();

    @Override
    public void addRow(String row) {
        String[] words = row.trim().split("\\s+");
        IntStream.range(0, words.length).forEach(columnIndex -> sums
                .computeIfAbsent(columnIndex, index -> new CephalopodSum())
                .addElement(words[columnIndex]));
    }

    @Override
    public Long calculate() {
        return sums.values()
                .stream()
                .mapToLong(CephalopodSum::calculate)
                .sum();
    }
}
