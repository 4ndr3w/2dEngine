package lobos.andrew.game.baseObjects;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import lobos.andrew.game.scene.BasicObject;
import lobos.andrew.game.scene.SceneObject;

public class Circle extends BasicObject
{
	private float radius;
	private boolean fill = false;
	
	public Circle(float radius, float xPos, float yPos) {
		super(xPos, yPos);
		this.radius = radius;
	}
	
	public void setFill(boolean state)
	{
		fill = state;
	}

	@Override
	public void renderObject(GL gl, GLAutoDrawable renderable) 
	{
		float XRight = -1;
		float highestY = -1;
		float XLeft = 1;
		float lowestY = 1;
		
		
		
		
		if ( fill )
			gl.glBegin(GL.GL_TRIANGLE_FAN);
		else
			gl.glBegin(GL.GL_LINE_LOOP);
		
		for ( int i = 0; i < 360; i++ )
		{
			float a = (float) Math.toRadians(i);
			float x = (float) (Math.sin(a)*radius);
			float y = (float) (Math.cos(a)*radius);
			
			if ( y > highestY )
				highestY = y;
			
			if ( y < lowestY )
				lowestY = y;
			
			if ( x > XRight )
				XRight = x;
			if ( x < XLeft )
				XLeft = x;
		
			
			gl.glVertex2d(x+getX(), y+getY());
		}
		gl.glEnd();		
		
		boundingBox.setExtremes(highestY, lowestY, XLeft, XRight);
		
		boundingBox.setLocation(getX(), getY());
		
		boundingBox.render(gl);
	}
}


