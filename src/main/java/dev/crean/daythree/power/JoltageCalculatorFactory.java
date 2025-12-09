package dev.crean.daythree.power;

public class JoltageCalculatorFactory {
    public static JoltageCalculator createTwoDigitCalculator() {
        return new MaxJoltageCalculator(2);
    }

    public static JoltageCalculator createTwelveDigitCalculator() {
        return new MaxJoltageCalculator(12);
    }
}
