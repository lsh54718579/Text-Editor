
/**
* @author Sihang Li
 *This is the FileProcess class. It has one constructor which receives the GUI object from its caller class.
 *The fileProcess method receives a String "choice" from its called class and returns boolean. If the choice is "Open", it calls the TextFileOpener class and catches the file from that class.
 *If a file is open, it will return true, else returns false. 
 *If the choice is "save", the method will call the TextFileSaver class and pass parameters "myGUI" and "chosenFile" to it. 
 *If the choice is not "Save", the method will call the EditMenu and pass parameters myGUI and "choice" to it. 
 */
import java.io.File;

public class FileMenu {
	private TextEditorGUI myGUI;
	private static File chosenFile = new File(""); // Static type and initialized to new File("") to avoid
													// nullPointerException before and after a file is opened.

	public FileMenu(TextEditorGUI myGUI) {
		this.myGUI = myGUI;
	} // Constructor

	
/**
 * This method calls the classes TextFileOpener, TextFileSaver, and EditMenu corresponding to choices "Open", "Save", etc. 
 * It returns true if a file is open and false otherwise. 
 * @param choice
 * @return boolean
 */
	public boolean fileProcess(String choice) {
		TextFileOpener myFileOpener;
		if (choice.equals("Open")) {
			myFileOpener = new TextFileOpener(myGUI);
			chosenFile = myFileOpener.openFileHelper();
			if (chosenFile != null)
				return true;
		} else {
			if (choice.equals("Save")) {
				new TextFileSaver(myGUI, chosenFile);
			} else {
				new EditMenu(myGUI, chosenFile, choice);
			}
		}
		return false;
	} // fileProcess method

}
