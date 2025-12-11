package dev.crean.dayseven.splitter.node;

public final class Split extends NodeOnPath {
    private boolean isHit = false;

    public void hit() {
        this.isHit = true;
    }

    public boolean isHit() {
        return isHit;
    }
}
