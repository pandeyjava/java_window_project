package secure.delete.window.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.MenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import secure.delete.window.file.DirectoryModel;
import secure.delete.window.file.DirectoryRenderer;
import secure.delete.window.file.FileSystemModel;
import secure.delete.window.file.FileSystemTreePanel;
import secure.delete.window.utils.FileUtils;
import secure.delete.window.utils.ImageIcon;

public class FileOpen extends JInternalFrame {

	public FileOpen(String title, String file) {
		super(title, true, true, true, true);
		setLayout(new BorderLayout());
		setFrameIcon(FileUtils.getImageIcon(ImageIcon.INTERNAL_ICON));
		setSize(600, 400);
		// setBounds(0, 0,300,300);

		this.add("Center", openFile(file));

	}

	public FileOpen(String title) {
		this(title, null);
		// TODO Auto-generated constructor stub
	}

	private JSplitPane openFile(String file) {
		String rootFile = file;
		FileSystemModel model = null;
		if (rootFile != null) {
			model = new FileSystemModel(file);
		} else {
		model = new FileSystemModel(System.getProperty("user.home"));
			//model = new FileSystemModel("E:\\New folder (2)");
		}

		DirectoryModel directoryModel = new DirectoryModel(
				(File) model.getRoot());
		JTable table = new JTable(directoryModel);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setIntercellSpacing(new Dimension(0, 2));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.getColumn("Type").setCellRenderer(new DirectoryRenderer());

		FileSystemTreePanel fileTree = new FileSystemTreePanel(model);
		fileTree.getTree().addTreeSelectionListener(
				new TreeListener(directoryModel));

		JScrollPane treeScroller = new JScrollPane(fileTree);
		// treeScroller.addM
		JScrollPane tableScroller = new JScrollPane(table); // JTable.createScrollPaneForTable(table);

		treeScroller.setMinimumSize(new Dimension(200, 100));
		tableScroller.setMinimumSize(new Dimension(400, 100));
		tableScroller.setBackground(Color.white);
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				treeScroller, tableScroller);
		// splitPane.setContinuousLayout(true);

		this.setAutoscrolls(true);
		return splitPane;
	}

	protected static class TreeListener implements TreeSelectionListener {
		DirectoryModel model;

		public TreeListener(DirectoryModel mdl) {
			model = mdl;
		}

		public void valueChanged(TreeSelectionEvent e) {
			File fileSysEntity = (File) e.getPath().getLastPathComponent();
			if (fileSysEntity.isDirectory()) {
				model.setDirectory(fileSysEntity);
			} else {
				model.setDirectory(null);
			}
		}
	}

}
