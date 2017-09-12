package edu.iis.powp.gui;

import edu.iis.client.plottermagic.ClientPlotter;
import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.adapter.LineAdapterPlotterDriver;
import edu.iis.powp.app.Application;
import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.gui.CommandManagerWindow;
import edu.iis.powp.command.gui.CommandManagerWindowCommandChangeObserver;
import edu.iis.powp.command.manager.redrawable.RedrawablePlotterDecorator;
import edu.iis.powp.events.SelectLoadSecretCommandOptionListener;
import edu.iis.powp.events.SelectRunCurrentCommandOptionListener;
import edu.iis.powp.events.SelectTestFigure2OptionListener;
import edu.iis.powp.events.predefine.SelectTestFigureOptionListener;
import edu.iis.powp.modification.listeners.ModificationMouseAdapter;
import edu.iis.powp.modification.listeners.ModifyButtonListener;
import edu.iis.powp.plot.modification.ModificationPlotterWrapper;
import edu.iis.powp.plot.modification.PlotModifier;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.LineFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestPlotterApp {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application
	 *            Application context.
	 */
	private static void setupPresetTests(Application application) {
		SelectTestFigureOptionListener selectTestFigureOptionListener = new SelectTestFigureOptionListener();
		SelectTestFigure2OptionListener selectTestFigure2OptionListener = new SelectTestFigure2OptionListener();

		application.addTest("Figure Joe 1", selectTestFigureOptionListener);
		application.addTest("Figure Joe 2", selectTestFigure2OptionListener);
	}

	/**
	 * Setup test using plotter commands in context.
	 * 
	 * @param application
	 *            Application context.
	 */
	private static void setupCommandTests(Application application) {
		application.addTest("Load secret command", new SelectLoadSecretCommandOptionListener());
		application.addTest("Run command", new SelectRunCurrentCommandOptionListener());

	}

	/**
	 * Setup driver manager, and set default IPlotter for application.
	 * 
	 * @param application
	 *            Application context.
	 */
	private static void setupDrivers(Application application) {
		IPlotter clientPlotter = new ClientPlotter();
		clientPlotter = new ModificationPlotterWrapper(clientPlotter);
		application.addDriver("Client Plotter", clientPlotter);

		DrawPanelController drawerController = FeaturesManager.drawerController();
		IPlotter plotter = new LineAdapterPlotterDriver(drawerController, LineFactory.getBasicLine(), "basic");
		plotter = new RedrawablePlotterDecorator(plotter, FeaturesManager.getPlotterCommandManager());
		plotter = new ModificationPlotterWrapper(plotter);
		application.addDriver("Line Simulator", plotter);
		FeaturesManager.getDriverManager().setCurrentPlotter(plotter);

		plotter = new LineAdapterPlotterDriver(drawerController, LineFactory.getSpecialLine(), "special");
		plotter = new RedrawablePlotterDecorator(plotter, FeaturesManager.getPlotterCommandManager());
		plotter = new ModificationPlotterWrapper(plotter);
		application.addDriver("Special line Simulator", plotter);
		application.updateDriverInfo();
		
	}

	private static void setupWindows(Application application) {

		CommandManagerWindow commandManager = new CommandManagerWindow(FeaturesManager.getPlotterCommandManager());
		application.addWindowComponent("Command Manager", commandManager);

		CommandManagerWindowCommandChangeObserver windowObserver = new CommandManagerWindowCommandChangeObserver(
				commandManager);
		FeaturesManager.getPlotterCommandManager().getChangePublisher().addSubscriber(windowObserver);
	}

	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param application
	 *            Application context.
	 */
	private static void setupLogger(Application application) {

		application.addComponentMenu(Logger.class, "Logger", 0);
		application.addComponentMenuElement(Logger.class, "Clear log",
				(ActionEvent e) -> application.flushLoggerOutput());
		application.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> logger.setLevel(Level.FINE));
		application.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> logger.setLevel(Level.INFO));
		application.addComponentMenuElement(Logger.class, "Warning level",
				(ActionEvent e) -> logger.setLevel(Level.WARNING));
		application.addComponentMenuElement(Logger.class, "Severe level",
				(ActionEvent e) -> logger.setLevel(Level.SEVERE));
		application.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> logger.setLevel(Level.OFF));
	}
	
	/**
	 * Setup tool bar for navigating and editing the plot.
	 * 
	 * @param application
	 *            Application context.
	 */
	private static void setupToolBar(Application application) {
		JToolBar toolbar = new JToolBar("Applications");
		setupButtons(application, toolbar);
        application.getFreePanel().setLayout(new BorderLayout());
        application.getFreePanel().add(toolbar, BorderLayout.PAGE_START);
	}
	
	/**
	 * Setup buttons for tool bar.
	 * 
	 * @param application
	 *            Application context.
	 */
	private static void setupButtons(Application application, JToolBar toolbar) {
		ButtonGroup button_group = new ButtonGroup();
		ModificationMouseAdapter adapter = new ModificationMouseAdapter();
		application.getFreePanel().addMouseListener(adapter);
		ModifyButtonListener toolBarListener = new ModifyButtonListener(adapter);
		
		JToggleButton pointerBtn = new JToggleButton("POINTER");
		pointerBtn.setName("pointerButton");
		pointerBtn.addActionListener(toolBarListener);
		button_group.add(pointerBtn);
        toolbar.add(pointerBtn);
		
		JToggleButton moveBtn = new JToggleButton("MOVE");
		moveBtn.setName("moveButton");
		moveBtn.addActionListener(toolBarListener);
		button_group.add(moveBtn);
        toolbar.add(moveBtn);
        
		JToggleButton rotateBtn = new JToggleButton("ROTATE");
		rotateBtn.setName("rotateButton");
		rotateBtn.addActionListener(toolBarListener);
		button_group.add(rotateBtn);
        toolbar.add(rotateBtn);
        
		JToggleButton scaleBtn = new JToggleButton("SCALE");
		scaleBtn.setName("scaleButton");
		scaleBtn.addActionListener(toolBarListener);
		button_group.add(scaleBtn);
        toolbar.add(scaleBtn);
        
		JToggleButton stretchBtn = new JToggleButton("STRETCH");
		stretchBtn.setName("stretchButton");
		stretchBtn.addActionListener(toolBarListener);
		button_group.add(stretchBtn);
        toolbar.add(stretchBtn);
        
		JButton resetBtn = new JButton("RESET");
		resetBtn.setName("resetButton");
		resetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(application.getDriverManager().getCurrentPlotter() instanceof PlotModifier) {
					PlotModifier modifier = (PlotModifier)application.getDriverManager().getCurrentPlotter();
					modifier.clearModifications();
					FeaturesManager.reDraw();
				}
			}
		});
		button_group.add(resetBtn);
        toolbar.add(resetBtn);
        
		JButton applyBtn = new JButton("APPLY");
		applyBtn.setName("applyButton");
		applyBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				application.getDriverManager().applyModifications();
			}
		});
		button_group.add(applyBtn);
        toolbar.add(applyBtn);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Application app = new Application();
				FeaturesManager.expandApplication(app);

				setupDrivers(app);
				setupPresetTests(app);
				setupCommandTests(app);
				setupLogger(app);
				setupWindows(app);
				setupToolBar(app);

				app.setVisibility(true);
			}
		});
	}

}
