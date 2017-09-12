package edu.iis.powp.modification.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

import edu.iis.powp.app.Application;

public class ModifyButtonListener implements ActionListener {
	Application application;
	
	public ModifyButtonListener(Application application) {
		super();
		this.application = application;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComponent source = (JComponent)e.getSource();
		for(MouseListener ml : application.getFreePanel().getMouseListeners()) {
			application.getFreePanel().removeMouseListener(ml);
		}
		switch(source.getName()) {
		case "moveButton":
			application.getFreePanel().addMouseListener(new TranslationMouseListener());
			break;
		case "rotateButton":
			application.getFreePanel().addMouseListener(new RotationMouseListener());
			break;
		case "scaleButton":
			application.getFreePanel().addMouseListener(new ScaleMouseListener());
			break;
		case "stretchButton":
			application.getFreePanel().addMouseListener(new StretchMouseListener());
			break;
		case "PointerButton":
			break;
		}
		
	}

}
