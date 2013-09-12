package secure.delete.window.process;

import secure.delete.window.utils.Constants;

public final class DeleteFactory
{
	 
	
	
	public Delete getInstance(String action)
	{
		if(Constants.DELETE.equals(action))
		{
			return new SimpleDelete();
		}
		else if(Constants.SECURE_DELETE.equals(action))
		{
			return new SecureDelete();
		}
		else if(Constants.Complete_Delete.equals(action))
		{
			return new CompleteDelete();
		}
		
		return null;
			
	}
	

}
