/**
 * @author Sihang Li
 * This is the TextFileOpener class which: 
 * 1. has a constructor which receives the GUI object from its caller.  
 * 2. has a openFileHelper method that provides a GUI window for the user to choose a file. If the file is a .txt or .rtf file, the TextFileReader class will be called with the GUI object and the file and return true. 
 * 	  Else an error message will be printed and retrun null.  
 */
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class TextFileOpener {
	private TextEditorGUI myGUI;

	public TextFileOpener(TextEditorGUI myGUI) {
		this.myGUI = myGUI;
	} //Constructor 

	/**
	 * This method calls the TextFileReader class with the GUI object and the file opened if its a .txt or .rtf file 
	 * else it prints an error message and returns null
	 * @return myFile 
	 */
	public File openFileHelper() {
		File myFile;
		int status;
		JFileChooser chooser = new JFileChooser();
		status = chooser.showOpenDialog(null);
		if (status == JFileChooser.APPROVE_OPTION) {
			myFile = chooser.getSelectedFile();
			if (myFile.getName().endsWith("txt") || myFile.getName().endsWith("rtf")) {
				new TextFileReader(myGUI, myFile);
				return myFile;
			} else {
				JOptionPane.showMessageDialog(null, "This is not a .txt or .rtf file");
				return null;
			}
		}
		return null;
	} //openFileHelper method
}
