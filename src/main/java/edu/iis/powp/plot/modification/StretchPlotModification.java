package edu.iis.powp.plot.modification;

/**
 * Do stretching a plot image.
 */
public class StretchPlotModification extends PlotModification {

    /**
     * X-axis stretching scale. If {@code 1.0}, then no stretching.
     */
    private float xAxis;

    public float getxAxis() {
		return xAxis;
	}

	public void setxAxis(float xAxis) {
		this.xAxis = xAxis;
	}

	public float getyAxis() {
		return yAxis;
	}

	public void setyAxis(float yAxis) {
		this.yAxis = yAxis;
	}

	/**
     * Y-axis stretching scale. If {@code 1.0}, then no stretching.
     */
    private float yAxis;

    /**
     * Constructor of {@link StretchPlotModification}.
     *
     * @param xAxis x-axis stretching scale. If {@code 1.0}, then no stretching.
     * @param yAxis y-axis stretching scale. If {@code 1.0}, then no stretching.
     */
    public StretchPlotModification(float xAxis, float yAxis) {
        if (xAxis < 0 || yAxis < 0) {
            throw new IllegalArgumentException("Stretching scale must be unsigned value");
        }
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    /**
     * @see PlotModification#modify(PlotPoint)
     */
    @Override
    public void modify(PlotPoint point) {
        int x = point.getX() - plotModifier.getCenterPoint().getX();
        int y = point.getY() - plotModifier.getCenterPoint().getY();

        int x1 = Math.round((xAxis - 1) * x);
        int y1 = Math.round((yAxis - 1) * y);
        point.add(x1, y1);
    }
}
