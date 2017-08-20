package edu.iis.powp.decorator;

import java.util.List;

import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.plot.modification.PlotLine;
import edu.iis.powp.plot.modification.PlotModification;
import edu.iis.powp.plot.modification.PlotPoint;

public interface Modifiable {
    void addModification(PlotModification modification);
    void removeModification(PlotModification modification);
    List<PlotModification> getModifications();
    void clearModifications();

    void setCenterPoint(PlotPoint point);
    void setMirrorLine(PlotLine line);
}
