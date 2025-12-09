package dev.crean.daytwo.id;

import java.util.Arrays;
import java.util.List;

public record IdRanges(List<IdRange> idRanges) {
    public IdRanges(String idRanges) {
        this(Arrays.stream(idRanges.split(","))
                .map(IdRange::new)
                .toList());
    }
}
