package dev.crean.daysix;

import dev.crean.utils.Input;
import dev.crean.utils.SampleInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

@DisabledIfEnvironmentVariable(named = "CI", matches = "true")
public class CephalopodMathTest {

    @Test
    public void testSampleOne() {
        CephalopodMath instance = new CephalopodMath(SampleInput.DAY_SIX);
        long result = instance.runPartOne();
        Assertions.assertEquals(4277556L, result);
    }

    @Test
    public void testSampleTwo() {
        CephalopodMath instance = new CephalopodMath(SampleInput.DAY_SIX);
        long result = instance.runPartTwo();
        Assertions.assertEquals(3263827L, result);
    }

    @Test
    public void testPartOne() {
        CephalopodMath instance = new CephalopodMath(Input.DAY_SIX);
        long result = instance.runPartOne();
        Assertions.assertEquals(6299564383938L, result);
    }

    @Test
    public void testPartTwo() {
        CephalopodMath instance = new CephalopodMath(Input.DAY_SIX);
        long result = instance.runPartTwo();
        Assertions.assertEquals(11950004808442L, result);
    }

}
