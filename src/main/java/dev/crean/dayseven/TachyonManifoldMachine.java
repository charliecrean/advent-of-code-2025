package dev.crean.dayseven;

import dev.crean.dayseven.splitter.BeamSplitter;
import dev.crean.dayseven.splitter.TachyonManifold;

public class TachyonManifoldMachine {
    private final BeamSplitter splitter;

    public TachyonManifoldMachine(String path) {
        TachyonManifold manifold = new TachyonManifold(path);
        this.splitter = new BeamSplitter(manifold);
    }

    public void start() {
        this.splitter.start();
    }

    public long getNumberOfBeamSplits() {
        return this.splitter.getNumberOfBeamSplits();
    }

    public long getNumberOfTimelines() {
        return this.splitter.getNumberOfTimelines();
    }
}

