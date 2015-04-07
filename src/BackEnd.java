import java.io.File;
import java.util.ArrayList;
import java.util.List;







public class BackEnd {	//done
	
	
	private Encoder encoder;
	
	public BackEnd (File f)
	{
		
		encoder = new Encoder(f);
		
		
	}
	
	public List <String>  getMessages(String username)   //done
	{
		
		List <String> allMessages = new ArrayList<String> ();
		List <String> Messages = new ArrayList<String> ();
		
		allMessages = encoder.read();
		
		for (String g : allMessages)
		{
			String[] split = g.split("=");
			if (split[0].equals( username))
				Messages.add(split[0]);
				
			
		}
		
		
		return Messages;	
		
		
		
	}
	public void addMessage(String username, String msg)	//done
	{
		
		encoder.write(username + "=" + msg);
		
		
		
	}
	public List <String> getUsers()
	{
		ArrayList<String> usernames = new ArrayList <String> ();
		List <String> allMessages = new ArrayList<String> ();
		
		
		allMessages = encoder.read();
		
		for (String g : allMessages)
		{
			String[] split = g.split("=");
			
			
			for (String x : usernames)
			{ 
				
				if (x.equals(split[0]) == false);
					usernames.add(split[0]);
			}
			
		}
		
		
		return usernames;	
		
		
		
		
		
	}
public static void main(String args[]){
		
		
	}
	
	
	
	
	
	
	

}
