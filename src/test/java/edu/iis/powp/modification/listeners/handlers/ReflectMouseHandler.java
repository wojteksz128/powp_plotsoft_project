package edu.iis.powp.modification.listeners.handlers;

import java.awt.event.MouseEvent;

import edu.iis.powp.modification.listeners.ModificationMouseAdapter;
import edu.iis.powp.plot.modification.PlotModification;
import edu.iis.powp.plot.modification.ReflectionPlotModification;

public class ReflectMouseHandler implements ModificationMouseHandler {

	@Override
	public PlotModification getModification() {
		// TODO Auto-generated method stub
		return new ReflectionPlotModification();
	}

	@Override
	public void update(MouseEvent previous_e, MouseEvent current_e) {
		// TODO Auto-generated method stub
		
	}

}
