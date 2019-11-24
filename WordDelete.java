/**
 * @author Sihang Li
 * This is the WordDelete class which: 
 * 1. has a constructor which receives the GUI object and the file and also calls its helper method deleteHelper.  
 * 2. has a helper method deleteHelper that provides a GUI window to capture the word the user wants to delete from the file. 
 */
import java.io.IOException;
import javax.swing.JOptionPane;

public class WordDelete {
	private TextEditorGUI myGUI;

	public WordDelete(TextEditorGUI myGUI) {
		this.myGUI = myGUI;
		deleteHelper();
	} //Constructor 
/**
 * This is the helper method deleteHelper.
 * It provides a GUI window for the user to input the word to be deleted.
 * It calls the WordValidityCheck class to check if the word is a valid English word.
 * If there is no such word in the file, it prints an error message.
 * It calls the TextFileWriter class with parameters, GUI object, wordCount, newWord, keyWord, and String "Delete". 
 */
	private void deleteHelper() {
		WordValidityCheck isEnglishWord; 
		WordCount myWordCount;
		String keyWord;
		boolean keyWordValid = false;
		boolean isWhiteSpace = false; 
		keyWord = JOptionPane.showInputDialog(null, "Which word would you like to delete?"); //Captures user input
		if (keyWord != null) //Checks if the user pressed "ok" without entering anything or just spaces. 
		isWhiteSpace = keyWord.matches("\\s+");
		
		if (keyWord != null && !isWhiteSpace && !keyWord.isEmpty()) { // If the user cancels the input or enters nothing, then no need to proceed.
			isEnglishWord = new WordValidityCheck(keyWord); //Checks if the word is a valid English word. 
			keyWordValid = isEnglishWord.validityCheckHelper();
			if (keyWordValid == true) {
				myWordCount = new WordCount(myGUI); //Counts the number of word in that file. 
				int wordCount = myWordCount.wordCountFinder(keyWord);				
				if (wordCount <= 0)
					JOptionPane.showMessageDialog(null, "There is no '" + keyWord + "' in the file."); 
				else {
					String newWord = ""; //Initializes the newWord as "" to replace the oldWord. 
					try {
						new TextFileWriter(myGUI, wordCount, newWord, keyWord,"Delete"); //Calls the TextFileWriter class. 
					} catch (IOException e) {
					}
				}
			}
		}
	}//deleteHelper method 
}
