package edu.iis.powp.app.gui.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class SelectJFrameWindowMenuOptionListener implements ActionListener
{
    private JFrame window = null;
    
    public SelectJFrameWindowMenuOptionListener(JFrame window)
    {
        this.window = window;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
    	if(window.isVisible()) {
    		window.setVisible(false);
		}
		else {
			window.setVisible(true);
		}
    }
}

