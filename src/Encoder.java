import java.util.*;
import java.io.*;
public class Encoder {
	
	private File myFile;
	private static String source=" abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789\t=";
	private static String target=" zyxwvutsrqponmlkjihgfedcbaQ9A8ZWS7XEDC6RFVT5GBY4HNU3J2MI1KO0LP\t*";
	
	
	public Encoder(File f){
		myFile = f;
	}
	
	
	public void write(String plainText){
		try {
			PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter(myFile,true)));
			print.println(this.obfuscate(plainText));
			print.close();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public List<String> read(){
		LinkedList<String> list = new LinkedList<String>();
		try
		{
			Scanner scan = new Scanner(myFile);
			while(scan.hasNextLine()){
				list.add( unobfuscate(scan.nextLine()));
			}
			scan.close();
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		
		return list;
	}
	
	
	

	public String obfuscate(String s) {
	    String result = "";
	    for (int i=0;i<s.length();i++) {
	        char c=s.charAt(i);
	        int index=source.indexOf(c);
	        result += target.charAt(index);
	    }

	    return new String(result);
	}

	public String unobfuscate(String s) {
		String result = "";
	    for (int i=0;i<s.length();i++) {
	        char c=s.charAt(i);
	        int index=target.indexOf(c);
	        result += source.charAt(index);
	    }

	    return new String(result);
	}
}
