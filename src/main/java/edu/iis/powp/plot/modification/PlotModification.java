package edu.iis.powp.plot.modification;

public abstract class PlotModification {

    PlotModifier plotModifier;
    private boolean initialized = false;

    final boolean isInitialized() {
        return initialized;
    }

    public void setUp(PlotModifier plotModifier) {
        initialized = true;
        this.plotModifier = plotModifier;
    }

    abstract public void modify(PlotPoint point);
}
