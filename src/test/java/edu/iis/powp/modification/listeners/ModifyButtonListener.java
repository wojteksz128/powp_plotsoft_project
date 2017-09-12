package edu.iis.powp.modification.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

import edu.iis.powp.app.Application;
import edu.iis.powp.modification.listeners.handlers.PointerMouseHandler;
import edu.iis.powp.modification.listeners.handlers.ReflectMouseHandler;
import edu.iis.powp.modification.listeners.handlers.RotationMouseHandler;
import edu.iis.powp.modification.listeners.handlers.ScaleMouseHandler;
import edu.iis.powp.modification.listeners.handlers.StretchMouseHandler;
import edu.iis.powp.modification.listeners.handlers.TranslationMouseHandler;

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
		case "reflectButton":
			mouseAdapter.setHandler(new ReflectMouseHandler());
			break;
		case "PointerButton":
			mouseAdapter.setHandler(new PointerMouseHandler());
			break;
		}
		
	}

}
