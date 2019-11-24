
/**
 * @author Sihang Li
 * This class checks if the word user entered is a English word.
 * It has a constructor that receives the word to be looked for from the caller.  
 * It has a helper method called validityCheckHelper.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

import javax.swing.JOptionPane;

public class WordValidityCheck {
	private String KeyWord;

	public WordValidityCheck(String keyWord) {
		this.KeyWord = keyWord;
	}// Constructor

	/**
	 * This is the helper method validityCheckHelper.
	 * It reads from a local "Dictionary.txt" file as the English dictionary. 
	 * It returns true if the word can be found in the dictionary file and false otherwise. 
	 * @return boolean 
	 */
	public boolean validityCheckHelper() {
		String str;
		int cont;
		HashSet<String> mySet = new HashSet<>(); //Initializes a HashSet to store all the dictionary words for lookup. 
		try {
			InputStream is = getClass().getResourceAsStream("Dictionary.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader inFile = new BufferedReader(isr);
			while ((str = inFile.readLine()) != null) {
				mySet.add(str.toLowerCase()); //Stores all the dictionary words in the HashSet.
			}
			inFile.close();
		} catch (IOException e) {
		}
		if (mySet.contains(KeyWord.replaceAll("\\s+", "").toLowerCase())) //Compares the lowercase keyWord to the HashSet
			return true;

		cont = JOptionPane.showConfirmDialog(null, "The word you entered is not a Engish word, contiune anyway?", null,
				JOptionPane.OK_CANCEL_OPTION); 
		if (cont == 0)
			return true;
		else
			return false;
	}// Checks against local dictionary, return true if word found, false otherwise.
}