package dev.crean.dayseven;

import dev.crean.dayseven.splitter.BeamSplitter;
import dev.crean.dayseven.splitter.Manifold;

public class TachyonManifold  {

    String path;
    BeamSplitter splitter;
    Manifold manifold;

    public TachyonManifold(String path, BeamSplitter splitter) {
        this.path = path;
        this.manifold = new Manifold(path);
        this.splitter = splitter;
    }

    public long getNumberOfBeamSplits() {
        return splitter.getNumberOfBeamSplits(manifold);
    }

    public long getNumberOfTimelines() {
        return 0;
    }

}

