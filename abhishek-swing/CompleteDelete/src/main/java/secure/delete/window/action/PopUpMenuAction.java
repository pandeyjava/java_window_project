package secure.delete.window.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.TreeSet;

import javax.swing.JTree;

import secure.delete.window.menubar.WindowPopUp;
import secure.delete.window.process.DeleteFactory;
import secure.delete.window.utils.Constants;


public class PopUpMenuAction extends MouseAdapter implements ActionListener {

	private JTree tree;
	private DeleteFactory deleteFactory;

	public PopUpMenuAction(JTree tree) {
		this.tree = tree;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		checkForTriggerEvent(e);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		checkForTriggerEvent(e);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		checkForTriggerEvent(e);

	}

	private void checkForTriggerEvent(MouseEvent e) {
		System.out.println("checkForTriggerEvent" + e.getButton());
		if (e.getButton() == MouseEvent.BUTTON3) {
			WindowPopUp.createPopUp(this).show(e.getComponent(), e.getX(),
					e.getY());

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		Object object = tree.getLastSelectedPathComponent();
		if (object != null) {
			String selectedFile = object.toString();
			DeleteFactory deleteFactory=new DeleteFactory();
			if (action.equals(Constants.DELETE)) {
				try {
					deleteFactory.getInstance(Constants.DELETE).delete(selectedFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (action.equals(Constants.SECURE_DELETE)) {
				try {
					deleteFactory.getInstance(Constants.SECURE_DELETE).delete(selectedFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (action.equals(Constants.Complete_Delete)) {
				try {
					deleteFactory.getInstance(Constants.Complete_Delete).delete(selectedFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
			tree.updateUI();

		}

	}
	

}
