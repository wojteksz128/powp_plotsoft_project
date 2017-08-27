package edu.iis.powp.plot.modification;

/**
 * Do rotate of points of plot with center point of translation storied in {@link PlotModifier}.
 */
public class RotationPlotModification extends PlotModification {

    /**
     * Angle in degrees.
     */
    private int angle;

    /**
     * Constructor of {@link RotationPlotModification}.
     *
     * @param angle angle in degrees
     */
    public RotationPlotModification(int angle) {
        this.angle = angle;
    }

    @Override
    public void setUp(PlotModifier plotModifier) {
        super.setUp(plotModifier);
    }

    /**
     * @see PlotModification#modify(PlotPoint)
     */
    @Override
    public void modify(PlotPoint point) {
        // TODO: Wojciech Szczepaniak: Do implementacji
        int x = point.getX();
        int y = point.getY();
        int xu = plotModifier.getCenterPoint().getX();
        int yu = plotModifier.getCenterPoint().getY();
        double cos = Math.cos(Math.toRadians(angle));
        double sin = Math.sin(Math.toRadians(angle));

        point.setX((int) Math.round((x - xu) * cos - (y - yu) * sin + xu));
        point.setY((int) Math.round((x - xu) * sin + (y - yu) * cos + yu));
    }
}
