package dev.crean.dayeight;

import java.util.*;

public class Circuit {
    private final Set<JunctionBox> junctionBoxes;

    public Circuit(JunctionBox jb) {
        this.junctionBoxes = new HashSet<>();
        this.junctionBoxes.add(jb);
    }

    public boolean containsAtLeastOne(JunctionBox a, JunctionBox b) {
        return junctionBoxes.contains(a) || junctionBoxes.contains(b);
    }

    public void merge(Circuit circuit) {
        junctionBoxes.addAll(circuit.getJunctionBoxes());
    }

    public Set<JunctionBox> getJunctionBoxes() {
        return Collections.unmodifiableSet(junctionBoxes);
    }
}
