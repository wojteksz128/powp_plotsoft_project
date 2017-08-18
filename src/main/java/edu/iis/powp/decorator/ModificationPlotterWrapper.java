package edu.iis.powp.decorator;

import javafx.geometry.Point2D;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.plot.modification.PlotModification;

public class ModificationPlotterWrapper implements IPlotter, Modifiable {

    private IPlotter instance;
    List<Point2D> points;
    List<IPlotterCommand> commands;


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
    public List<IPlotterCommand> getModifiedCommands(PlotModification strategy) {
        strategy.modify(points);
        List<IPlotterCommand> newCommands = getCommands();
        commands.clear();
        points.clear();
        return newCommands;
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


}