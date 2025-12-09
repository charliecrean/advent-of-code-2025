package dev.crean.daysix.calculators;

public class CephalodCalculatorFactory {

    public static CephalopodCalculator createV1() {
        return new CephalopodCalculatorV1();
    }

    public static CephalopodCalculator createV2() {
        return new CephalopodCalculatorV2();
    }
}
