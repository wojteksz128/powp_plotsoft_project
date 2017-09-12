package edu.iis.powp.modification.listeners.handlers;

import java.awt.event.MouseEvent;

import edu.iis.powp.modification.listeners.ModificationMouseAdapter;
import edu.iis.powp.plot.modification.PlotModification;
import edu.iis.powp.plot.modification.PlotPoint;
import edu.iis.powp.plot.modification.TranslationPlotModification;



public class TranslationMouseHandler implements ModificationMouseHandler  {
	
	TranslationPlotModification modification;
	
	@Override
	public PlotModification getModification() {
		modification = new TranslationPlotModification(0, 0);
		return modification;
	}
	
	@Override
	public void update(MouseEvent previous_e, MouseEvent e) {
    	int x_d = e.getX() - previous_e.getX();
    	int y_d = e.getY() - previous_e.getY();
    	PlotPoint current_point = modification.getPoint();
    	current_point.add(x_d, y_d);
    	modification.setPoint(current_point);
	}
    

}
