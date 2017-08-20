package edu.iis.powp.plot.modification;

import edu.iis.powp.decorator.PlotModifier;

public abstract class PlotModification {

    private boolean initialized = false;
    PlotModifier plotModifier;

    final boolean isInitialized() {
        return initialized;
    }

    public void setUp(PlotModifier plotModifier) {
        initialized = true;
        this.plotModifier = plotModifier;
    }

    abstract public void modify(PlotPoint point);
}
