package edu.iis.powp.plot.modification;

import java.util.List;

import javafx.geometry.Point2D;

public class TranslationPlotModification implements PlotModification {

    int x, y;

    public TranslationPlotModification(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void modify(List<Point2D> points) {
        points.forEach(point2D -> point2D.add(x, y));
    }

}
