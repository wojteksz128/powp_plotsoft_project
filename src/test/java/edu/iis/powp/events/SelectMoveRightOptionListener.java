package edu.iis.powp.events;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.plot.modification.PlotModifier;
import edu.iis.powp.plot.modification.TranslationPlotModification;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectMoveRightOptionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        IPlotter plotter = FeaturesManager.getDriverManager().getCurrentPlotter();
        if (plotter instanceof PlotModifier) {
            ((PlotModifier) plotter).addModification(new TranslationPlotModification(10, 0));
        } else {
            JOptionPane.showMessageDialog(null, "Plotter does not support modifications.");
        }

    }

}
