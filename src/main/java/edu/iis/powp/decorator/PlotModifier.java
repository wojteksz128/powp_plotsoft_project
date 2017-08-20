package edu.iis.powp.decorator;

import edu.iis.powp.plot.modification.PlotLine;
import edu.iis.powp.plot.modification.PlotModification;
import edu.iis.powp.plot.modification.PlotPoint;

import java.util.List;

public interface PlotModifier {
    void addModification(PlotModification modification);

    void removeModification(PlotModification modification);

    List<PlotModification> getModifications();

    void clearModifications();

    PlotPoint getCenterPoint();

    void setCenterPoint(PlotPoint point);

    PlotLine getMirrorLine();

    void setMirrorLine(PlotLine line);
}
