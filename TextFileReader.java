/**
 * @author Sihang Li
 * This is the TextFileReader class which: 
 * 1. has a constructor which receives the GUI object and the file opened from its caller.  
 * 2. has a helper method TextFileReader that reads the file into a string.
 * 3. calls the GUI.setTextHelper method to print that string to the GUI window. 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
	private TextEditorGUI myGUI;
	private File myFile;

	public TextFileReader(TextEditorGUI myGUI, File myFile) {
		this.myGUI = myGUI;
		this.myFile = myFile;
		fileReaderHelper();
	} // Constructor

	/**
	 * This is the helper method fileReaderHelper. It creates an empty string which will be populated with the string read from the file.
	 * It then calls the GUI class' setTextHelper method to print that string to the GUI window. 
	 */
	private void fileReaderHelper() {
		String myText = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(myFile));
			String line = reader.readLine();
			while (line != null) {
				{
					myText = myText + line + System.lineSeparator();
					line = reader.readLine();
				}
			}
			reader.close();

		} catch (IOException e) {
		}
		myGUI.setTextHelper(myText);
	} // fileReaderHelper method
}
