package dev.crean.daytwo;

import java.util.HashSet;
import java.util.Set;

class IdCannotHaveAnyRepeatedSequence implements IdVerificationRule {
    private static final IdVerificationRule INSTANCE = new IdCannotHaveAnyRepeatedSequence();

    private IdCannotHaveAnyRepeatedSequence() {}

    public static IdVerificationRule getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean isValid(long id) {
        String idString = Long.toString(id);
        int length = idString.length();
        int split = 2;

        while (length >= split) {
            if (length % split == 0) {
                Set<String> substrings = new HashSet<>();
                int substringLength = length / split;
                int numSubstrings = length / substringLength;
                for (int i = 0; i < numSubstrings; i++) {
                    substrings.add(idString.substring(i * substringLength, (i + 1) * substringLength));
                    if (substrings.size() > 1) {
                        break;
                    }
                }
                if (substrings.size() == 1) {
                    return false;
                }
            }
            split++;
        }

        return true;
    }
}
