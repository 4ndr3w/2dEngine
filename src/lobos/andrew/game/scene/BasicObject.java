package lobos.andrew.game.scene;

import java.awt.Color;

import javax.media.opengl.GL;

public abstract class BasicObject implements SceneObject {
	private boolean doRender = true;
	private Color color = Color.black;
	
	public abstract void renderObject(GL gl);
	
	public void render(GL gl)
	{
		gl.glColor3f((float)color.getRed()/255, (float)color.getGreen()/255, (float)color.getBlue()/255);
		renderObject(gl);
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
}
