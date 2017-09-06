package edu.iis.powp.modification.listeners;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

import edu.iis.powp.plot.modification.PlotModification;
import edu.iis.powp.plot.modification.RotationPlotModification;
import edu.iis.powp.plot.modification.ScalePlotModification;

public class ScaleMouseListener extends ModificationMouseAdapter {

	@Override
	protected
	void update(MouseEvent e) {
		ScalePlotModification modification = (ScalePlotModification) super.modification;
    	int x_d = e.getX() - super.prev_x;
    	int y_d = e.getY() - super.prev_y;
    	modification.setScale(modification.getScale() +  (((float) (x_d+y_d)) / 2f));
	}

	@Override
	protected PlotModification getModification() {
		return new ScalePlotModification(0);
	}

}
