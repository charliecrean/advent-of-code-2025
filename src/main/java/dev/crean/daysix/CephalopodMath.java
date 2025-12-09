package dev.crean.daysix;


import dev.crean.daysix.calculators.CephalodCalculatorFactory;
import dev.crean.daysix.calculators.CephalopodCalculator;
import dev.crean.utils.FileHandler;

import java.util.function.Function;

public class CephalopodMath {
    private final String file;

    public CephalopodMath(String file) {
        this.file = file;
    }

    public long runPartOne() {
        return run(CephalodCalculatorFactory.createV1());
    }

    public long runPartTwo() {
        return run(CephalodCalculatorFactory.createV2());
    }

    private long run(CephalopodCalculator calculator) {
        FileHandler<String> mathFileHandler = new FileHandler<>(file);
        mathFileHandler.processFileLines(Function.identity(), calculator::addRow);
        return calculator.calculate();
    }
}

