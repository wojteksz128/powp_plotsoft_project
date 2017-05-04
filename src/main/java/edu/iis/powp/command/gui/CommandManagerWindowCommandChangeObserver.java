package edu.iis.powp.command.gui;

import edu.iis.powp.observer.Subscriber;

public class CommandManagerWindowCommandChangeObserver implements Subscriber {

	private CommandManagerWindow commandManagerWindow;
	
	public CommandManagerWindowCommandChangeObserver(CommandManagerWindow commandManagerWindow) {
		super();
		this.commandManagerWindow = commandManagerWindow;
	}

	public String toString() {
		return "Current command change observer for command manager window";
	}

	@Override
	public void update() {
		commandManagerWindow.updateCurrentCommandField();	
	}

}
