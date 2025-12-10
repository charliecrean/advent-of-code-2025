package dev.crean.dayseven.splitter;

class Split implements Node {
    private boolean isHit = false;

    public void hit() {
        this.isHit = true;
    }

    public boolean isHit() {
        return isHit;
    }
}
