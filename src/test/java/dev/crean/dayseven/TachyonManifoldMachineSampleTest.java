package dev.crean.dayseven;

import dev.crean.utils.SampleInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

@DisabledIfEnvironmentVariable(named = "CI", matches = "true")
public class TachyonManifoldMachineSampleTest {

    static TachyonManifoldMachine instance;

    @BeforeAll
    public static void setup() {
        instance = new TachyonManifoldMachine(SampleInput.DAY_SEVEN);
        instance.start();
    }

    @Test
    public void testSampleOne() {
        long result = instance.getNumberOfBeamSplits();
        Assertions.assertEquals(21L, result);
    }

    @Test
    public void testSampleTwo() {
        long result = instance.getNumberOfTimelines();
        Assertions.assertEquals(40L, result);
    }

}
