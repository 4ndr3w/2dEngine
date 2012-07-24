package lobos.andrew.game.networking;

import java.util.HashMap;

public class PlayerTable {
	protected HashMap<String, Object> map;
	
	public PlayerTable()
	{
		map = new HashMap<String, Object>();
	}
	
	public HashMap<String, Object> getHashMap()
	{
		return map;
	}
	
	public void put(String key, Object value)
	{
		map.put(key, value);
	}
	
	public int getInt(String key)
	{
		return (Integer)map.get(key);
	}
	
	public float getFloat(String key)
	{
		if ( map.get(key) == null ) return 0;
		return Float.parseFloat((String) map.get(key));
	}
	
	public float getDouble(String key)
	{
		return (Float)map.get(key);
	}
	
	public Object get(String key)
	{
		return map.get(key);
	}
	
}
