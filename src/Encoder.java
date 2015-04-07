import java.util.*;
import java.io.*;
public class Encoder {
	
	private File myFile;
	//Key for the obf	uscation
	private static String source=" abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789\t=";
	private static String target=" zyxwvutsrqponmlkjihgfedcbaQ9A8ZWS7XEDC6RFVT5GBY4HNU3J2MI1KO0LP\t*";
	
	//basic constructor
	public Encoder(File f){
		myFile = f;
	}
	
	//Writes to myFile a single line, after encrypting the line
	public void write(String plainText){
		try {
			PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter(myFile,true)));//Prints on new line each time
			print.println(this.obfuscate(plainText)); //writes plainText in its encoded form 
			print.close();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	//Return the whole list of messages in the file
	//each line(Username === message) is its own index position 
	public List<String> read(){
		LinkedList<String> list = new LinkedList<String>();
		try	{
			Scanner scan = new Scanner(myFile);
			while(scan.hasNextLine()){
				list.add( unobfuscate(scan.nextLine()));//unencrypts the file and fits each line into one index 
			}
			scan.close();
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		return list;
	}
	

	//encodes the given string with source to target
	public String obfuscate(String plainText) {
	    String result = "";
	    for (int i=0;i<plainText.length();i++) {
	        char c = plainText.charAt(i);
	        int index = source.indexOf(c);
	        result += target.charAt(index);
	    }
	    return new String(result);
	}
	
	
	
	//decodes the given string with target to source
	public String unobfuscate(String obsfuscatedText) {
		String result = "";
	    for (int i=0;i<obsfuscatedText.length();i++) {
	        char c = obsfuscatedText.charAt(i);
	        int index = target.indexOf(c);
	        result += source.charAt(index);
	    }
	    return new String(result);
	}
}
