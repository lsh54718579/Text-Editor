/**
* @author Sihang Li
 *This is the HelpDocument class, its main job is to initialize a string of message and display it to a GUI window when the "help" item is clicked. 
 *
 */
import javax.swing.JOptionPane;

//This class contains help document
public class HelpDocument {
	
	public HelpDocument() {
		printMessage();
	} //Constructor 
	
	private String helpMessage() {
		String helpMsg=new String("Notes:"
				+"\n"+ " (1). A file must be open in order for the 'save','find','replace' and 'delete' functions to work."
				+"\n"+ " (2). The 'Find' function is not case sensitive, meaning it finds all the occurrences of the word, no matter their case differences." 
				+"\n"+ " (3). The 'replace' and 'delete' functions are case sensitive, meanning only the words with the exact same case will be replaced or deleted.");
		return helpMsg;
	} //helpMessage method
	
	private void printMessage() {
		JOptionPane.showMessageDialog(null, helpMessage());
	} //printMessage method
}
