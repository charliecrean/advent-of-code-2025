package dev.crean.dayeight;

import dev.crean.utils.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class ChristmasLights {
    private final JunctionBoxConfiguration config;
    private final Set<Circuit> circuits;
    private Pair<JunctionBox> lastAddedToFormOneCircuit;

    public ChristmasLights(String inputFile) {
        this.config = new JunctionBoxConfiguration(inputFile);
        this.circuits = this.config.getJunctionBoxes().stream()
                .map(Circuit::new)
                .collect(Collectors.toSet());
        this.lastAddedToFormOneCircuit = null;
    }

    public void buildCircuits() {
        buildCircuits(-1);
    }

    public void buildCircuits(int number) {
        List<Distance> distancesByLength = config.shortestDistances(number);

        for (Distance distance : distancesByLength) {
            List<Circuit> circuits = this.circuits.stream()
                    .filter(c -> c.containsAtLeastOne(distance.first(), distance.second()))
                    .toList();

            // Merge circuits if JunctionBoxes are in different circuits
            if (circuits.size() != 1) {
                circuits.getFirst().merge(circuits.getLast());

                // Capture the last two junction boxes connected to create a single circuit
                if (this.circuits.remove(circuits.getLast()) && this.circuits.size() == 1) {
                    lastAddedToFormOneCircuit = new Pair<>(distance.first(), distance.second());
                }
            }
        }
    }

    public List<Circuit> getLargestCircuits(int limit) {
        return circuits.stream()
                .sorted((a, b) -> Double.compare(b.getJunctionBoxes().size(), a.getJunctionBoxes().size()))
                .limit(limit)
                .toList();
    }

    public Pair<JunctionBox> getLastAddedToFormOneCircuit() {
        return lastAddedToFormOneCircuit;
    }
}

