package dev.crean.dayseven.splitter;

import dev.crean.dayseven.splitter.node.*;
import dev.crean.utils.FileHandler;

import java.util.*;
import java.util.stream.IntStream;

public class TachyonManifold {
    private final List<List<Node>> manifold = new ArrayList<>();
    private final Map<Node, Set<Node>> nodeGraph = new HashMap<>();
    private Start root = null;

    public TachyonManifold(String path) {
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

        // Add a base row of end markers
        manifold.add(IntStream
                .range(0, manifold.getLast().size())
                .mapToObj(it -> (Node) new End())
                .toList());

        this.buildGraph();
    }

    public List<List<Node>> getManifold() {
        return manifold;
    }

    public Start getRoot() {
        return root;
    }

    public Set<Node> get(Node node) {
        return nodeGraph.get(node);
    }

    private void buildGraph() {
        for (int rowIndex = 0; rowIndex < manifold.size(); rowIndex++) {
            List<Node> nodes = manifold.get(rowIndex);
            for (int columnIndex = 0; columnIndex < nodes.size(); columnIndex++) {
                Node node = nodes.get(columnIndex);
                if (node instanceof Start start) {
                    this.root = start;
                    findNext(node, rowIndex + 1, columnIndex);
                } else if (node instanceof Split) {
                    findNext(node, rowIndex + 1, columnIndex - 1);
                    findNext(node, rowIndex + 1, columnIndex + 1);
                }
            }
        }
    }

    private void findNext(Node parent, int rowIndex, int columnIndex) {
        if (columnIndex < 0 || columnIndex >= manifold.getLast().size()) {
            return;
        }
        for (int j = rowIndex; j < manifold.size(); j++) {
            Node currNode = manifold.get(j).get(columnIndex);
            if (currNode instanceof Split || currNode instanceof End) {
                nodeGraph.computeIfAbsent(parent, k -> new HashSet<>()).add(currNode);
                break;
            }
        }
    }
}
