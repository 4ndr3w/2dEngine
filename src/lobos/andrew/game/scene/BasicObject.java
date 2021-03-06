package lobos.andrew.game.scene;

import java.awt.Color;
import java.util.Iterator;
import java.util.Vector;

import static org.lwjgl.opengl.GL11.*;

import lobos.andrew.game.baseObjects.BoundingBox;
import lobos.andrew.game.networking.Properties;
import lobos.andrew.game.physics.Force;

public abstract class BasicObject implements SceneObject {
	private boolean doRender = true;
	protected Color color = Color.black;
	protected BoundingBox boundingBox = new BoundingBox();
	protected boolean gravityAffected = false;
	public abstract void renderObject();
	protected Surface solidType = Surface.NOTSOLID;
	protected Force appliedForce = null;
	private Properties properties = new Properties();
	protected Vector<SceneObject> subscribedObjects = new Vector<SceneObject>();
	
	public void setPropertiesProvider(Properties p)
	{
		properties = p;
	}
	
	public void render()
	{
		if ( appliedForce != null )
		{
			if ( appliedForce.shouldApply() )
			{
				appliedForce.update(this);
				appliedForce.finishedIteration();
			}
			else appliedForce = null;
		}

		
		glColor3f((float)color.getRed()/255, (float)color.getGreen()/255, (float)color.getBlue()/255);
		renderObject();
		boundingBox.render();
	}
	
	protected float x,y,parentX,parentY;
	
	public BasicObject(float x, float y)
	{
		setLocation(x,y);
	}
	
	public boolean shouldRender()
	{
		return doRender;
	}
	
	public void show()
	{
		doRender = true;
	}
	
	public void hide()
	{
		doRender = false;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void setColor(Color color)
	{
		this.color = color;
	}
	
	public void setLocation(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setParentLocation(float x, float y)
	{
		this.parentX = x;
		this.parentY = y;
	}
	
	public float getX()
	{
		return x+parentX;
	}
	
	public float getY()
	{
		return y+parentY;
	}
	
	public boolean isSolid()
	{
		return solidType != Surface.NOTSOLID;
	}
	
	public Surface getSurfaceType()
	{
		return solidType;
	}
	
	@Override
	public BoundingBox getBoundingBox() {
		return boundingBox;
	}
	
	@Override
	public boolean isTouching(SceneObject obj) {
		return obj.boundingCheck(getBoundingBox());
	}
	
	@Override
	public boolean boundingCheck(BoundingBox box)
	{
		return box.intersects(getBoundingBox());
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
	
	public void applyForce(Force f)
	{
		appliedForce = f;
	}
	
	@Override
	public Force getForce() {
		return appliedForce;
	}
	
	@Override
	public boolean isOutOfBounds() {
		return (getY()>=1.0f)||(getY()<=-1.0f)||(getX()>=1.0f)||(getX()<=-1.0f);
	}
	
	public Properties getProperties()
	{
		return properties;
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
}
