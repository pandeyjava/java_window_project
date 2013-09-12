package secure.delete.window.menubar;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import secure.delete.window.action.MenuItemAction;
import secure.delete.window.utils.Constants;
import secure.delete.window.utils.FileUtils;
import secure.delete.window.utils.ImageIcon;


public class ApplicationMenuBar extends JMenuBar {

	private JMenuItem[] items;
	JMenu[] menu ;
	
	private MenuItemAction menuItemAction;
	

	public ApplicationMenuBar() {
		menu = new JMenu[2];
		menu[0]=new JMenu("File");
		menu[1]=new JMenu("Control");
		
				
				
				
		menuItemAction = new MenuItemAction();
		
		items = new JMenuItem[5];
		items[0] = new JMenuItem(Constants.NEW);
		items[0].setActionCommand(Constants.NEW);
		items[0].setIcon(FileUtils.getImageIcon(ImageIcon.FILE_NEW_ICON));
		items[0].addActionListener(menuItemAction);
		menu[0].add(items[0]);
		
		
		items[1] = new JMenuItem(Constants.OPEN_DIR);
		items[1].setActionCommand(Constants.OPEN_DIR);
		items[1].setIcon(FileUtils.getImageIcon(ImageIcon.FILE_OPEN_ICON));
		items[1].addActionListener(menuItemAction);
		menu[0].add(items[1]);
		items[2] = new JMenuItem(Constants.CLOSE);
		items[2].setActionCommand(Constants.CLOSE);
		items[2].setIcon(FileUtils.getImageIcon(ImageIcon.FILE_CLOSE_ICON));
		items[2].addActionListener(menuItemAction);
		menu[0].addSeparator();
		menu[0].add(items[2]);
		items[3] = new JMenuItem(Constants.CLOSE_ALL);
		items[3].setActionCommand(Constants.CLOSE_ALL);
		items[3].addActionListener(menuItemAction);
		menu[0].add(items[3]);
		menu[0].addSeparator();
		items[4] = new JMenuItem(Constants.EXIT);
		items[4].setActionCommand(Constants.EXIT);
		items[4].addActionListener(menuItemAction);
		menu[0].add(items[4]);
		
		add(menu[0]);
		
		
		
	}

}
