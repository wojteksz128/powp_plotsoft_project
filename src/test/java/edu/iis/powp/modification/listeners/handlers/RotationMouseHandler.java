package edu.iis.powp.modification.listeners.handlers;

import java.awt.event.MouseEvent;

import edu.iis.powp.modification.listeners.ModificationMouseAdapter;
import edu.iis.powp.plot.modification.PlotModification;
import edu.iis.powp.plot.modification.RotationPlotModification;

public class RotationMouseHandler implements ModificationMouseHandler {
	
	private RotationPlotModification modification;
	
	public PlotModification getModification() {
		modification = new RotationPlotModification(0);
		return modification;
	}

    public void update(MouseEvent prev ,MouseEvent e) {
    	int y_d = e.getY() - prev.getY();
    	modification.setAngle(modification.getAngle() + y_d);
    }

}
