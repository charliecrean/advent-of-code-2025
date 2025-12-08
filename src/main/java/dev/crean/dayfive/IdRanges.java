package dev.crean.dayfive;

import java.util.ArrayList;
import java.util.List;

class IdRanges {
    private final List<IdRange> storedRanges = new ArrayList<>();

    public void add(IdRange inputRange) {
        long start = inputRange.getLow();
        long end = inputRange.getHigh();

        if (storedRanges.isEmpty()) {
            storedRanges.add(inputRange);
            return;
        }

        IdRange startCoveringRange = null;
        IdRange endCoveringRange = null;
        List<IdRange> coveredRanges = new ArrayList<>();

        // Identify stored ranges overlapping with the new range
        for (IdRange storedRange : storedRanges) {
            if (start >= storedRange.getLow() && start <= storedRange.getHigh()) {
                startCoveringRange = storedRange;
            }

            if (end >= storedRange.getLow() && end <= storedRange.getHigh()) {
                endCoveringRange = storedRange;
            }

            if (storedRange.getLow() > inputRange.getLow() && storedRange.getHigh() < inputRange.getHigh()) {
                coveredRanges.add(storedRange);
            }
        }

        // discard any ranges covered by the new range
        storedRanges.removeAll(coveredRanges);

        if (startCoveringRange == null && endCoveringRange == null) {
            // Add independent range.
            storedRanges.add(inputRange);
        } else if (startCoveringRange == null) {
            // extend range where the end of the new range falls
            endCoveringRange.setLow(inputRange.getLow());
        } else if (endCoveringRange == null) {
            // extend range where the start of the new range falls
            startCoveringRange.setHigh(inputRange.getHigh());
        } else if(startCoveringRange != endCoveringRange) {
            // Merge ranges linked by the new range
            storedRanges.remove(endCoveringRange);
            startCoveringRange.setHigh(endCoveringRange.getHigh());
        }
    }

    public boolean isPresent(Id id) {
        return storedRanges.stream().anyMatch(range -> range.isInRange(id));
    }

    public long getAvailableIdCount() {
        return storedRanges.stream().mapToLong(range -> (range.getHigh() - range.getLow()) + 1).sum();
    }
}
