package dev.crean.dayeight;

import dev.crean.utils.Pair;
import dev.crean.utils.SampleInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

import java.util.List;

@DisabledIfEnvironmentVariable(named = "CI", matches = "true")
public class ChristmasLightsSampleTest {

    @Test
    public void partOne() {
        ChristmasLights lights = new ChristmasLights(SampleInput.DAY_EIGHT);
        lights.buildCircuits(10);
        List<Circuit> largestCircuits = lights.getLargestCircuits(3);
        long result = largestCircuits.stream().mapToInt(it -> it.getJunctionBoxes().size()).reduce(1, (a, b) -> a * b);
        Assertions.assertEquals(40, result);
    }

    @Test
    public void partTwo() {
        ChristmasLights lights = new ChristmasLights(SampleInput.DAY_EIGHT);
        lights.buildCircuits();
        Pair<JunctionBox> lastAdded = lights.getLastAddedToFormOneCircuit();
        int result = lastAdded.first().x() * lastAdded.second().x();
        Assertions.assertEquals(25272, result);
    }
}
