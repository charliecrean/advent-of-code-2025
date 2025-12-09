package dev.crean.daysix;


import dev.crean.utils.FileHandler;
import dev.crean.utils.Input;
import dev.crean.utils.SampleInput;

import java.util.logging.Logger;

public class CephalopodMath {
    static Logger log = Logger.getLogger(CephalopodMath.class.getName());

    static void main() {
        runSample();
        runMain();
    }

    public static long runPartOne(String file) {
        CephalopodPartOneCalculator calculator = new CephalopodPartOneCalculator();
        FileHandler<Void> mathFileHandler = new FileHandler<>(file);
        mathFileHandler.processFileLines((line) -> {
            String[] words = line.trim().split("\\s+");
            for (int i = 0; i < words.length; i++) {
                calculator.addElement(i, words[i]);
            }
            return null;
        }, _ -> { });

        return calculator.calculate();
    }

    public static long runPartTwo(String file) {
        CephalopodPartTwoCalculator calculator = new CephalopodPartTwoCalculator();
        FileHandler<Void> mathFileHandler = new FileHandler<>(file);
        mathFileHandler.processFileLines((line) -> {
            calculator.addRow(line);
            return null;
        }, _ -> { });

        return calculator.calculate();
    }

    private static void runSample() {
        runSamplePartOne();
        runSamplePartTwo();
    }

    private static void runSamplePartOne() {
        long expected = 4277556L;
        long result = runPartOne(SampleInput.DAY_SIX);

        log.info("Result: " + result);
        if (result != expected) {
            throw new RuntimeException("Bad result. Expected " + expected);
        }
    }

    private static void runSamplePartTwo() {
        long expected = 3263827L;
        long result = runPartTwo(SampleInput.DAY_SIX);

        log.info("Result: " + result);
        if (result != expected) {
            throw new RuntimeException("Bad result. Expected " + expected);
        }
    }

    private static void runMain() {
        runMainPartOne();
        runMainPartTwo();
    }

    private static void runMainPartOne() {
        long expected = 6299564383938L; // answer for my specific input set
        long result = runPartOne(Input.DAY_SIX);

        log.info("Result: " + result);
        if (result != expected) {
            throw new RuntimeException("Bad result. Expected " + expected);
        }
    }

    private static void runMainPartTwo() {
        long expected = 11950004808442L;
        long result = runPartTwo(Input.DAY_SIX);

        log.info("Result: " + result);
        if (result != expected) {
            throw new RuntimeException("Bad result. Expected " + expected);
        }
    }

}

