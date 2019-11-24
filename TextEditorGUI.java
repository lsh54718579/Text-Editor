
/**
 * @author Sihang Li
 * This is the TextEditorGUI class which: 
 * 1. has a constructor which creates a GUI window and sets its parameters. 
 * 2. has a createFileMenu method which creates buttons. 
 * 3. has a listener method which listens to which button has been clicked. 
 * 4. has a printGUI method which updates the text area content. 
 */

import javax.swing.*;
import java.awt.*;

public class TextEditorGUI extends JFrame {

	Container myContentPane = this.getContentPane();
	JTextArea myTextArea = new JTextArea();
	private JMenuItem itemOpen;
	private JMenuItem itemSave;
	private JMenuItem itemExit;
	private JMenuItem itemFind;
	private JMenuItem itemReplace;
	private JMenuItem itemDelete;
	private JMenuItem itemHelp;

	/**
	 * The TextEditorGUI constructor receives a string from the main method. It also
	 * sets the title, size, and location of the GUI panel.
	 * 
	 * @param s
	 */

	public TextEditorGUI(String s) {
		myContentPane.add(myTextArea, BorderLayout.CENTER);
		setTitle("Text Editor");
		setSize(500, 500);
		setLocation(400, 200);
		myTextArea.setText(s);
		createMenu(); // Calls the createFileMenu method to add buttons to the GUI.
		myTextArea.setLineWrap(true); // Allows the GUI window to introduce new line based on the size of the window.
		myTextArea.setWrapStyleWord(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	} // GUI Constructor

	/**
	 * This method creates a menubar, which has a filemenu, an editmenu and a
	 * helpmenu. 
	 * The filemenu has three items, "Open","Save" and "Exit". 
	 * Each of them calls the actionPerformed method to perform corresponding action. 
	 * The editmenu has three items, "Find","Replace" and "Delete". 
	 * Each of them calls the actionPerformed method to perform corresponding action. 
	 * The helpmenu only has one item, "Help," which only displays a GUI window of help document.
	 * In addition, items "Save","Find","Replace" and "Delete"  are disabled until a file is open. 
	 */
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu helpMenu = new JMenu("Help");

		MenuHandler fmh = new MenuHandler(this); // Initializes the FileMenuHandler class and passes this GUI
															// object as a parameter.
		itemOpen = new JMenuItem("Open");
		itemOpen.setEnabled(true);
		itemOpen.addActionListener(fmh);
		fileMenu.add(itemOpen);
		fileMenu.addSeparator();

		itemSave = new JMenuItem("Save");
		itemSave.setEnabled(false);
		itemSave.addActionListener(fmh);
		fileMenu.add(itemSave);
		fileMenu.addSeparator();

		itemExit = new JMenuItem("Exit");
		itemOpen.setEnabled(true);
		itemExit.addActionListener(fmh);
		fileMenu.add(itemExit);

		itemFind = new JMenuItem("Find");
		itemFind.setEnabled(false);
		itemFind.addActionListener(fmh);
		editMenu.add(itemFind);
		editMenu.addSeparator();

		itemReplace = new JMenuItem("Replace");
		itemReplace.setEnabled(false);
		itemReplace.addActionListener(fmh);
		editMenu.add(itemReplace);
		editMenu.addSeparator();

		itemDelete = new JMenuItem("Delete");
		itemDelete.setEnabled(false);
		itemDelete.addActionListener(fmh);
		editMenu.add(itemDelete);

		itemHelp = new JMenuItem("Help");
		itemOpen.setEnabled(true);
		itemHelp.addActionListener(fmh);
		helpMenu.add(itemHelp);

		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
	}

	/**
	 * This method enables the "Save","Find","Replace" and "Delete" button.
	 */
	public void buttonEnable() {
		itemSave.setEnabled(true);
		itemFind.setEnabled(true);
		itemReplace.setEnabled(true);
		itemDelete.setEnabled(true);
	}
/**
 * This method sets the content in the Jtextarea. 
 * @param myText
 */
	public void setTextHelper(String myText) {
		myTextArea.setText(myText);
	}
}
