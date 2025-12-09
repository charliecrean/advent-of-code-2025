package dev.crean.daytwo.id;

import java.util.ArrayList;
import java.util.List;

public record IdRangeVerifier(IdVerificationRule rule) {

    /**
     * Verify and return all invalid IDs within the range.
     *
     */
    public List<Long> verify(IdRange idRange) {
        List<Long> output = new ArrayList<>();
        for (long i = idRange.lower(); i <= idRange.higher(); i++) {
            if (!rule.isValid(i)) {
                output.add(i);
            }
        }
        return output;
    }
}
