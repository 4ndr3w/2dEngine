package lobos.andrew.game.scene;

import java.awt.Color;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Vector;

import javax.media.opengl.GL;

import lobos.andrew.game.hid.Keyboard;

public abstract class Scene implements KeyListener {
	private Vector<SceneObject> objects = new Vector<SceneObject>();
	private Color background = Color.white;
	
	public Scene()
	{
		Keyboard.getInstance().setHandler(this);
	}
	
	public void addObject(SceneObject o)
	{
		objects.add(o);
	}
	
	public Color getBackgroundColor()
	{
		return background;
	}
	
	public void setBackgroundColor(Color color)
	{
		background = color;
	}
	
	public void render(GL gl)
	{
		gl.glClearColor((float)background.getRed()/255, (float)background.getGreen()/255, (float)background.getBlue()/255, 0);
		Iterator<SceneObject> it = objects.iterator();
		while ( it.hasNext() )
		{
			SceneObject obj = (SceneObject) it.next();
			if ( obj.shouldRender() )
				obj.render(gl);
		}
	}
}
