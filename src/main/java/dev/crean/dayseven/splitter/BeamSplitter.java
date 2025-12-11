package dev.crean.dayseven.splitter;

import dev.crean.dayseven.splitter.node.End;
import dev.crean.dayseven.splitter.node.Node;
import dev.crean.dayseven.splitter.node.Split;
import dev.crean.dayseven.splitter.node.Start;

import java.util.*;

public class BeamSplitter {
    private final TachyonManifold manifold;

    public BeamSplitter(TachyonManifold manifold) {
        this.manifold = manifold;
    }

    public void start() {
        Start root = manifold.getRoot();
        if (root == null) {
            throw new IllegalStateException("No Start node found in manifold");
        }
        long numPaths = hit(root);
        root.setNumPathsToEnd(numPaths);
    }

    private long hit(Node current) {
        Set<Node> nodes = manifold.get(current);
        long endsHit = 0;
        if (nodes != null) {
            for (Node nextNode : nodes) {
                if (nextNode instanceof End) {
                    endsHit += 1L;
                } else if (nextNode instanceof Split split) {
                    if (!split.isHit()) {
                        split.hit();
                        long numPaths = hit(nextNode);
                        split.setNumPathsToEnd(numPaths);
                    }
                    endsHit += split.getNumPathsToEnd();
                }
            }
        }
        return endsHit;
    }

    public long getNumberOfTimelines() {
        return manifold.getRoot().getNumPathsToEnd();
    }

    public long getNumberOfBeamSplits() {
        return manifold.getManifold().stream()
                .flatMap(List::stream)
                .filter(node -> node instanceof Split)
                .map(node -> (Split) node)
                .filter(Split::isHit)
                .count();
    }
}