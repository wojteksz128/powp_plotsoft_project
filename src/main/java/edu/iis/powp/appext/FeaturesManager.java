package edu.iis.powp.appext;

import java.util.logging.Logger;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.app.Application;
import edu.iis.powp.app.DriverManager;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.manager.LoggerCommandChangeObserver;
import edu.iis.powp.command.manager.PlotterCommandManager;
import edu.iis.powp.command.manager.Redrawable;
import edu.iis.powp.events.predefine.SelectClearPanelOptionListener;
import edu.kis.powp.drawer.panel.DrawPanelController;

public class FeaturesManager {

	private static boolean areFeaturesAdded = false;

	private static PlotterCommandManager commandManager;
	private static DriverManager driverManager;
	private static DrawPanelController drawerController;

	/**
	 * Startup configuration.
	 */
	public synchronized static void expandApplication(Application application) {
		if (!areFeaturesAdded) {
			areFeaturesAdded = true;

			driverManager = application.getDriverManager();
			setupCommandManager();

			setupDrawerPlugin(application);
		}
	}

	private static void setupCommandManager() {
		commandManager = new PlotterCommandManager();

		LoggerCommandChangeObserver loggerObserver = new LoggerCommandChangeObserver();
		commandManager.getChangePublisher().addSubscriber(loggerObserver);
	}

	/**
	 * Setup Drawer Plugin and add to context.
	 * 
	 * @param application
	 *            Application context.
	 */
	private static void setupDrawerPlugin(Application application) {
		SelectClearPanelOptionListener selectClearPanelOptionListener = new SelectClearPanelOptionListener();

		drawerController = new DrawPanelController();
		application.addComponentMenu(DrawPanelController.class, "Draw Panel", 0);
		application.addComponentMenuElement(DrawPanelController.class, "Clear Panel", selectClearPanelOptionListener);

		drawerController.initialize(application.getFreePanel());
	}

	/**
	 * Get controller of application drawing panel.
	 * 
	 * @return drawPanelController.
	 */
	public static DrawPanelController drawerController() {
		return drawerController;
	}

	/**
	 * Get manager of application driver.
	 * 
	 * @return driverManager.
	 */
	public static DriverManager getDriverManager() {
		return driverManager;
	}

	/**
	 * Get manager of application plotter command.
	 * 
	 * @return plotterCommandManager.
	 */
	public static PlotterCommandManager getPlotterCommandManager() {
		return commandManager;
	}
	
	public static void reDraw() {
		IPlotter currentPlotter = driverManager.getCurrentPlotter();
		if(currentPlotter instanceof Redrawable && ((Redrawable) currentPlotter).isRedrawable()) {
			FeaturesManager.drawerController().clearPanel();
			IPlotterCommand command = FeaturesManager.getPlotterCommandManager().getCurrentCommand();
			FeaturesManager.getPlotterCommandManager().clearCurrentCommand();
			command.execute(FeaturesManager.getDriverManager().getCurrentPlotter());
			FeaturesManager.getPlotterCommandManager().setCurrentCommand(command);
		} else {
			Logger.getGlobal().info("Redraw functionality is disabled");
		}
	}
	
}
