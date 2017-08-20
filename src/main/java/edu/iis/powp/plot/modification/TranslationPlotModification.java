package edu.iis.powp.plot.modification;

import edu.iis.powp.decorator.PlotModifier;

public class TranslationPlotModification extends PlotModification {

    private PlotPoint point;

    public TranslationPlotModification(int x, int y) {
        point = new PlotPoint(x, y);
    }

    @Override
    public void setUp(PlotModifier plotModifier) {
        if (!isInitialized()) {
            plotModifier.setCenterPoint(point);
        }
        super.setUp(plotModifier);
    }

    @Override
    public void modify(PlotPoint point) {
        point.add(plotModifier.getCenterPoint());
    }
}
