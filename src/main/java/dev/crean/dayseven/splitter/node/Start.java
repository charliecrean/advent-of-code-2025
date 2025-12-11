package dev.crean.dayseven.splitter.node;

public non-sealed class Start implements Node {
    private long numPathsToEnd;

    public long getNumPathsToEnd() {
        return numPathsToEnd;
    }

    public void setNumPathsToEnd(long numPathsToEnd) {
        if (numPathsToEnd < 0) {
            throw new IllegalArgumentException("numPathsToEnd must be non-negative");
        }
        this.numPathsToEnd = numPathsToEnd;
    }
}
