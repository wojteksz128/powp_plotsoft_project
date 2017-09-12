package edu.iis.powp.modification.listeners.handlers;

import java.awt.event.MouseEvent;

import edu.iis.powp.modification.listeners.ModificationMouseAdapter;
import edu.iis.powp.plot.modification.PlotModification;
import edu.iis.powp.plot.modification.StretchPlotModification;

public class StretchMouseHandler implements ModificationMouseHandler {

	StretchPlotModification modification;

	@Override
	public PlotModification getModification() {
		modification = new StretchPlotModification(1f, 1f);
		return modification;
	}

	@Override
	public void update(MouseEvent previous_e, MouseEvent e) {
    	float x_d = (float)(e.getX() - previous_e.getX())/100f;
    	float y_d = (float)(e.getY() - previous_e.getY())/100f;
		modification.setxAxis(modification.getxAxis() + x_d);
		modification.setyAxis(modification.getyAxis() + y_d);
	}

}
