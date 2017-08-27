package edu.iis.powp.events;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.plot.modification.PlotModifier;
import edu.iis.powp.plot.modification.ScalePlotModification;
import edu.iis.powp.plot.modification.StretchPlotModification;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectHalfScaleOptionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        IPlotter plotter = FeaturesManager.getDriverManager().getCurrentPlotter();
        if (plotter instanceof PlotModifier) {
            ((PlotModifier) plotter).addModification(new ScalePlotModification(.5f));
        } else {
            JOptionPane.showMessageDialog(null, "Plotter does not support modifications.");
        }

    }

}
