package lobos.andrew.game.baseObjects;

import javax.media.opengl.GL;

import lobos.andrew.game.scene.BasicObject;

public class Rectangle extends BasicObject {
	public Rectangle(int length, int width, int x, int y)
	{
		super(x,y);
	}
	
	@Override
	public void renderObject(GL gl) {
		gl.glBegin(GL.GL_QUADS);
		gl.glVertex2f(0.0f,0.0f);
		gl.glVertex2f(1.0f,0.0f);
		
		gl.glVertex2f(1.0f,1.0f);
		gl.glVertex2f(0.0f,1.0f);
		gl.glEnd();
		
	}
	

}
