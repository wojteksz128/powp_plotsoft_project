package edu.iis.powp.plot.modification;

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
