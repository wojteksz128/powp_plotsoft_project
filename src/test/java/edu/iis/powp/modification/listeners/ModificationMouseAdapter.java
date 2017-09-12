package edu.iis.powp.modification.listeners;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.modification.listeners.handlers.ModificationMouseHandler;
import edu.iis.powp.plot.modification.PlotModification;
import edu.iis.powp.plot.modification.PlotModifier;


public class ModificationMouseAdapter extends MouseInputAdapter {
	protected ModificationMouseHandler handler;
	protected MouseEvent previous;
    protected int prev_x = 0;
    protected int prev_y = 0;
    
	public ModificationMouseAdapter() {
		super();
	}
    
	@Override
	public void mousePressed(MouseEvent e) {
		if(FeaturesManager.getDriverManager().getCurrentPlotter() instanceof PlotModifier) {
			((PlotModifier)FeaturesManager.getDriverManager().getCurrentPlotter())
			.addModification(handler.getModification());
		}
		previous = e;
		handler.update(previous, e);
		System.out.println("pressed " + handler.getClass().getName());
    }
	
	@Override
    public void mouseDragged(MouseEvent e) {
		handler.update(previous, e);
		previous = e;
        FeaturesManager.reDraw();
    }
	
	@Override
    public void mouseReleased(MouseEvent e) {
		handler.update(previous, e);
		previous = e;
        FeaturesManager.reDraw();
    }
	
	public void setHandler(ModificationMouseHandler handler) {
		this.handler = handler;
	}
	
}
