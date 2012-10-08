package lobos.andrew.game.baseObjects;

import lobos.andrew.game.scene.BasicObject;
import static org.lwjgl.opengl.GL11.*;

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
	public void renderObject() 
	{
		float XRight = -1;
		float highestY = -1;
		float XLeft = 1;
		float lowestY = 1;
		
		if ( fill )
			glBegin(GL_TRIANGLE_FAN);
		else
			glBegin(GL_LINE_LOOP);
		
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
		
			glVertex2d(x+getX(), y+getY());
		}
		glEnd();		
		
		boundingBox.setExtremes(highestY, lowestY, XLeft, XRight);
		
		boundingBox.setLocation(getX(), getY());
		
		boundingBox.render();
	}
}


