/**
 * Sihang Li
 * This is the TextFileWriter class which: 
 * 1. has a constructor that receives the GUI object, the wordCount, the newString, the oldString and the choice from its caller and also calls its helper method fileWriterHelper.  
 * 2. has a helper method fileSaverHelper that saves the content in the current GUI window to the original file. 
 * 3. has a displayResult method to show the result to a GUI window. 
 */
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class TextFileWriter {
	private TextEditorGUI myGUI;
	private String newWord;
	private String oldWord;
	private int wordCount;
	private String choice;

	public TextFileWriter(TextEditorGUI myGUI, int wordCount, String newWord, String oldWord, String choice)
			throws IOException {
		this.myGUI = myGUI;
		this.newWord = newWord;
		this.oldWord = oldWord;
		this.wordCount = wordCount;
		this.choice = choice;
		fileWriterHelper();
	} // Constructor

/**
	 * This is the helper method fileWriterHelper. 
	 * It initializes a string which gets its content from the JTextArea of the GUI window.
	 * It then uses the pattern and matcher methods to find all the occurrences of the word to be replaced in the string and replace them with the new word. 
	 * It records the number of words successfully replaced and pass that and the choice to the displayResult method. 
	 * It also updates the content in the current GUI JTextArea to the new content. 
	 */
	private void fileWriterHelper() {
		String newText = new String();
		String tempText = myGUI.myTextArea.getText();
		String pattern = "\\b" + oldWord + "\\b"; // sets the boundaries between the word so that the find() method only
													// finds the exact strings.
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(tempText);
		int sucessfulReplacement = 0;
		while (m.find()) {
			sucessfulReplacement++;
		}
		newText = m.replaceAll(newWord);
		myGUI.setTextHelper(newText);
		displayResult(sucessfulReplacement, choice);
	} // fileWriterHelper method

	/**
	 * This is the method displayResult. 
	 * It displays the result of replacement or deletion based on the choice. 
	 */
	private void displayResult(int sucessfulReplacement, String choice) {
		int failedReplacement = wordCount - sucessfulReplacement;
		if (choice.equals("Replace")) {
			if (failedReplacement == 0) {
				JOptionPane.showMessageDialog(null, "Number of '" + oldWord + "' successfully replaced with '" + newWord
						+ "' is : " + sucessfulReplacement);
			} else {
				JOptionPane.showMessageDialog(null,
						"Number of '" + oldWord + "' successfully replaced with '" + newWord + "' is : "
								+ sucessfulReplacement + "\n"
								+ "Number of '"+oldWord+"' failed to be replaced because of case sensitivity is: "
								+ failedReplacement);
			}

		} else if (choice.equals("Delete")) {
			if (failedReplacement == 0) {
				JOptionPane.showMessageDialog(null,
						"Number of '" + oldWord + "' successfully deleted is: " + sucessfulReplacement);
			} else {
				JOptionPane.showMessageDialog(null,
						"Number of '" + oldWord + "' successfully deleted is: " + sucessfulReplacement + "\n"
								+ "Number of '"+oldWord+"' failed to be deleted because of case sensitivity is: "+ failedReplacement);
			}
		}
	}// displayResult method

}