package edu.iis.powp.decorator;

import java.util.List;

import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.strategy.ModifyStrategy;

public interface Modifiable {
	public List<IPlotterCommand> getModifiedCommands(ModifyStrategy strategy);
}
