package dev.crean.daysix;

import java.util.ArrayList;
import java.util.List;

class CephalopodSum {
    private final List<Long> nums;
    private String operation;

    public CephalopodSum() {
        this(null);
    }

    public CephalopodSum(Character operation) {
        this.nums = new ArrayList<>();
        this.operation = String.valueOf(operation);
    }

    public void addElement(String element) {
        try {
            this.nums.add(Long.parseLong(element.trim()));
        } catch (NumberFormatException e) {
            this.operation = element.trim();
        }
    }

    public Long calculate() {
        return switch (this.operation) {
            case "+" -> sum();
            case "*" -> product();
            default -> 0L;
        };
    }

    private Long sum() {
        return nums.stream().reduce(0L, Long::sum);
    }

    private Long product() {
        return nums.stream().reduce(1L, (a, b) -> a * b);
    }
}
