package edu.iis.powp.command.manager;

import java.util.ArrayList;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.SetPositionCommand;

public class RedrawablePlotterDecorator implements IPlotter, Redrawable {

	private IPlotter instance;
	private PlotterCommandManager commandManager;

	
	public RedrawablePlotterDecorator(IPlotter instance, PlotterCommandManager commandManager) {
		super();
		this.instance = instance;
		this.commandManager = commandManager;
	}

	@Override
	public void drawTo(int arg0, int arg1) {
		if(commandManager.getCurrentCommand() == null) {
			commandManager.setCurrentCommand(new DrawToCommand(arg0,arg1));
		} else {
			commandManager.setCurrentCommand(new ArrayList<IPlotterCommand>(){/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				
			{
				add(commandManager.getCurrentCommand());
				add(new DrawToCommand(arg0,arg1));
			}},
					"Saved command");
			
		}
		instance.drawTo(arg0, arg1);
		System.out.println("drawto: " + arg0+ " " + arg1);
	}

	@Override
	public void setPosition(int arg0, int arg1) {
		if(commandManager.getCurrentCommand() == null) {
			commandManager.setCurrentCommand(new SetPositionCommand(arg0,arg1));
		} else {
			commandManager.setCurrentCommand(new ArrayList<IPlotterCommand>(){/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
	
			{
				add(commandManager.getCurrentCommand());
				add(new SetPositionCommand(arg0,arg1));
			}},
					"Saved command");
			
		}
		instance.setPosition(arg0, arg1);
		System.out.println("setpos: " + arg0+ " " + arg1);
	}

	@Override
	public boolean isRedrawable() {
		return true;
	}

}
