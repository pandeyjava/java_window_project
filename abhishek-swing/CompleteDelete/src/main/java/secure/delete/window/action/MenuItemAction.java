package secure.delete.window.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;

import secure.delete.window.main.FileOpen;
import secure.delete.window.main.MainFrame;
import secure.delete.window.utils.Constants;

public class MenuItemAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		FileOpen action = null;
		int layer = 0;
		JInternalFrame[] frame = MainFrame.desktopPane.getAllFrames();
		if (frame != null) {
			layer = frame.length;
		}
		if (e.getActionCommand().equalsIgnoreCase(Constants.NEW)) {
			action = new FileOpen(Constants.NEW);
			action.setVisible(true);
			MainFrame.desktopPane.setSelectedFrame(action);
			MainFrame.desktopPane.add(action, layer);

		} else if (e.getActionCommand().equalsIgnoreCase(Constants.OPEN_DIR)) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.showOpenDialog(MainFrame.desktopPane);
			File file = fileChooser.getSelectedFile();
			action = new FileOpen(Constants.OPEN_DIR, file.getAbsolutePath());
			action.setVisible(true);
			MainFrame.desktopPane.setSelectedFrame(action);
			MainFrame.desktopPane.add(action, layer);
		} else if (e.getActionCommand().equalsIgnoreCase(Constants.CLOSE)) {
			JInternalFrame selectedFrame = MainFrame.desktopPane
					.getSelectedFrame();
			selectedFrame.doDefaultCloseAction();

		} else if (e.getActionCommand().equalsIgnoreCase(Constants.CLOSE_ALL)) {
			for (JInternalFrame selectedFrame : frame) {
				selectedFrame.doDefaultCloseAction();
			}
		} else if (e.getActionCommand().equalsIgnoreCase(Constants.EXIT)) {
			System.exit(0);
		}

		System.out.println(e.getSource());

	}

}
