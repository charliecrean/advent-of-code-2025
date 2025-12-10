package dev.crean.dayseven.splitter;

import dev.crean.utils.FileHandler;

import java.util.*;
import java.util.stream.IntStream;

public class Manifold {
    private final List<List<Node>> manifold = new ArrayList<>();

    public Manifold(String path) {
        FileHandler<List<Node>> handler = new FileHandler<>(path);
        handler.processFileLines(
                (line) -> new ArrayList<>(IntStream.range(0, line.length())
                        .map(line::charAt)
                        .mapToObj(c -> switch (c) {
                            case '.' -> new Dot();
                            case 'S' -> new Start();
                            case '^' -> new Split();
                            default -> null;
                        }).filter(Objects::nonNull).toList()),
                manifold::add
        );
    }

    public List<List<Node>> getManifold() {
        return manifold;
    }

    public Map<Integer, List<Integer>> getStartIndexes() {
        Map<Integer, List<Integer>> startIndexes = new HashMap<>();
        for (int i = 0; i < manifold.size(); i++) {
            List<Node> row = manifold.get(i);
            for (int j = 0; j < row.size(); j++) {
                Node node = row.get(j);
                if (node instanceof Start) {
                    startIndexes.computeIfAbsent(i, ArrayList::new).add(j);
                }
            }
        }
        return startIndexes;
    }

    public long countHitSplits() {
        return manifold.stream()
                .flatMap(List::stream)
                .filter(node -> node instanceof Split)
                .map(node -> (Split)node)
                .filter(Split::isHit)
                .count();
    }
}
