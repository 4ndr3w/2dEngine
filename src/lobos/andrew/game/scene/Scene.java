package lobos.andrew.game.scene;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Vector;

import static org.lwjgl.opengl.GL11.*;
import lobos.andrew.game.objects.ControllableCharacter;
import lobos.andrew.game.physics.Gravity;

public abstract class Scene implements KeyListener {
	private Vector<SceneObject> objects = new Vector<SceneObject>();
	private Color background = Color.white;
	private ControllableCharacter character = null;
	
	public Scene()
	{
	}
	
	public void addObject(SceneObject o)
	{
		objects.add(o);
	}
	
	public void setCharacter(ControllableCharacter character)
	{
		this.character = character;
	}
	
	public Color getBackgroundColor()
	{
		return background;
	}
	
	public void setBackgroundColor(Color color)
	{
		background = color;
	}
	
	public void render()
	{
		sceneLogic();
		
		Gravity.getInstance().run();
		glClearColor((float)background.getRed()/255, (float)background.getGreen()/255, (float)background.getBlue()/255, 0);
		Iterator<SceneObject> it = objects.iterator();
		while ( it.hasNext() )
		{
			SceneObject obj = (SceneObject) it.next();
			if ( obj.shouldRender() )
				obj.render();
		}
	}
	
	public abstract void sceneLogic();
	
	public Iterator<SceneObject> iterator()
	{
		return objects.iterator();
	}

	@Override
	public void keyPressed(KeyEvent event) 
	{
		if ( character != null )
		{
			if ( event.getKeyChar() == 'a' )
				character.moveLeft();
			else if ( event.getKeyChar() == 'd' )
				character.moveRight();	
			else if ( event.getKeyChar() == 'w' )
				character.moveUp();	
			else if ( event.getKeyChar() == 's' )
				character.moveDown();	
			else if ( event.getKeyChar() == 'e' )
			{
				Iterator<SceneObject> it = objects.iterator();
				while ( it.hasNext() )
				{
					SceneObject obj = it.next();
					if ( obj.isTouching(character) && obj.interactable() )
					{
						
					}
						
				}
			}
		}
	}
	
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
