/**
 * @author Sihang Li
 * This is the driver class which instantiates the TextEditorGUI class and
 * prints a message to the default window which briefly explains what the software does.
 * 
 */
public class Project1 {
	public static void main(String args[]) {
		new TextEditorGUI(
				" You can: " + "\n" + " (1). Open a .txt or .rtf file." + "\n"
						+ " (2). Directly change the content of the file." + "\n"
						+ " (3). Save the file to its original location." + "\n" 
						+ " (4). Find the number of all occurances of a word in the file. (Case insensitive)" + "\n"
						+ " (5). Replace all occurances of a word with another one. (Case sensitive)" + "\n"
						+ " (6). Delete all occurances a word from the file. (Case sensitive)");
	} //Driver method
}