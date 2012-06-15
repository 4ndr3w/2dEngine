package lobos.andrew.game.baseObjects;

import javax.media.opengl.GL;

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
	
	public Line(float length, float angle, float posX, float posY)
	{
		super(posX, posY);
		
		this.startX = posX;
		this.startY = posY;
		
		float angleDeg = (float) Math.toRadians(angle);
		stopX = (float) (Math.cos(angleDeg)*length);
		stopY = (float) (Math.sin(angleDeg)*length);
	}

	@Override
	public void renderObject(GL gl) 
	{
		gl.glBegin(GL.GL_LINES);
		gl.glVertex2f(startX+getX(), startY+getY());
		gl.glVertex2f(stopX+getX(), stopY+getY());
		gl.glEnd();
	}
}
