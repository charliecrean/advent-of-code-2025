package dev.crean.dayfive;

import dev.crean.utils.FileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

class InventoryDatabase {
    private static final Logger log = Logger.getLogger(InventoryDatabase.class.getName());

    private final List<Id> ids;
    private final IdRanges idRanges;

    public InventoryDatabase(String sourceFile) {
        ids = new ArrayList<>();
        idRanges = new IdRanges();

        parseInput(sourceFile);
    }

    private void parseInput(String file) {
        FileHandler<InventoryDatabaseRecord> handler = new FileHandler<>(file);
        AtomicBoolean processingIds = new AtomicBoolean(false);

        log.info("Building database from file: " + file);
        handler.processFileLines((String line) -> {
            if (line.trim().isEmpty()) {
                processingIds.set(true);
                return null;
            } else if (processingIds.get()) {
                return new Id(Long.parseLong(line));
            } else {
                String[] parts = line.trim().split("-");
                return new IdRange(Long.parseLong(parts[0]), Long.parseLong(parts[1]));
            }
        }, (inventoryObj) -> {
            if (inventoryObj instanceof Id) {
                ids.add((Id) inventoryObj);
            } else if (inventoryObj instanceof IdRange) {
                idRanges.add((IdRange) inventoryObj);
            }
        });
    }

    public long getFreshProductCount() {
        return ids.stream().filter(idRanges::isPresent).count();
    }

    public long getTotalAvailableFreshIds() {
        return idRanges.getAvailableIdCount();
    }
}
