package lobos.andrew.game.physics;

import java.util.Iterator;
import java.util.Vector;

import lobos.andrew.game.core.Renderer;
import lobos.andrew.game.scene.SceneObject;

public class Contact 
{

	public static boolean isTouchingSomethingSolid(SceneObject obj)
	{
		return list(obj).size() != 0;
	}
	
	public static Vector<SceneObject> list(SceneObject obj)
	{
		Iterator<SceneObject> it = Renderer.getInstance().getCurrentScene().iterator();
		Vector<SceneObject> objectList = new Vector();
		while ( it.hasNext() )
		{
			SceneObject thisObject = it.next();
			if ( !obj.equals(thisObject) )
			{
				if ( thisObject.isTouching(obj) )
					objectList.add(thisObject);
			}
		}
		return objectList;
	}	
	
}
