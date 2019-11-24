/**
 * @author Sihang Li
 * This is the TextFileSaver class which: 
 * 1. has a constructor which receives the GUI object and the file from its caller and also calls its helper method fileSaveHelper.  
 * 2. has a helper method fileSaverHelper that saves the content in the current GUI window to the original file. 
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class TextFileSaver {
	private TextEditorGUI myGUI;
	private File myFile;

	public TextFileSaver(TextEditorGUI myGUI, File myFile) {
		this.myGUI = myGUI;
		this.myFile = myFile;
		fileSaverHelper();
	} // Constructor	

	/**
	 * This is the helper method fileSaveHelper method
	 * It initializes a FileWriter object and writes the content in the current GUI window to the original file and prints a message indicating the save is successful. 
	 */
	private void fileSaverHelper() {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(myFile);
			fileWriter.write(myGUI.myTextArea.getText());
			fileWriter.close();
			JOptionPane.showMessageDialog(null, "File sucessfully saved.");
		} catch (IOException e) {
		}
	} // fileSaverHelper method
}
