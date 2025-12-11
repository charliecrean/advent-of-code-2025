package dev.crean.dayseven.splitter.node;

public class Start implements Node {
    private long numPathsToEnd;

    public long getNumPathsToEnd() {
        return numPathsToEnd;
    }

    public void setNumPathsToEnd(long numPathsToEnd) {
        this.numPathsToEnd = numPathsToEnd;
    }
}
