package edu.iis.powp.app.gui.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.app.DriverManager;

public class SelectDriverMenuOptionListener implements ActionListener
{
    private DriverManager driverManager;
	private IPlotter plotter = null;
    
    public SelectDriverMenuOptionListener(IPlotter plotter, DriverManager driverManager)
    {
        this.driverManager = driverManager;
    	this.plotter = plotter;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
    	driverManager.setCurrentPlotter(plotter);
    }
}
