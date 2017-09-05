package edu.iis.powp.modification.listeners;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

import edu.iis.powp.plot.modification.PlotModification;
import edu.iis.powp.plot.modification.ScalePlotModification;
import edu.iis.powp.plot.modification.StretchPlotModification;

public class StretchMouseListener extends ModificationMouseAdapter {

	@Override
	void update(MouseEvent e) {
		StretchPlotModification modification = (StretchPlotModification) super.modification;
    	int x_d = e.getX() - super.prev_x;
    	int y_d = e.getY() - super.prev_y;
		modification.setxAxis(modification.getxAxis() + x_d);
		modification.setyAxis(modification.getyAxis() + y_d);
	}

	@Override
	PlotModification getModification() {
		return new StretchPlotModification(0f, 0f);
	}

}
