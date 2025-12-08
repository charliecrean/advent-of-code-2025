package dev.crean.dayfive;

class IdRange implements InventoryDatabaseRecord {
    private long low;
    private long high;

    public IdRange(long low, long high) {
        if (low > high) {
            throw new RuntimeException(String.format("Invalid input. Lost value %s should be lower than high value %s", low, high));
        }
        this.low = low;
        this.high = high;
    }

    public boolean isInRange(Id id) {
        return id.value() >= low && id.value() <= high;
    }

    public long getHigh() {
        return high;
    }

    public long getLow() {
        return low;
    }

    public void setHigh(long high) {
        this.high = high;
    }

    public void setLow(long low) {
        this.low = low;
    }
}
