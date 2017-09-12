package edu.iis.powp.modification.listeners.handlers;

import java.awt.event.MouseEvent;

import edu.iis.powp.plot.modification.PlotModification;

public interface ModificationMouseHandler {
	PlotModification getModification();
	void update(MouseEvent previous_e, MouseEvent current_e);
}
