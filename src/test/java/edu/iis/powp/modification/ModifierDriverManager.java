package edu.iis.powp.modification;

import java.util.ArrayList;
import java.util.List;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.app.DriverManager;
import edu.iis.powp.plot.modification.PlotModification;
import edu.iis.powp.plot.modification.PlotModifier;

public class ModifierDriverManager extends DriverManager {
	
	public ModifierDriverManager() {
		super();
		modifications = new ArrayList<>();
	}
	
	@Override
	public synchronized void setCurrentPlotter(IPlotter plotter) {
		if(plotter instanceof PlotModifier) {
			for(PlotModification modification : modifications) {
				((PlotModifier) plotter).addModification(modification);				
			}
		}
		super.setCurrentPlotter(plotter);
	}
	
	public synchronized void applyModifications() {
		modifications = ((PlotModifier)super.getCurrentPlotter()).getModifications();
	}

	private List<PlotModification> modifications;
	
	
}
