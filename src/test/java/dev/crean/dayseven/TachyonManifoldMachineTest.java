package dev.crean.dayseven;

import dev.crean.utils.Input;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

@DisabledIfEnvironmentVariable(named = "CI", matches = "true")
public class TachyonManifoldMachineTest {

    static TachyonManifoldMachine instance;

    @BeforeAll
    public static void setup() {
        instance = new TachyonManifoldMachine(Input.DAY_SEVEN);
        instance.start();
    }

    @Test
    public void testPartOne() {
        long result1 = instance.getNumberOfBeamSplits();
        Assertions.assertEquals(1539L, result1);
    }

    @Test
    public void testPartTwo() {
        long result2 = instance.getNumberOfTimelines();
        Assertions.assertEquals(6479180385864L, result2);
    }

}
