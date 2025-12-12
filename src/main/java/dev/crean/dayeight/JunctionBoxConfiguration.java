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
                parts -> {
                    if (parts.length != 3) {
                        throw new IllegalArgumentException("Expected 3 comma-separated ints per line, got: " + Arrays.toString(parts));
                    }
                    int x = Integer.parseInt(parts[0].trim());
                    int y = Integer.parseInt(parts[1].trim());
                    int z = Integer.parseInt(parts[2].trim());
                    junctionBoxes.add(new JunctionBox(x, y, z));
                }
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
