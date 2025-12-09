package dev.crean.daythree.power;

import java.util.List;

public interface JoltageCalculator {
    long calculate(List<BatteryBank> banks);
}
