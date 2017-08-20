package edu.iis.powp.plot.modification;

import java.util.List;

/**
 * Object, who implement this interface can modify plot points using some modification.
 */
public interface PlotModifier {
    /**
     * Add new modification of points.
     *
     * @param modification new modification
     */
    void addModification(PlotModification modification);

    /**
     * Remove exist modification of points.
     *
     * @param modification exist modification
     */
    void removeModification(PlotModification modification);

    /**
     * Get list of storied modification of points in correct order.
     *
     * @return list of storied modification
     */
    List<PlotModification> getModifications();

    /**
     * Remove all storied modifications.
     */
    void clearModifications();

    /**
     * Get information about current center point of translations.
     *
     * @return current center point of translations
     */
    PlotPoint getCenterPoint();

    /**
     * Set new center point of translations.
     *
     * @param point new center point of translations
     */
    void setCenterPoint(PlotPoint point);

    /**
     * Get information about current mirror line.
     *
     * @return current mirror line
     */
    PlotLine getMirrorLine();

    /**
     * Set new mirror line.
     *
     * @param line new mirror line
     */
    void setMirrorLine(PlotLine line);
}
