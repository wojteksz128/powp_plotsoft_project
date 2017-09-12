package edu.iis.powp.plot.modification;

/**
 * Move points to change a scale of plotted image used the center point of translation storied in {@link PlotModifier}.
 */
public class ScalePlotModification extends PlotModification {

    /**
     * Instance of similar plot modification - {@link StretchPlotModification}.
     */
    private final StretchPlotModification stretchPlotModification;

    /**
     * Scale of plot
     */
    private float scale;

    public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
		stretchPlotModification.setxAxis(scale);
		stretchPlotModification.setyAxis(scale);
	}

	/**
     * Constructor of {@link ScalePlotModification}.
     *
     * @param scale scale of plot.
     */
    public ScalePlotModification(float scale) {
        this.scale = scale;
        this.stretchPlotModification = new StretchPlotModification(scale, scale);
    }

    @Override
    public void setUp(PlotModifier plotModifier) {
        super.setUp(plotModifier);
        stretchPlotModification.setUp(plotModifier);
    }

    /**
     * @see PlotModification#modify(PlotPoint)
     */
    @Override
    public void modify(PlotPoint point) {
        stretchPlotModification.modify(point);
    }
}
