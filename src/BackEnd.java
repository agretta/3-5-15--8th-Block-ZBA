import java.io.File;
import java.util.ArrayList;





import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


public class BackEnd {
	public File z;
	Scanner scanner;
	
	public BackEnd (File f)
	{
		
		Encoder encoder = new Encoder(f);
		z = f;
		
	}
	
	public List <String>  getMessages(String username)
	{
		
		ArrayList messages = new ArrayList <String> ();
		
		
		
		
		return messages;	
		
		
		
	}
	public void addMessage(String username, String msg)
	{
		
		encoder.write(username + "	"+ msg);
		
		
		
	}
	public List <String> getUsers()
	{
		ArrayList<String> array = new ArrayList <String> ();
		
		
		return array;
	}
public static void main(String args[]){
		
		
	}
	
	
	
	
	
	
	

}
