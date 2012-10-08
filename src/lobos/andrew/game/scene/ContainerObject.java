package lobos.andrew.game.scene;

import java.util.Iterator;
import java.util.Vector;


import lobos.andrew.game.baseObjects.BoundingBox;
import lobos.andrew.game.physics.Force;

public class ContainerObject implements SceneObject {
	private Vector<SceneObject> objects = new Vector<SceneObject>();
	
	protected float xPos;
	protected float yPos;
	protected boolean gravityAffected = false;
	protected Surface solidType = Surface.NOTSOLID;
	protected Force appliedForce = null;
	protected Vector<SceneObject> subscribedObjects = new Vector<SceneObject>();
	
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
		xPos = x;
		yPos = y;
		Iterator<SceneObject> it = objects.iterator();
		while ( it.hasNext() )
			it.next().setParentLocation(x,y);
	}

	@Override
	public boolean shouldRender() {
		return true;
	}

	@Override
	public void render() {
		Iterator<SceneObject> it = objects.iterator();
		while ( it.hasNext() )
		{
			SceneObject thisObject = it.next();
			thisObject.render();
			thisObject.getBoundingBox().render();
		}
			
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

	@Override
	public boolean isTouching(SceneObject obj) {
		Iterator<SceneObject> it = objects.iterator();
		while ( it.hasNext() )
		{
			SceneObject thisObject = it.next();
			if ( obj.boundingCheck(thisObject.getBoundingBox()) )
				return true;
		}
		return false;
	}
	
	public float getX()
	{
		return xPos;
	}
	
	public float getY()
	{
		return yPos;
	}

	@Override
	public boolean isSolid() {
		return solidType != Surface.NOTSOLID;
	}

	@Override
	public boolean boundingCheck(BoundingBox box) {
		Iterator<SceneObject> it = objects.iterator();
		
		while ( it.hasNext() )
		{
			SceneObject thisObject = it.next();
			if ( thisObject.boundingCheck(box) )
				return true;
		}
		return false;
	}
	
	@Override
	public void interact() {
		Iterator<SceneObject> it = subscribedObjects.iterator();
		while (it.hasNext())
		{
			it.next().interact();
		}
	}
	
	public boolean interactable()
	{ 
		return false;
	}
	
	public void subscribe(SceneObject obj)
	{
		subscribedObjects.add(obj);
	}

	@Override
	public BoundingBox getBoundingBox() {
		return null;
	}

	@Override
	public boolean isGravityAffected() {
		return gravityAffected;
	}

	@Override
	public void setGravityAffected(boolean state) {
		gravityAffected = state;
	}

	@Override
	public void setSolidFromSide(Surface side) {
		solidType = side;
	}

	@Override
	public Surface getSurfaceType() {
		return solidType;
	}

	@Override
	public void applyForce(Force f) {
		Iterator<SceneObject> it = objects.iterator();
		
		while ( it.hasNext() )
			it.next().applyForce(f);
	}

	@Override
	public boolean isOutOfBounds() {
		return (getY()>=1.0f)||(getY()<=-1.0f)||(getX()>=1.0f)||(getX()<=-1.0f);
	}

	@Override
	public Force getForce() {
		return objects.get(0).getForce();
	}
	
}
