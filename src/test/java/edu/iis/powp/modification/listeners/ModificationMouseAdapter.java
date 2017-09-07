package edu.iis.powp.modification.listeners;

import java.awt.event.MouseEvent;
import java.util.logging.Logger;

import javax.swing.event.MouseInputAdapter;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.manager.RedrawablePlotterDecorator;
import edu.iis.powp.plot.modification.PlotModification;
import edu.iis.powp.plot.modification.PlotModifier;


public abstract class ModificationMouseAdapter extends MouseInputAdapter {
	protected PlotModification modification;
    protected int prev_x = 0;
    protected int prev_y = 0;
    
	public ModificationMouseAdapter() {
		super();
		this.modification = getModification(); 
	}
    
	@Override
	public void mousePressed(MouseEvent e) {
		if(FeaturesManager.getDriverManager().getCurrentPlotter() instanceof PlotModifier) {
			((PlotModifier)FeaturesManager.getDriverManager().getCurrentPlotter()).addModification(modification);
		}
		prev_x = e.getX();
		prev_y = e.getY();
    }
	
	@Override
    public void mouseDragged(MouseEvent e) {
        update(e);
        redraw();
		prev_x = e.getX();
		prev_y = e.getY();
    }
	
	@Override
    public void mouseReleased(MouseEvent e) {
        update(e);
        redraw();
		modification = getModification();
		prev_x = e.getX();
		prev_y = e.getY();
    }
	
	private void redraw() {
		if(FeaturesManager.getPlotterCommandManager().getCurrentCommand() != null) {
			FeaturesManager.drawerController().clearPanel();
			IPlotterCommand command = FeaturesManager.getPlotterCommandManager().getCurrentCommand();
			FeaturesManager.getPlotterCommandManager().clearCurrentCommand();
			command.execute(FeaturesManager.getDriverManager().getCurrentPlotter());
			FeaturesManager.getPlotterCommandManager().setCurrentCommand(command);
		} else {
			Logger.getGlobal().info("Redraw functionality is disabled");
		}
	}
	
	protected abstract void update(MouseEvent e);
	abstract protected PlotModification getModification();
}
