package dev.crean.dayeight;

import dev.crean.utils.FileHandler;

import java.util.*;
import java.util.stream.IntStream;

class JunctionBoxConfiguration {
    private final List<JunctionBox> junctionBoxes = new ArrayList<>();

    public List<JunctionBox> getJunctionBoxes() {
        return Collections.unmodifiableList(junctionBoxes);
    }

    public JunctionBoxConfiguration(String inputFile) {
        FileHandler<String[]> fh = new FileHandler<>(inputFile);
        fh.processFileLines(
                input -> input.split(","),
                input -> junctionBoxes.add(new JunctionBox(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])))
        );
    }

    public List<Distance> shortestDistances(int limit) {
        List<Distance> distancesList = IntStream
                .range(0, junctionBoxes.size()).boxed()
                .flatMap(i -> IntStream
                        .range(i + 1, junctionBoxes.size())
                        .mapToObj(j -> new Distance(junctionBoxes.get(i), junctionBoxes.get(j))))
                .toList();
        return distancesList.stream()
                .sorted(Comparator.comparingDouble(Distance::distance))
                .limit(limit > 0 ? limit : distancesList.size())
                .toList();
    }
}
