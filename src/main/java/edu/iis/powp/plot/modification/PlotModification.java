package edu.iis.powp.plot.modification;

public abstract class PlotModification {

    /**
     * Instance of {@link PlotModifier} object.
     */
    protected PlotModifier plotModifier;

    /**
     * Initialize configuration of modification.
     *
     * @param plotModifier instance of {@link PlotModifier} object
     */
    public void setUp(PlotModifier plotModifier) {
        this.plotModifier = plotModifier;
    }

    /**
     * Action of modification of point.
     *
     * @param point modified point
     */
    abstract public void modify(PlotPoint point);
}
