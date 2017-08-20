package edu.iis.powp.plot.modification;

import edu.iis.client.plottermagic.IPlotter;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link PlotModifier} interface used to simple modifying of plot for example: change of scale,
 * rotation, etc.
 */
public class ModificationPlotterWrapper implements IPlotter, PlotModifier {

    private IPlotter instance;
    private List<PlotModification> modifications;
    private PlotPoint centerPoint;
    private PlotLine mirrorLine;

    /**
     * Constructor of {@link ModificationPlotterWrapper}
     *
     * @param cpy object, who implements {@link IPlotter} interface
     */
    public ModificationPlotterWrapper(IPlotter cpy) {
        instance = cpy;
        modifications = new ArrayList<>();
        centerPoint = new PlotPoint(0, 0);
        mirrorLine = new PlotLine(new PlotPoint(0, -100), new PlotPoint(0, 100));
    }

    /**
     * Implementation of {@link IPlotter#drawTo(int, int)} with applying modifications storied in
     * {@link ModificationPlotterWrapper#modifications}.
     *
     * @see IPlotter#drawTo(int, int)
     *
     * @param x value on x-axis
     * @param y value on y-axis
     */
    @Override
    public void drawTo(int x, int y) {
        PlotPoint point = new PlotPoint(x, y);
        modifications.forEach(modification -> {
            modification.setUp(this);
            modification.modify(point);
        });
        instance.drawTo(point.getX(), point.getY());
    }

    /**
     * Implementation of {@link IPlotter#setPosition(int, int)} with applying modifications storied in
     * {@link ModificationPlotterWrapper#modifications}.
     *
     * @see IPlotter#setPosition(int, int)
     *
     * @param x value on x-axis
     * @param y value on y-axis
     */
    @Override
    public void setPosition(int x, int y) {
        PlotPoint point = new PlotPoint(x, y);
        modifications.forEach(modification -> {
            modification.setUp(this);
            modification.modify(point);
        });
        instance.setPosition(point.getX(), point.getY());
    }

    /**
     * @see PlotModifier#addModification(PlotModification)
     */
    @Override
    public void addModification(PlotModification modification) {
        modifications.add(modification);
    }

    /**
     * @see PlotModifier#removeModification(PlotModification)
     */
    @Override
    public void removeModification(PlotModification modification) {
        modifications.remove(modification);
    }

    /**
     * @see PlotModifier#getModifications()
     */
    @Override
    public List<PlotModification> getModifications() {
        return new ArrayList<>(modifications);
    }

    /**
     * @see PlotModifier#clearModifications()
     */
    @Override
    public void clearModifications() {
        modifications.clear();
    }

    /**
     * @see PlotModifier#getCenterPoint()
     */
    @Override
    public PlotPoint getCenterPoint() {
        return centerPoint;
    }

    /**
     * @see PlotModifier#setCenterPoint(PlotPoint)
     */
    @Override
    public void setCenterPoint(PlotPoint point) {
        this.centerPoint = point;
    }

    /**
     * @see PlotModifier#getMirrorLine()
     */
    @Override
    public PlotLine getMirrorLine() {
        return mirrorLine;
    }

    /**
     * @see PlotModifier#setMirrorLine(PlotLine)
     */
    @Override
    public void setMirrorLine(PlotLine line) {
        this.mirrorLine = line;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return instance + " with plot modifications";
    }
}