package edu.iis.powp.plot.modification;

public class PlotPoint {

    private int x;
    private int y;

    public PlotPoint(PlotPoint point) {
        this.x = point.x;
        this.y = point.y;
    }

    public PlotPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void add(PlotPoint point) {
        this.x += point.x;
        this.y += point.y;
    }

    public void add(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
