package edu.iis.powp.modification.listeners;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

import edu.iis.powp.plot.modification.PlotModification;
import edu.iis.powp.plot.modification.PlotPoint;
import edu.iis.powp.plot.modification.RotationPlotModification;
import edu.iis.powp.plot.modification.TranslationPlotModification;

public class RotationMouseListener extends ModificationMouseAdapter {
	protected PlotModification getModification() {
		return new RotationPlotModification(0);
	}

    protected void update(MouseEvent e) {
    	RotationPlotModification modification = (RotationPlotModification) super.modification;
    	int x_d = e.getX() - super.prev_x;
    	int y_d = e.getY() - super.prev_y;
    	modification.setAngle(modification.getAngle() + y_d);
    }

}
