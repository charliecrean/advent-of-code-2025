package dev.crean.dayseven;

import dev.crean.dayseven.splitter.BeamSplitterFactory;
import dev.crean.utils.Input;
import dev.crean.utils.SampleInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

@DisabledIfEnvironmentVariable(named = "CI", matches = "true")
public class TachyonManifoldTest {

    @Test
    public void testSampleOne() {
        TachyonManifold instance = new TachyonManifold(SampleInput.DAY_SEVEN, BeamSplitterFactory.create());
        long result = instance.getNumberOfBeamSplits();
        Assertions.assertEquals(21L, result);
    }

    @Test
    @Disabled
    public void testSampleTwo() {
        TachyonManifold instance = new TachyonManifold(SampleInput.DAY_SEVEN, BeamSplitterFactory.create());
        long result = instance.getNumberOfTimelines();
        Assertions.assertEquals(40L, result);
    }

    @Test
    public void testPartOne() {
        TachyonManifold instance = new TachyonManifold(Input.DAY_SEVEN, BeamSplitterFactory.create());
        long result = instance.getNumberOfBeamSplits();
        Assertions.assertEquals(1539L, result);
    }

    @Test
    @Disabled
    public void testPartTwo() {
        TachyonManifold instance = new TachyonManifold(Input.DAY_SEVEN, BeamSplitterFactory.create());
        long result = instance.getNumberOfBeamSplits();
        Assertions.assertEquals(0L, result);
    }

}
