package edu.iis.powp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.client.plottermagic.preset.FiguresJoe;
import edu.iis.powp.appext.FeaturesManager;

public class SelectTestFigure2OptionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		FiguresJoe.figureScript2(FeaturesManager.getDriverManager().getCurrentPlotter());
	}
}