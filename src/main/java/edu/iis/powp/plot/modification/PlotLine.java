package edu.iis.powp.plot.modification;

public class PlotLine {

    private PlotPoint firstEnd;
    private PlotPoint secondEnd;

    public PlotLine(PlotPoint firstEnd, PlotPoint secondEnd) {
        this.firstEnd = firstEnd;
        this.secondEnd = secondEnd;
    }

    public PlotPoint getFirstEnd() {
        return firstEnd;
    }

    public void setFirstEnd(PlotPoint firstEnd) {
        this.firstEnd = firstEnd;
    }

    public PlotPoint getSecondEnd() {
        return secondEnd;
    }

    public void setSecondEnd(PlotPoint secondEnd) {
        this.secondEnd = secondEnd;
    }
}
