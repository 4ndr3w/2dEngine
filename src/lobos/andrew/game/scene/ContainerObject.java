package lobos.andrew.game.scene;

import java.util.Iterator;
import java.util.Vector;

import javax.media.opengl.GL;

public class ContainerObject implements SceneObject {
	private Vector<SceneObject> objects = new Vector<SceneObject>();
	
	float xPos, yPos;
	
	public ContainerObject(float xPos, float yPos)
	{
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void addObject(SceneObject obj)
	{
		objects.add(obj);
	}
	
	public void setLocation(float x, float y)
	{
		Iterator<SceneObject> it = objects.iterator();
		while ( it.hasNext() )
			it.next().setParentLocation(x,y);
	}

	@Override
	public boolean shouldRender() {
		return true;
	}

	@Override
	public void render(GL gl) {
		Iterator<SceneObject> it = objects.iterator();
		while ( it.hasNext() )
			it.next().render(gl);
	}

	@Override
	public void setParentLocation(float x, float y) 
	{
		System.out.println("Container inside container is not supported!");
	}
	
	public void initPos()
	{
		setLocation(xPos, yPos);
	}
	
}
