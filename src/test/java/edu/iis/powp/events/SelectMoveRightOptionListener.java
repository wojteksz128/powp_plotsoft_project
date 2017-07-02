package edu.iis.powp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.manager.LoggerCommandChangeObserver;
import edu.iis.powp.command.manager.PlotterCommandManager;
import edu.iis.powp.decorator.Modifiable;
import edu.iis.powp.strategy.MoveStrategy;

public class SelectMoveRightOptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		 PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
		 IPlotter plotter = FeaturesManager.getDriverManager().getCurrentPlotter();
		 if(plotter instanceof Modifiable) {
			 manager.setCurrentCommand(((Modifiable) plotter).getModifiedCommands(new MoveStrategy(20,0)), "Modified Command");
		 } else {
			 JOptionPane.showMessageDialog(null, "Plotter does not support modifications.");
		 }

	}

}
