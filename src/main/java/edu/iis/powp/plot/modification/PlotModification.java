package edu.iis.powp.plot.modification;

import java.util.List;

import javafx.geometry.Point2D;

public interface PlotModification {
    void modify(List<Point2D> points);
}
