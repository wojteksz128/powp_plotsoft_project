package edu.iis.powp.plot.modification;

/**
 * Do changing a center point of drawing and translate point using new position.
 */
public class TranslationPlotModification extends PlotModification {

    /**
     * New center point of translation.
     */
    private PlotPoint point;

    /**
     * Constructor of {@link TranslationPlotModification}.
     *
     * @param x value on x-axis
     * @param y value of y-axis
     */
    public TranslationPlotModification(int x, int y) {
        point = new PlotPoint(x, y);
    }

    /**
     * @see PlotModification#setUp(PlotModifier)
     */
    @Override
    public void setUp(PlotModifier plotModifier) {
        plotModifier.setCenterPoint(point);
        super.setUp(plotModifier);
    }

    /**
     * @see PlotModification#modify(PlotPoint)
     */
    @Override
    public void modify(PlotPoint point) {
        point.add(plotModifier.getCenterPoint());
    }
}
