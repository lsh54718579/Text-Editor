
/**
* @author Sihang Li
 *This is the FileMenuHandler class, it has a method called actionPerformed(ActionEvent event)
 * If the event is "Open", it calls the FileMenu class and calls the buttonEnable method in the TextEditorGUI class to enable the "Save", "Find", "Replace" and "Delete" buttons. 
 * If the event is "Save", "Find", "Replace" or "Delete", given a file is already open, it calls the FileMenu class with the name of the event. 
 * If the event is "Help" or "Exit", it performs their corresponding actions. 
 *
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuHandler implements ActionListener {
	private TextEditorGUI myGUI;

	public MenuHandler(TextEditorGUI myGUI) {
		this.myGUI = myGUI;
	} // Constructor

/**
 * This class takes in a parameter which is the event from its caller. 
 * It initializes 
 * It then calls the class corresponding to the event.
 * In addition, it catches the boolean result from the fileProcess method in the FileMenu class.
 * If the boolean result is true, it calls the buttonEnable method in the TextEditorGUI class to enable the buttons. 
 */
	public void actionPerformed(ActionEvent event) {
		FileMenu myFileMenu = new FileMenu(myGUI);
		String menuName;
		boolean fileOpened = false;
		menuName = event.getActionCommand();

		if (menuName.equals("Open")) {
			fileOpened = myFileMenu.fileProcess(menuName);
			if (fileOpened == true)
				myGUI.buttonEnable();
		} else if (menuName.equals("Save") || menuName.equals("Find") || menuName.equals("Replace")
				|| menuName.equals("Delete")) {
			myFileMenu.fileProcess(menuName);
		} else if (menuName.equals("Help")) {
			new HelpDocument();
		} else if (menuName.equals("Exit"))
			System.exit(0);
	} // actionPerformed method

}
