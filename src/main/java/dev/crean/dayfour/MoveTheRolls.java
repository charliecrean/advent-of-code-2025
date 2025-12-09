package dev.crean.dayfour;

import dev.crean.utils.FileHandler;
import dev.crean.utils.Input;
import dev.crean.utils.SampleInput;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MoveTheRolls {

    static Logger log = Logger.getLogger(MoveTheRolls.class.getName());

    static void main() {
        runSample();
        runMain();
    }

    private static void runSample() {
        runSamplePartOne();
        runSamplePartTwo();
    }

    private static void runSamplePartOne() {
        log.info("Running sample part one.");
        MoveableRollCounter counter = new FirstMatchMoveableCounter();
        checkResult(13, run(SampleInput.DAY_FOUR, counter));
    }

    private static void runSamplePartTwo() {
        log.info("Running sample part two.");
        MoveableRollCounter counter = new AllMatchMoveableCounter();
        checkResult(43, run(SampleInput.DAY_FOUR, counter));
    }

    private static void runMain() {
        runMainPartOne();
        runMainPartTwo();
    }

    private static void runMainPartOne() {
        MoveableRollCounter counter = new FirstMatchMoveableCounter();
        log.info("Result: " + run(Input.DAY_FOUR, counter));
    }

    private static void runMainPartTwo() {
        MoveableRollCounter counter = new AllMatchMoveableCounter();
        log.info("Result: " + run(Input.DAY_FOUR, counter));
    }

    private static void checkResult(long expected, long actual) {
        if (actual != expected) {
            log.warning("Failure. Result " + actual + " does not match expected " + expected);
            throw new IllegalStateException("Result " + actual + " does not match expected " + expected);
        }
        log.info("Success. Result: " + actual);
    }

    private static int run(String path, MoveableRollCounter counter) {
        return new RollGrid(getInputs(path), counter).compute();
    }

    private static List<List<Character>> getInputs(String path) {
        FileHandler<List<Character>> parser = new FileHandler<>(path);
        List<List<Character>> inputs = new ArrayList<>();
        parser.processFileLines(MoveTheRolls::parseRolls, inputs::add);
        return inputs;
    }

    private static List<Character> parseRolls(String input) {
        return input.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }
}

