package dev.crean.dayfive;

import java.util.logging.Logger;

public class CafeteriaInventoryManagement {
    static Logger log = Logger.getLogger(CafeteriaInventoryManagement.class.getName());

    private static final String SAMPLE = "aocResources/day-five-sample.txt";
    private static final String INPUT = "aocResources/day-five-input.txt";

    static void main() {
        runSample();
        runMain();
    }

    private static void runSample() {
        InventoryDatabase sampleDatabase = new InventoryDatabase(SAMPLE);
        runSamplePartOne(sampleDatabase);
        runSamplePartTwo(sampleDatabase);
    }

    private static void runSamplePartOne(InventoryDatabase sampleDatabase) {
        long expected = 3L;
        int result = sampleDatabase.getFreshProductCount();
        log.info("Number of IDs which are fresh in the sample set: " + result);
        if (result != expected) {
            throw new RuntimeException(String.format("Expected %s to be the result for the sample.", expected));
        }
    }

    private static void runSamplePartTwo(InventoryDatabase sampleDatabase) {
        long expected = 14L;
        long result = sampleDatabase.getTotalAvailableFreshIds();
        log.info(String.format("Number of available IDs in the sample set: %s", expected));
        if (result != 14) {
            throw new RuntimeException(String.format("Expected %s to be the result for the sample.", expected));
        }
    }

    private static void runMain() {
        InventoryDatabase database = new InventoryDatabase(INPUT);
        runMainPartOne(database);
        runMainPartTwo(database);
    }

    private static void runMainPartOne(InventoryDatabase database) {
        log.info("Number of IDs which are fresh in the input set: " + database.getFreshProductCount());
    }

    private static void runMainPartTwo(InventoryDatabase database) {
        log.info("Number of available IDs in the input set: " + database.getTotalAvailableFreshIds());
    }
}
