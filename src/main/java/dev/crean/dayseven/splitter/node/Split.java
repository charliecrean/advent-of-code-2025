package dev.crean.dayseven.splitter.node;

public class Split implements Node {
    private boolean isHit = false;
    private long numPathsToEnd = 0;

    public long getNumPathsToEnd() {
        return this.numPathsToEnd;
    }

    public void setNumPathsToEnd(long numPathsToEnd) {
        this.numPathsToEnd = numPathsToEnd;
    }

    public void hit() {
        this.isHit = true;
    }

    public boolean isHit() {
        return isHit;
    }
}
