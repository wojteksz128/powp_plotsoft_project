package edu.iis.powp.decorator;

import java.util.List;

import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.plot.modification.PlotModification;

public interface Modifiable {
    public List<IPlotterCommand> getModifiedCommands(PlotModification strategy);
}
