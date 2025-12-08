package dev.crean.dayfive;

import java.util.ArrayList;
import java.util.List;

class IdRanges {
    private final List<IdRange> storedRanges = new ArrayList<>();

    public void add(IdRange inputRange) {
        long start = inputRange.low;
        long end = inputRange.high;

        if (storedRanges.isEmpty()) {
            storedRanges.add(inputRange);
            return;
        }

        IdRange startCoveringRange = null;
        IdRange endCoveringRange = null;
        List<IdRange> coveredRanges = new ArrayList<>();

        // Identify stored ranges overlapping with the new range
        for (IdRange storedRange : storedRanges) {
            if (start >= storedRange.low && start <= storedRange.high) {
                startCoveringRange = storedRange;
            }

            if (end >= storedRange.low && end <= storedRange.high) {
                endCoveringRange = storedRange;
            }

            if (storedRange.low > inputRange.low && storedRange.high < inputRange.high) {
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
            endCoveringRange.low = inputRange.low;
        } else if (endCoveringRange == null) {
            // extend range where the start of the new range falls
            startCoveringRange.high = inputRange.high;
        } else if(startCoveringRange != endCoveringRange) {
            // Merge ranges linked by the new range
            storedRanges.remove(endCoveringRange);
            startCoveringRange.high = endCoveringRange.high;
        }
    }

    public boolean isPresent(Id id) {
        return storedRanges.stream().anyMatch(idRange -> id.value >= idRange.low && id.value <= idRange.high);
    }

    public long getAvailableIdCount() {
        return storedRanges.stream().mapToLong(range -> (range.high - range.low) + 1).sum();
    }
}
