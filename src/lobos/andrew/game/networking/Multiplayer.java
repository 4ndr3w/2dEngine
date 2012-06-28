package lobos.andrew.game.networking;

import java.util.HashMap;

public class Multiplayer 
{
	public static Multiplayer findOpponent()
	{
		return new Multiplayer();
	}
	
	public int getMyPlayerNumber()
	{
		return 0;
	}
	
	public int getOpponentPlayerNumber()
	{
		return 1;
	}
	
	public HashMap<String,String> getOpponentDatamap()
	{
		return new HashMap();
	}
	
	public HashMap<String,String> getMyDatamap()
	{
		return new HashMap();
	}
	
	
}
