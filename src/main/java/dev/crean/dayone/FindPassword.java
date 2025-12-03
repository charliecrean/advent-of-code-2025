package dev.crean.dayone;

import dev.crean.utils.FileHandler;

public class FindPassword {

    private static final String DAY_ONE_INPUT = "aocResources/day-one-input.txt";
    private static final String DAY_ONE_SAMPLE = "aocResources/day-one-sample.txt";

    static void main() {
        runSample();
        runMain();
    }

    private static void runMain() {
        System.out.println("Running main.");

        run(DAY_ONE_INPUT);

        System.out.println("Expected password for part one: 997");
        System.out.println("Expected password for part two: 5978");
        System.out.println();
    }

    private static void runSample() {
        System.out.println("Running sample.");

        run(DAY_ONE_SAMPLE);

        System.out.println("Expected password for part one: 3");
        System.out.println("Expected password for part two: 6");
        System.out.println();
    }

    private static void run(String path) {
        Lock partOneLock = new ZeroLandingLock();
        Lock partTwoLock = new ZeroCrossingLock();

        FileHandler<LockTurn> parser = new FileHandler<>(path);
        parser.processFileLines(LockTurn::new,turn -> {
            partOneLock.turn(turn);
            partTwoLock.turn(turn);
        });

        System.out.println("Password for part one: " + partOneLock.getPassword());
        System.out.println("Password for part two: " + partTwoLock.getPassword());
    }
}

