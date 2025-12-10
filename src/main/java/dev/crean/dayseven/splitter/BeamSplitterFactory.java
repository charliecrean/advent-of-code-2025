package dev.crean.dayseven.splitter;

import java.util.List;
import java.util.Map;

public class BeamSplitterFactory {

    public static BeamSplitter create() {
        return new Splitter();
    }

    private static class Splitter implements BeamSplitter {

        @Override
        public long getNumberOfBeamSplits(Manifold manifold) {
            Map<Integer, List<Integer>> startIndexes = manifold.getStartIndexes();

            for (Integer rowIndex : startIndexes.keySet()) {
                List<Integer> columnIndexes = startIndexes.get(rowIndex);

                for (Integer columnIndex : columnIndexes) {
                    fireBeam(rowIndex + 1, columnIndex, manifold);
                }
            }
            return manifold.countHitSplits();
        }

        private void fireBeam(Integer rowIndex, Integer columnIndex, Manifold manifold) {
            List<List<Node>> nodes = manifold.getManifold();
            if (rowIndex < nodes.size()) {
                for (int i = rowIndex; i < nodes.size(); i++) {
                    List<Node> row = nodes.get(i);
                    if (columnIndex < row.size()) {
                        Node node = row.get(columnIndex);
                        switch (node) {
                            case Dot _ -> row.set(columnIndex, new Beam());
                            case Split s -> {
                                s.hit();
                                fireBeam(i, columnIndex - 1, manifold);
                                fireBeam(i, columnIndex + 1, manifold);
                                return;
                            }
                            case Beam _ -> {
                                return;
                            }
                            default -> throw new IllegalStateException("Unexpected value: " + node);
                        }
                    }
                }
            }
        }
    }
}
