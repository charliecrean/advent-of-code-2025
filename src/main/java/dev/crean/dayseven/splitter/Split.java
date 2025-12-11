package dev.crean.dayseven.splitter;

class Split implements Node {
    private boolean isHit = false;
    private long paths = 0;

    public long getPaths() {
        return this.paths;
    }

    public void setNumPaths(long count) {
        this.paths = count;
    }

    public void hit() {
        this.isHit = true;
    }

    public boolean isHit() {
        return isHit;
    }
}
