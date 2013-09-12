package secure.delete.window.main;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import secure.delete.window.menubar.ApplicationMenuBar;
import secure.delete.window.utils.FileUtils;
import secure.delete.window.utils.ImageIcon;


public class MainFrame  extends JFrame{
	
	public static MainDesktop desktopPane;
	
	static{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MainFrame() {
		setLayout(new BorderLayout());
		//need to set from property file
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setIconImage(FileUtils.getImage(ImageIcon.APPLICATION_ICON));
		desktopPane=new MainDesktop();
		setTitle("File Remover");
		getContentPane().add(desktopPane);
		setJMenuBar(new ApplicationMenuBar());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		}
	public static void main(String[] args) {
		new MainFrame();
	}
	 
	

}
