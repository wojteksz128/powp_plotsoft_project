package edu.iis.powp.modification.listeners;

import java.awt.event.MouseEvent;


import edu.iis.powp.plot.modification.PlotModification;
import edu.iis.powp.plot.modification.RotationPlotModification;

public class RotationMouseListener extends ModificationMouseAdapter {
	protected PlotModification getModification() {
		return new RotationPlotModification(0);
	}

    protected void update(MouseEvent e) {
    	RotationPlotModification modification = (RotationPlotModification) super.modification;
    	int y_d = e.getY() - super.prev_y;
    	modification.setAngle(modification.getAngle() + y_d);
    }

}
