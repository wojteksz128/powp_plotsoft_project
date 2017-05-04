package edu.iis.powp.app.gui.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.powp.window.WindowComponent;

public class SelectWindowComponentMenuOptionListener implements ActionListener
{
    private WindowComponent window = null;
    
    public SelectWindowComponentMenuOptionListener(WindowComponent window)
    {
        this.window = window;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        window.HideIfVisibleAndShowIfHidden();
    }
}

