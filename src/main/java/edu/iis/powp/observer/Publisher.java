package edu.iis.powp.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class Publisher {

	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private List<Subscriber> observersList = new ArrayList<>();

	private boolean isNotifying = false; // flag to avoid cyclic notifications

	public void notifyObservers() {
		if (!isNotifying) {
			isNotifying = true;
			for (Subscriber observer : observersList) {
				logger.fine("Notifying observer: " + observer.toString());
				observer.update();
			}
			isNotifying = false;
		}
	}

	public void clearObservers() {
		observersList.clear();
	}

	public List<Subscriber> getSubscribers() {
		return Collections.unmodifiableList(observersList);
	}

	public void addSubscriber(Subscriber driverChangeSubscriber) {
		observersList.add(driverChangeSubscriber);
	}
}
