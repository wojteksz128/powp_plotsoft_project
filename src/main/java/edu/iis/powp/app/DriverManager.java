package edu.iis.powp.app;

import edu.iis.client.plottermagic.ClientPlotter;
import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.observer.Publisher;

/**
 * Driver Manager.
 */
public class DriverManager {

	private IPlotter currentPlotter = new ClientPlotter();

	private Publisher changePublisher = new Publisher();

	/**
	 * Set current plotter.
	 * 
	 * @param plotter
	 *            Set the plotter as current.
	 */
	public synchronized void setCurrentPlotter(IPlotter plotter) {
		currentPlotter = plotter;
		changePublisher.notifyObservers();
	}

	/**
	 * Return current plotter.
	 * 
	 * @return Current plotter.
	 */
	public synchronized IPlotter getCurrentPlotter() {
		return currentPlotter;
	}

	public Publisher getChangePublisher() {
		return changePublisher;
	}

}
