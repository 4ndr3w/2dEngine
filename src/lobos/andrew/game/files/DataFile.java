package lobos.andrew.game.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class DataFile {
	HashMap <String, String> data = new HashMap <String, String>();
	File file = null;
	static String seperator = String.valueOf((char)31);
	public DataFile(String file) throws IOException
	{
		this.file = new File(file);
		if ( !this.file.exists() )
			this.file.createNewFile();
		else
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
		
			while ( reader.ready())
			{
				String line = reader.readLine();
				String[] splitdata = line.split(seperator);
				if ( splitdata.length == 2 )
					data.put(splitdata[0], splitdata[1]);
			}
		}
	}
	
	public void save() throws IOException
	{
		FileWriter fw = new FileWriter(file);
		String fdata = "";
		Iterator<String> it = data.keySet().iterator();
		while ( it.hasNext() )
		{
			String key = it.next();
			System.out.println(key);
			fdata += key+seperator+data.get(key)+"\n";
		}
		System.out.println("Writing: "+fdata);
		fw.write(fdata);
		fw.flush();
		fw.close();
	}
	
	public void put(String key, String value)
	{
		data.put(key, value);
	}
	
	public void put(String key, float value)
	{
		data.put(key, Float.toString(value));
	}
	
	public void put(String key, int value)
	{
		data.put(key, Integer.toString(value));
	}
	
	public void put(String key, boolean value)
	{
		data.put(key, (value?"1":"0"));
	}
	
	public String getString(String key)
	{
		if ( !keyExists(key) )
			return "";
		
		return data.get(key);
	}
	
	public Float getFloat(String key)
	{
		if ( !keyExists(key) )
			return 0.0f;
		
		return Float.parseFloat(getString(key));
	}
	
	public Integer getInt(String key)
	{
		if ( !keyExists(key) )
			return 0;
		
		return Integer.parseInt(getString(key));
	}
	
	public boolean getBoolean(String key)
	{
		if ( !keyExists(key) )
			return false;
		
		return getString(key).equals("1");
	}
	
	public boolean keyExists(String key)
	{
		return data.containsKey(key);
	}
}
