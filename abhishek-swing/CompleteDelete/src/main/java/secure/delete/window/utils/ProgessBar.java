package secure.delete.window.utils;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ProgessBar extends JProgressBar{
	
	public ProgessBar() {
		    this.add(BorderLayout.NORTH, new JLabel("Progress..."));
		    this.setSize(300, 75);
		   
	}

}
