/**
 * @author Sihang Li
 * This is the WordCount class which: 
 * 1. has a constructor which receives the TextEditorGUI object.  
 * 2. has a helper method wordCountFinder that accepts a parameter from its caller, the keyWord to search for the occurrences of that word in the JTextArea and returns the word count. 
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {
	private TextEditorGUI myGUI;

	public WordCount(TextEditorGUI myGUI) {
		this.myGUI = myGUI;
	}// Constructor

	/**
	 * This is the helper method wordCountFinder. 
	 * It accepts a parameter keyWord of type String from its caller. 
	 * It initializes a variable called wordCount to count the occurrences of the keyword in the file.
	 * It then reads the file again and parse it into an array of strings line by line while remove all the delimiters. 
	 * Finally it compares the keyWord to the string array and increment the wordCount if a match is found.
	 * @param keyWord
	 * @return wordCount 
	 */
	public int wordCountFinder(String keyWord) {
		int wordCount = 0;
		String tempText = myGUI.myTextArea.getText();
		String pattern = "\\b" + keyWord + "\\b"; // sets the boundaries between the word so that the find() method only
													// finds the exact strings.
		Pattern p = Pattern.compile(pattern.toLowerCase());
		Matcher m = p.matcher(tempText.toLowerCase());
		while (m.find()) {
			wordCount++;
		}
		return wordCount;
	}// wordCountFinder method
}
