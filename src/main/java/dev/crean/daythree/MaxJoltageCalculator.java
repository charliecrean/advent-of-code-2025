package dev.crean.daythree;

import java.util.List;

record MaxJoltageCalculator(int numDigits) implements JoltageCalculator {

    @Override
    public long calculate(List<BatteryBank> banks) {
        return banks.stream().mapToLong(this::calculate).sum();
    }

    private long calculate(BatteryBank bank) {
        int[] digits = new int[numDigits];
        int lastIndex = -1;

        for (int i = 0; i < numDigits; i++) {
            int maxIndex = -1;
            int max = Integer.MIN_VALUE;

            for (int j = lastIndex + 1; j <= bank.values().size() - (numDigits - i); j++) {
                int current = bank.values().get(j);

                if (current > max) {
                    maxIndex = j;
                    max = current;
                }
            }

            digits[i] = max;
            lastIndex = maxIndex;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : digits) {
            sb.append(i);
        }
        return Long.parseLong(sb.toString());
    }
}
