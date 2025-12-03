package dev.crean.daythree;

import dev.crean.utils.FileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class PowerTheEscalator {

    static Logger log = Logger.getLogger(PowerTheEscalator.class.getName());

    private static final String DAY_THREE_SAMPLE = "aocResources/day-three-sample.txt";
    private static final String DAY_THREE_INPUT = "aocResources/day-three-input.txt";

    static void main() {
        runSample();
        runMain();
    }

    private static void runMain() {
        runMainPartOne();
        runMainPartTwo();
    }

    private static void runMainPartOne() {
        JoltageCalculator twoDigitCalculator = new MaxJoltageCalculator(2);
        log.info("Result: " + run(DAY_THREE_INPUT, twoDigitCalculator));
    }

    private static void runMainPartTwo() {
        JoltageCalculator twelveDigitCalculator = new MaxJoltageCalculator(12);
        log.info("Result: " + run(DAY_THREE_INPUT, twelveDigitCalculator));
    }

    private static void runSample() {
        runSamplePartOne();
        runSamplePartTwo();
    }

    private static void runSamplePartOne() {
        log.info("Running sample part one.");
        JoltageCalculator twoDigitCalculator = new MaxJoltageCalculator(2);
        checkResult(357, run(DAY_THREE_SAMPLE, twoDigitCalculator));
    }

    private static void runSamplePartTwo() {
        log.info("Running sample part two.");
        JoltageCalculator twelveDigitCalculator = new MaxJoltageCalculator(12);
        checkResult(3121910778619L, run(DAY_THREE_SAMPLE, twelveDigitCalculator));
    }

    private static void checkResult(long expected, long actual) {
        if (actual != expected) {
            log.warning("Failure. Result " + actual + " does not match expected " + expected);
            throw new IllegalStateException("Result " + actual + " does not match expected " + expected);
        }
        log.info("Success. Result: " + actual);
    }

    private static long run(String path, JoltageCalculator joltageCalculator) {
        return joltageCalculator.calculate(getInputs(path));
    }

    private static List<BatteryBank> getInputs(String path) {
        FileHandler<BatteryBank> parser = new FileHandler<>(path);
        List<BatteryBank> inputs = new ArrayList<>();
        parser.processFileLines(PowerTheEscalator::parseBatteryBank, inputs::add);
        return inputs;
    }

    private static BatteryBank parseBatteryBank(String input) {
        return new BatteryBank(getIntegerValuesFromInput(input));
    }

    private static List<Integer> getIntegerValuesFromInput(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}

