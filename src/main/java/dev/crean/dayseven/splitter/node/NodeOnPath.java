package dev.crean.dayseven.splitter.node;

abstract class NodeOnPath implements Node {
    private long numPathsToEnd = 0;

    public long getNumPathsToEnd() {
        return this.numPathsToEnd;
    }

    public void setNumPathsToEnd(long numPathsToEnd) {
        if (numPathsToEnd < 0) {
            throw new IllegalArgumentException("numPathsToEnd must be non-negative");
        }
        this.numPathsToEnd = numPathsToEnd;
    }
}
