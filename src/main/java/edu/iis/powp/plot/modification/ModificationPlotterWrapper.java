package edu.iis.powp.plot.modification;

import edu.iis.client.plottermagic.IPlotter;

import java.util.ArrayList;
import java.util.List;

public class ModificationPlotterWrapper implements IPlotter, PlotModifier {

    private IPlotter instance;
    private List<PlotModification> modifications;
    private PlotPoint centerPoint;
    private PlotLine mirrorLine;


    public ModificationPlotterWrapper(IPlotter cpy) {
        instance = cpy;
        modifications = new ArrayList<>();
        centerPoint = new PlotPoint(0, 0);
        mirrorLine = new PlotLine(new PlotPoint(0, -100), new PlotPoint(0, 100));
    }

    @Override
    public void drawTo(int x, int y) {
        PlotPoint point = new PlotPoint(x, y);
        modifications.forEach(modification -> {
            modification.setUp(this);
            modification.modify(point);
        });
        instance.drawTo(point.getX(), point.getY());
    }

    @Override
    public void setPosition(int x, int y) {
        PlotPoint point = new PlotPoint(x, y);
        modifications.forEach(modification -> {
            modification.setUp(this);
            modification.modify(point);
        });
        instance.setPosition(point.getX(), point.getY());
    }

    @Override
    public void addModification(PlotModification modification) {
        modifications.add(modification);
    }

    @Override
    public void removeModification(PlotModification modification) {
        modifications.remove(modification);
    }

    @Override
    public List<PlotModification> getModifications() {
        return new ArrayList<>(modifications);
    }

    @Override
    public void clearModifications() {
        modifications.clear();
    }

    @Override
    public PlotPoint getCenterPoint() {
        return centerPoint;
    }

    @Override
    public void setCenterPoint(PlotPoint point) {
        this.centerPoint = point;
    }

    @Override
    public PlotLine getMirrorLine() {
        return mirrorLine;
    }

    @Override
    public void setMirrorLine(PlotLine line) {
        this.mirrorLine = line;
    }

    @Override
    public String toString() {
        return instance + " with plot modifications";
    }
}