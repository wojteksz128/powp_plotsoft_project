package edu.iis.powp.plot.modification;

import edu.iis.powp.decorator.Modifiable;

public abstract class PlotModification {

    private boolean initialized = false;
    protected Modifiable modificator;

    public final boolean isInitialized() {
        return initialized;
    }

    public void setUp(Modifiable modificator) {
        initialized = true;
        this.modificator = modificator;
    }

    abstract public void modify(PlotPoint point);
}
