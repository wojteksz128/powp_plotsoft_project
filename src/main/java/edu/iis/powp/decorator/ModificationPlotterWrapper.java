package edu.iis.powp.decorator;

import edu.iis.powp.plot.modification.PlotLine;
import edu.iis.powp.plot.modification.PlotPoint;
import javafx.geometry.Point2D;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.plot.modification.PlotModification;

public class ModificationPlotterWrapper implements IPlotter, Modifiable {

    private IPlotter instance;
    private List<Point2D> points;
    private List<IPlotterCommand> commands;
    private Map<PlotModification, Boolean> modifications;
    private PlotPoint centerPoint;
    private PlotLine mirrorLine;


    public ModificationPlotterWrapper(IPlotter cpy) {
        instance = cpy;
        points = new ArrayList<>();
        commands = new ArrayList<>();
    }

    @Override
    public void drawTo(int arg0, int arg1) {
        instance.drawTo(arg0, arg1);
        points.add(new Point2D(arg0, arg1));
        commands.add(new DrawToCommand(arg0, arg1));
    }

    @Override
    public void setPosition(int arg0, int arg1) {
        instance.setPosition(arg0, arg1);
        points.add(new Point2D(arg0, arg1));
        commands.add(new SetPositionCommand(arg0, arg1));
    }

    @Override
    public void addModification(PlotModification modification) {
        modifications.put(modification, false);
    }

    @Override
    public void removeModification(PlotModification modification) {
        modifications.remove(modification);
    }

    @Override
    public List<PlotModification> getModifications() {
        return new ArrayList<>(modifications.keySet());
    }

    @Override
    public void clearModifications() {
        modifications.clear();
    }

    @Override
    public void setCenterPoint(PlotPoint point) {
        this.centerPoint = point;
    }

    @Override
    public void setMirrorLine(PlotLine line) {
        this.mirrorLine = line;
    }

    private List<IPlotterCommand> getCommands() {
        try {
            List<IPlotterCommand> newCommands = new ArrayList<>();
            for (int i = 0; i < points.size(); ++i) {
                newCommands.add(commands.get(i).getClass().getConstructor(int.class, int.class)
                        .newInstance((int) points.get(i).getX(), (int) points.get(i).getY()));
            }
            return newCommands;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return instance + " with plot modifications";
    }
}