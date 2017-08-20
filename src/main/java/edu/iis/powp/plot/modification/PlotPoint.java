package edu.iis.powp.plot.modification;

/**
 * Model of point on plotter.
 */
public class PlotPoint {

    /**
     * Value on x-axis.
     */
    private int x;

    /**
     * Value on y-axis.
     */
    private int y;

    /**
     * Constructor of {@link PlotPoint}. Create copy of object.
     *
     * @param point instance of {@link PlotPoint}
     */
    public PlotPoint(PlotPoint point) {
        this.x = point.x;
        this.y = point.y;
    }

    /**
     * Constructor of {@link PlotPoint}.
     *
     * @param x new value on x-axis
     * @param y new value on y-axis
     */
    public PlotPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * {@link PlotPoint#x} getter.
     *
     * @return current value of {@link PlotPoint#x}
     */
    public int getX() {
        return x;
    }

    /**
     * {@link PlotPoint#y} getter.
     *
     * @return current value of {@link PlotPoint#y}
     */
    public int getY() {
        return y;
    }

    /**
     * Increment point coordinates used coordinates other {@link PlotPoint} object.
     *
     * @param point coords of other point
     */
    public void add(PlotPoint point) {
        this.x += point.x;
        this.y += point.y;
    }

    /**
     * Increment point coordinates used value of x and y axis from arguments.
     *
     * @param x value increment x-axis value
     * @param y value increment y-axis value
     */
    public void add(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
