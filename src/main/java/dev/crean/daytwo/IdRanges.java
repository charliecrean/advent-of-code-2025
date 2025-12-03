package dev.crean.daytwo;

import java.util.Arrays;
import java.util.List;

record IdRanges(List<IdRange> idRanges) {
    IdRanges(String idRanges) {
        this(Arrays.stream(idRanges.split(","))
                .map(IdRange::new)
                .toList());
    }
}
