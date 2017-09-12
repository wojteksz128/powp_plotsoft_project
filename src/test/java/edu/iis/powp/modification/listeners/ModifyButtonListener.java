package edu.iis.powp.modification.listeners;

import edu.iis.powp.modification.listeners.handlers.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyButtonListener implements ActionListener {
	ModificationMouseAdapter mouseAdapter;
	
	public ModifyButtonListener(ModificationMouseAdapter mouseAdapter) {
		super();
		this.mouseAdapter = mouseAdapter;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComponent source = (JComponent)e.getSource();
		switch(source.getName()) {
		case "moveButton":
			mouseAdapter.setHandler(new TranslationMouseHandler());
			break;
		case "rotateButton":
			mouseAdapter.setHandler(new RotationMouseHandler());
			break;
		case "scaleButton":
			mouseAdapter.setHandler(new ScaleMouseHandler());
			break;
		case "stretchButton":
			mouseAdapter.setHandler(new StretchMouseHandler());
			break;
		case "PointerButton":
			mouseAdapter.setHandler(new PointerMouseHandler());
			break;
		}
		
	}

}
