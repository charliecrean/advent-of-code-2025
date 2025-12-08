package dev.crean.dayfive;

class IdRange implements InventoryDatabaseRecord {
    long low;
    long high;

    public IdRange(long low, long high) {
        this.low = low;
        this.high = high;
    }
}
