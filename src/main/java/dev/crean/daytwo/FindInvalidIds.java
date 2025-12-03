package dev.crean.daytwo;

import dev.crean.utils.FileHandler;

import java.util.concurrent.atomic.AtomicReference;

public class FindInvalidIds {

    private static final String DAY_TWO_INPUT = "day-two-input.txt";
    private static final String DAY_TWO_SAMPLE = "day-two-sample.txt";

    static void main() {
        runSample();
        runMain();
    }

    private static void runMain() {
        System.out.println("Running main.");
        System.out.println("Part One result: ");
        System.out.println(run(DAY_TWO_INPUT, IdCannotHaveRepeatedSequenceTwice.getInstance()));

        System.out.println("Part Two result");
        System.out.println(run(DAY_TWO_INPUT, IdCannotHaveAnyRepeatedSequence.getInstance()));
    }

    private static void runSample() {
        System.out.println("Running sample.");
        System.out.println("Part One");
        long partOneExpected = 1227775554L;
        long partOneActual = run(DAY_TWO_SAMPLE, IdCannotHaveRepeatedSequenceTwice.getInstance());
        checkResult(partOneExpected, partOneActual);

        System.out.println("Part Two");
        long partTwoExpected = 4174379265L;
        long partTwoActual = run(DAY_TWO_SAMPLE, IdCannotHaveAnyRepeatedSequence.getInstance());
        checkResult(partTwoExpected, partTwoActual);
    }

    private static void checkResult(long expected, long actual) {
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        System.out.println();
        if (actual != expected) {
            throw new IllegalStateException("Result " + actual + " does not match expected " + expected);
        }
    }

    private static long run(String path, IdVerificationRule rule) {
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

