package lobos.andrew.game.baseObjects;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import lobos.andrew.game.scene.BasicObject;
import lobos.andrew.game.scene.SceneObject;

public class Rectangle extends BasicObject {
	float point1X, point1Y; 
	float point2X, point2Y;
	float point3X, point3Y;
	float point4X, point4Y;
	
	float xPos, yPos;
	
	public Rectangle(float point1X, float point1Y, 
			float point2X, float point2Y,
			float point3X, float point3Y,
			float point4X, float point4Y,
			float xPos, float yPos)
	{
		super(xPos,yPos);
		
		this.point1X = point1X;
		this.point1Y = point1Y;
		
		this.point2X = point2X;
		this.point2Y = point2Y;
		
		this.point3X = point3X;
		this.point3Y = point3Y;
		
		this.point4X = point4X;
		this.point4Y = point4Y;
		
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	@Override
	public void renderObject(GL gl, GLAutoDrawable renderable) {
		gl.glBegin(GL.GL_QUADS);
		
		gl.glVertex2f(point1X+xPos, point1Y+yPos);
		gl.glVertex2f(point2X+xPos, point2Y+yPos);
		gl.glVertex2f(point3X+xPos, point3Y+yPos);
		gl.glVertex2f(point4X+xPos, point4Y+yPos);
		
		gl.glEnd();
		
	}

	@Override
	public boolean isTouching(SceneObject obj) {
		
		return false;
	}
	

}
