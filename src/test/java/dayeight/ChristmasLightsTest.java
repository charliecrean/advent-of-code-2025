package dayeight;

import dev.crean.dayeight.ChristmasLights;
import dev.crean.dayeight.Circuit;
import dev.crean.dayeight.JunctionBox;
import dev.crean.utils.Input;
import dev.crean.utils.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ChristmasLightsTest {

    @Test
    public void partOne() {
        ChristmasLights lights = new ChristmasLights(Input.DAY_EIGHT);
        lights.buildCircuits(1000);
        List<Circuit> largestCircuits = lights.getLargestCircuits(3);
        long result = largestCircuits.stream().mapToInt(it -> it.getJunctionBoxes().size()).reduce(1, (a, b) -> a * b);
        Assertions.assertEquals(115885, result);
    }

    @Test
    public void partTwo() {
        ChristmasLights lights = new ChristmasLights(Input.DAY_EIGHT);
        lights.buildCircuits();
        Pair<JunctionBox> lastAdded = lights.getLastAddedToFormOneCircuit();
        int result = lastAdded.first().x() * lastAdded.second().x();
        Assertions.assertEquals(274150525, result);
    }
}
