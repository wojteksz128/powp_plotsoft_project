package edu.iis.powp.modification.listeners;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

import edu.iis.powp.plot.modification.PlotModification;
import edu.iis.powp.plot.modification.ReflectionPlotModification;

public class ReflectMouseListener extends ModificationMouseAdapter {

	@Override
	protected
	void update(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected PlotModification getModification() {
		// TODO Auto-generated method stub
		return new ReflectionPlotModification();
	}

}
