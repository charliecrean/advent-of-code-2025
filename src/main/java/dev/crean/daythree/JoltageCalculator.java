package dev.crean.daythree;

import java.util.List;

interface JoltageCalculator {
    long calculate(List<BatteryBank> banks);
}
