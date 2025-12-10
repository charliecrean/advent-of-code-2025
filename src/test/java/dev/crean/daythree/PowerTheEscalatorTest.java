package dev.crean.daythree;

import dev.crean.daythree.power.JoltageCalculatorFactory;
import dev.crean.utils.Input;
import dev.crean.utils.SampleInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

@DisabledIfEnvironmentVariable(named = "CI", matches = "true")
public class PowerTheEscalatorTest {
    @Test
    public void testSampleOne() {
        PowerTheEscalator instance = new PowerTheEscalator(SampleInput.DAY_THREE, JoltageCalculatorFactory.createTwoDigitCalculator());
        long result = instance.findJoltage();
        Assertions.assertEquals(357L, result);
    }

    @Test
    public void testSampleTwo() {
        PowerTheEscalator instance = new PowerTheEscalator(SampleInput.DAY_THREE, JoltageCalculatorFactory.createTwelveDigitCalculator());
        long result = instance.findJoltage();
        Assertions.assertEquals(3121910778619L, result);
    }

    @Test
    public void testPartOne() {
        PowerTheEscalator instance = new PowerTheEscalator(Input.DAY_THREE, JoltageCalculatorFactory.createTwoDigitCalculator());
        long result = instance.findJoltage();
        Assertions.assertEquals(17031L, result);
    }

    @Test
    public void testPartTwo() {
        PowerTheEscalator instance = new PowerTheEscalator(Input.DAY_THREE, JoltageCalculatorFactory.createTwelveDigitCalculator());
        long result = instance.findJoltage();
        Assertions.assertEquals(168575096286051L, result);
    }
}
