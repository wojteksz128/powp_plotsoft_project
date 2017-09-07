package edu.iis.powp.app;

import java.util.ArrayList;
import java.util.List;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.plot.modification.PlotModification;
import edu.iis.powp.plot.modification.PlotModifier;

public class ModifierDriverManager extends DriverManager {
	
	public ModifierDriverManager() {
		super();
		modifications = new ArrayList<>();
	}
	
	/**
	 * Set current plotter.
	 * 
	 * @param plotter
	 *            Set the plotter as current. And port modifications if any.
	 */
	@Override
	public synchronized void setCurrentPlotter(IPlotter plotter) {
		if(plotter instanceof PlotModifier) {
			for(PlotModification modification : modifications) {
				((PlotModifier) plotter).addModification(modification);				
			}
		}
		super.setCurrentPlotter(plotter);
	}
	
	/**
	 * Save modifications for porting to another driver.
	 */
	public synchronized void applyModifications() {
		modifications = ((PlotModifier)super.getCurrentPlotter()).getModifications();
	}

	private List<PlotModification> modifications;
	
	
}
