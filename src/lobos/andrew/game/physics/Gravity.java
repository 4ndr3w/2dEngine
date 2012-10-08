package lobos.andrew.game.physics;

import java.util.Iterator;

import lobos.andrew.game.core.Renderer;
import lobos.andrew.game.scene.SceneObject;

public class Gravity 
{
	public static Gravity instance = null;
	
	public static Gravity getInstance()
	{
		if ( instance == null )
			instance = new Gravity();
		return instance;
	}
	
	public Gravity()
	{
	}
	
	public void run()
	{
		Iterator<SceneObject> it = Renderer.getCurrentScene().iterator();
		while ( it.hasNext() )
		{
			SceneObject thisObject = it.next();
			if ( thisObject.isGravityAffected() && !Contact.isTouchingSomethingSolid(thisObject) )
				thisObject.setLocation(thisObject.getX(), thisObject.getY()-0.01f);
		}
	}
	
}
