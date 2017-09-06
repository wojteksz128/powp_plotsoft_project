package edu.iis.powp.modification.listeners;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.plot.modification.PlotModification;
import edu.iis.powp.plot.modification.PlotModifier;
import edu.iis.powp.plot.modification.PlotPoint;
import edu.iis.powp.plot.modification.RotationPlotModification;
import edu.iis.powp.plot.modification.TranslationPlotModification;



public class TranslationMouseListener extends ModificationMouseAdapter  {
	@Override
	protected PlotModification getModification() {
		return new TranslationPlotModification(0, 0);
	}
	
	@Override
	protected
    void update(MouseEvent e) {
    	TranslationPlotModification modification = (TranslationPlotModification) super.modification;
    	int x_d = e.getX() - super.prev_x;
    	int y_d = e.getY() - super.prev_y;
    	PlotPoint current_point = modification.getPoint();
    	current_point.add(x_d, y_d);
    	modification.setPoint(current_point);
    }
    

}
