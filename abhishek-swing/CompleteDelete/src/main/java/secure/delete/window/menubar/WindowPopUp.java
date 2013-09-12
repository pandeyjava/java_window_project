package secure.delete.window.menubar;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import secure.delete.window.utils.Constants;
import secure.delete.window.utils.FileUtils;
import secure.delete.window.utils.ImageIcon;


public class WindowPopUp {

	public static JPopupMenu popupMenu;
	

	public static JPopupMenu createPopUp(ActionListener actionListener) {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu("abc");
			JMenuItem[] items = new JMenuItem[3];
			items[0] = new JMenuItem(Constants.DELETE,FileUtils.getImageIcon(ImageIcon.FILE_NORMAL_DELETE_ICON));
			items[0].setActionCommand(Constants.DELETE);
			items[1] = new JMenuItem(Constants.SECURE_DELETE,
					FileUtils.getImageIcon(ImageIcon.FILE_COUREPT_DELETE_ICON));
			items[1].setActionCommand(Constants.SECURE_DELETE);
			items[2] = new JMenuItem(Constants.Complete_Delete,
					FileUtils.getImageIcon(ImageIcon.FILE_COMPLET_EDELETE_ICON));
			items[2].setActionCommand(Constants.Complete_Delete);
			for (int i = 0; i < items.length; i++) {
				items[i].addActionListener(actionListener);
				popupMenu.add(items[i]);
			}

		}
		return popupMenu;
	}

}
