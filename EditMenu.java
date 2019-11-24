
/**
 * @author Sihang Li
 * This is  the EditMenu class which accepts three parameters, the TextEditorGUI object "myGUI", the file open, "myFile", and the user tab user clicked on "myChoice"  and calls their respective classes. 
 */
import java.io.File;

public class EditMenu {
	private TextEditorGUI myGUI;
	private File myFile;
	private String myChoice;

	/**
	 * The constructor calls its helper method tabClicked. 
	 * @param myGUI
	 * @param myFile
	 * @param myChoice
	 */
	public EditMenu(TextEditorGUI myGUI, File myFile, String myChoice) {
		this.myGUI = myGUI;
		this.myFile = myFile;
		this.myChoice = myChoice;
		tabClicked();
	} // Constructor

	/**
	 * This method calls the class corresponding to "myChoice".  
	 */
	private void tabClicked() {
		if (myChoice.equals("Find")) {
			new WordFind(myGUI);
		} else if (myChoice.equals("Replace")) {
			new WordReplace(myGUI);
		} else if (myChoice.equals("Delete")) {
			new WordDelete(myGUI);
		}
	} // tabClicked method
}
