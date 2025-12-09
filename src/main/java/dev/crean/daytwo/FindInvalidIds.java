package dev.crean.daytwo;

import dev.crean.daytwo.id.IdRangeVerifier;
import dev.crean.daytwo.id.IdRanges;
import dev.crean.daytwo.id.IdVerificationRule;
import dev.crean.utils.FileHandler;

import java.util.concurrent.atomic.AtomicReference;

public class FindInvalidIds {
    private final String path;
    private final IdVerificationRule rule;

    public FindInvalidIds(String path, IdVerificationRule rule) {
        this.path = path;
        this.rule = rule;
    }

    public long find() {
        FileHandler<IdRanges> parser = new FileHandler<>(path);
        AtomicReference<IdRanges> ranges = new AtomicReference<>();
        parser.processFileLines(IdRanges::new, ranges::set);

        IdRangeVerifier verifier = new IdRangeVerifier(rule);

        return ranges.get().idRanges().stream()
                .flatMap(range -> verifier.verify(range).stream())
                .mapToLong(Long::longValue)
                .sum();
    }
}

