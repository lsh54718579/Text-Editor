/**
 * @author Sihang Li
 * This is the WordFind class which: 
 * 1. has a constructor which receives the file and also calls its helper method finderHelper.  
 * 2. has a helper method finderHelper that finds the occurrences of a word in the file. 
 */
import javax.swing.JOptionPane;

public class WordFind {
TextEditorGUI myGUI;
	public WordFind(TextEditorGUI myGUI) {
		this.myGUI = myGUI;
		finderHelper();
	} //Constructor

	/**
	 * This is the finderHelper method. 
	 * It provides a GUI window for the user to input a word to find.
	 * It calls the WordValidityCheck class to check if the input is valid English 
	 * It calls the WordCount class to find the number of occurrences of that word. 
	 * It prints the number of occurrences of that word to a GUI window. 
	 */
	private void finderHelper() {
		WordValidityCheck isEnglishWord;
		WordCount myWordCount;
		String keyWord;
		boolean keyWordValid = false;
		boolean isWhiteSpace = false;
		int wordCount = 0;
		keyWord = JOptionPane.showInputDialog(null, "Which word do you want to find?"); //Captures the user input 
		if (keyWord != null) //Checks if the user pressed "ok" without entering anything or just spaces. 
		isWhiteSpace = keyWord.matches("\\s+");
		
		if (keyWord != null && !isWhiteSpace && !keyWord.isEmpty()) { // If the user cancels the input, no need to proceed.
			isEnglishWord = new WordValidityCheck(keyWord); //Checks if the word is a valid English word. 
			keyWordValid = isEnglishWord.validityCheckHelper();
			if (keyWordValid == true) { 
				myWordCount = new WordCount(myGUI); //Counts the number of word in that file. 
				wordCount = myWordCount.wordCountFinder(keyWord);
				JOptionPane.showMessageDialog(null, "Number of  '" + keyWord + "' in the file is: " + wordCount); //Prints the number of that word in the file. 
			}
		}
	} //finderHelper method. 
}
