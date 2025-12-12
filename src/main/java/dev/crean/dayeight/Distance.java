package dev.crean.dayeight;

public class Distance {
    private final Double distance;
    private final JunctionBox first;
    private final JunctionBox second;

    public Distance(JunctionBox first, JunctionBox second) {
        this.first = first;
        this.second = second;
        this.distance = distanceBetween(first, second);
    }

    public Double distance() {
        return distance;
    }

    public JunctionBox first() {
        return first;
    }

    public JunctionBox second() {
        return second;
    }

    private static double distanceBetween(JunctionBox a, JunctionBox b) {
        return Math.sqrt(Math.pow((a.x() - b.x()), 2) + Math.pow((a.y() - b.y()), 2) + Math.pow((a.z() - b.z()), 2));
    }
}
