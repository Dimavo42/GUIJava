package source;

import java.util.HashMap;


public class PasswordUsername {
	private HashMap<String,String>UsernamePassword;
	public PasswordUsername()
	{
		//Deafult Users
		this.UsernamePassword=new HashMap<>();
		this.UsernamePassword.put("Dima","1234");
		this.UsernamePassword.put("Dima","1111");
		this.UsernamePassword.put("dima","1");
		this.UsernamePassword.put("1","1");
	}
	
	public void add(String Username,String Password)
	{
		this.UsernamePassword.put(Username,Password);
	}
	public void remove(String Username,String Password)
	{
		this.UsernamePassword.forEach( (key,value)->
		{
			if(key.contentEquals(Username))
			{
				this.UsernamePassword.remove(key);
			}
		});
	}
	public HashMap<String,String> GetInfo()
	{
		return this.UsernamePassword;
	}
}
