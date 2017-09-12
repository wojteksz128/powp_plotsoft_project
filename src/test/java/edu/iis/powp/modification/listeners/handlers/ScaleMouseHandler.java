package edu.iis.powp.modification.listeners.handlers;

import java.awt.event.MouseEvent;

import edu.iis.powp.modification.listeners.ModificationMouseAdapter;
import edu.iis.powp.plot.modification.PlotModification;
import edu.iis.powp.plot.modification.RotationPlotModification;
import edu.iis.powp.plot.modification.ScalePlotModification;

public class ScaleMouseHandler implements ModificationMouseHandler {

	private ScalePlotModification modification;

	@Override
	public PlotModification getModification() {
		modification = new ScalePlotModification(1f);
		return modification;
	}

	@Override
	public void update(MouseEvent previous_e, MouseEvent current_e) {
    	float x_d = (float)(current_e.getX() - previous_e.getX())/10f;
    	float y_d = (float)(current_e.getY() - previous_e.getY())/10f;
    	float mean = (x_d+y_d)/20f;
    	System.out.println(mean);
    	modification.setScale(modification.getScale() +  mean);
    	
	}

}
