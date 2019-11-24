/**
 * @author Sihang Li
 * This is the WordReplace class which: 
 * 1. has a constructor which receives the GUI object and the file and also calls its helper method replaceHelper.  
 * 2. has a helper method replaceHelper that provides two GUI windows to capture the words the user wants to be replaced and replace with from the file. 
 */
import java.io.IOException;
import javax.swing.JOptionPane;

public class WordReplace {
	private TextEditorGUI myGUI;

	public WordReplace(TextEditorGUI myGUI) {
		this.myGUI = myGUI;
		replaceHelper();
	}//Constructor 

	/**
	 * This is the replaceHelper method.
	 * It first captures the word in the file the user wants to be replaced. 
	 * It then calls the WordValidityCheck class to check if that word is valid English.
	 * It then calls the WordCount class to count the number of that word in the file.
	 * It prints a message if the number of the word in the file is zero and stops.
	 * It then provides another GUI window to capture the word the user wants to replace the previous word with.
	 * It then calls the WordValidityCheck class to check if that word is valid English.
	 * It then calls the WordCount class to count the number of that word in the file.
	 * It prints a message if the number of the word in the file is zero and stops.
	 * It calls the TextFileWriter class with parameters, GUI object, wordCount, newWord, keyWord, and String "Replace". 
	 */
	private  void replaceHelper() {
		WordValidityCheck isEnglishWord;
		WordCount myWordCount;
		String oldWord;
		boolean oldWordValid = false;
		boolean isWhiteSpace = false;
		oldWord = JOptionPane.showInputDialog(null, "Which word would you like to replace?");//Captures the first user input
		if (oldWord != null) //Checks if the user pressed "ok" without entering anything or just spaces.
		isWhiteSpace = oldWord.matches("\\s+");
		
		if (oldWord != null && !isWhiteSpace && !oldWord.isEmpty()) { // If the user cancels the input, no need to proceed.
			isEnglishWord = new WordValidityCheck(oldWord); //Checks if the word is a valid English word
			oldWordValid = isEnglishWord.validityCheckHelper();
			if (oldWordValid == true) {
				myWordCount = new WordCount(myGUI); //Counts the number of word in that file. 
				int wordCount = myWordCount.wordCountFinder(oldWord);
				if (wordCount <= 0)
					JOptionPane.showMessageDialog(null, "There is no '" + oldWord + "' in the file."); 
				else {
					String newWord;
					boolean newWordValid = true;
					newWord = JOptionPane.showInputDialog(null, "Which word would you like to replace '" + oldWord + "' with?"); //Captures the second user input
					if (newWord != null) //Checks if the user pressed "ok" without entering anything or just spaces.
					isWhiteSpace = newWord.matches("\\s+");
					
					if (newWord != null && !isWhiteSpace && !newWord.isEmpty()) {
						isEnglishWord = new WordValidityCheck(newWord); //Checks if the word is a valid English word
						newWordValid = isEnglishWord.validityCheckHelper();
						if (newWordValid == true) {
							try {
								new TextFileWriter(myGUI, wordCount, newWord, oldWord, "Replace"); //Calls the TextFileWriter class. 
							} catch (IOException e) {
							}
						}
					}
				}
			}
		}
	}//replaceHelper method
}
