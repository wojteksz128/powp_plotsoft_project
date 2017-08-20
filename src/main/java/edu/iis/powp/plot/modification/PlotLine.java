package edu.iis.powp.plot.modification;

/**
 * Model of line, created with two {@link PlotPoint}s used in modification. This line isn't draw.
 */
public class PlotLine {

    /**
     * First end of line.
     */
    private PlotPoint firstEnd;

    /**
     * Second end of line.
     */
    private PlotPoint secondEnd;

    /**
     * Constructor of {@link PlotLine}
     *
     * @param firstEnd  first end of line
     * @param secondEnd second end of line
     */
    public PlotLine(PlotPoint firstEnd, PlotPoint secondEnd) {
        this.firstEnd = firstEnd;
        this.secondEnd = secondEnd;
    }

    /**
     * {@link PlotLine#firstEnd} getter.
     *
     * @return point storied in {@link PlotLine#firstEnd}
     */
    public PlotPoint getFirstEnd() {
        return firstEnd;
    }

    /**
     * {@link PlotLine#firstEnd} setter.
     *
     * @param firstEnd new value of {@link PlotLine#firstEnd}
     */
    public void setFirstEnd(PlotPoint firstEnd) {
        this.firstEnd = firstEnd;
    }

    /**
     * {@link PlotLine#secondEnd} getter.
     *
     * @return point storied in {@link PlotLine#secondEnd}
     */
    public PlotPoint getSecondEnd() {
        return secondEnd;
    }

    /**
     * {@link PlotLine#secondEnd} setter.
     *
     * @param secondEnd new value of {@link PlotLine#secondEnd}
     */
    public void setSecondEnd(PlotPoint secondEnd) {
        this.secondEnd = secondEnd;
    }
}
