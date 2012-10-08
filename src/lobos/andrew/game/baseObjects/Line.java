package lobos.andrew.game.baseObjects;

import static org.lwjgl.opengl.GL11.*;

import lobos.andrew.game.scene.BasicObject;

public class Line extends BasicObject 
{
	float startX,startY,stopX,stopY;
	public Line(float startX, float startY, float stopX, float stopY, float posX, float posY)
	{
		super(posX,posY);
		
		this.startX = startX;
		this.startY = startY;
		
		this.stopX = stopX;
		this.stopY = stopY;
	}
	
	public float getStartX()
	{
		return startX;
	}
	
	public float getStartY()
	{
		return startY;
	}
	
	public float getStopX()
	{
		return stopX;
	}
	
	public float getStopY()
	{
		return stopY;
	}
	
	public Line(float length, float posX, float posY)
	{
		super(posX,posY);
		
		this.startX = 0;
		this.startY = 0;
		
		this.stopX = length;
		this.stopY = length;
	}
	
	
	public Line(float length, float angle, float posX, float posY)
	{
		super(posX, posY);
		
		this.startX = posX;
		this.startY = posY;
		
		float angleDeg = (float) Math.toRadians(angle);
		stopX = (float) (Math.cos(angleDeg)*length)+posX;
		stopY = (float) (Math.sin(angleDeg)*length)+posY;
	}

	@Override
	public void renderObject() 
	{
		glBegin(GL_LINES);
		glVertex2f(startX+getX(), startY+getY());
		glVertex2f(stopX+getX(), stopY+getY());
		glEnd();
		
		boundingBox.setExtremes(
				(startY>stopY ? startY:stopY),
				(startY<stopY ? startY:stopY),
				(startX<stopX? startX:stopX),
				(startX>stopX? startX:stopX));
		boundingBox.setLocation(getX(), getY());
	}
	
	



}
