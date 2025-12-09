package dev.crean.daythree;

import dev.crean.daythree.power.BatteryBank;
import dev.crean.daythree.power.JoltageCalculator;
import dev.crean.utils.FileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class PowerTheEscalator {
    private final String path;
    private final JoltageCalculator joltageCalculator;

    public PowerTheEscalator(String path, JoltageCalculator joltageCalculator) {
        this.path = path;
        this.joltageCalculator = joltageCalculator;
    }

    public long findJoltage() {
        return joltageCalculator.calculate(getInputs(path));
    }

    private List<BatteryBank> getInputs(String path) {
        FileHandler<BatteryBank> parser = new FileHandler<>(path);
        List<BatteryBank> inputs = new ArrayList<>();
        parser.processFileLines(this::parseBatteryBank, inputs::add);
        return inputs;
    }

    private BatteryBank parseBatteryBank(String input) {
        return new BatteryBank(getIntegerValuesFromInput(input));
    }

    private List<Integer> getIntegerValuesFromInput(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}

