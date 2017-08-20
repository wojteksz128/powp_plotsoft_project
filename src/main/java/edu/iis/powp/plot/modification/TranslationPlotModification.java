package edu.iis.powp.plot.modification;

import edu.iis.powp.decorator.Modifiable;

public class TranslationPlotModification extends PlotModification {

    private PlotPoint point;

    public TranslationPlotModification(int x, int y) {
        point = new PlotPoint(x, y);
    }

    @Override
    public void setUp(Modifiable modificator) {
        if (!isInitialized()) {
            modificator.setCenterPoint(point);
        }
        super.setUp(modificator);
    }

    @Override
    public void modify(PlotPoint point) {
        point.add(modificator.getCenterPoint());
    }
}
