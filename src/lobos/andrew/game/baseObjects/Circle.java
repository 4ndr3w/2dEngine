package lobos.andrew.game.baseObjects;

import javax.media.opengl.GL;

import lobos.andrew.game.scene.BasicObject;

public class Circle extends BasicObject
{
	float radius;
	public Circle(float radius, float xPos, float yPos) {
		super(xPos, yPos);
		this.radius = radius;
	}

	@Override
	public void renderObject(GL gl) {
		gl.glBegin(GL.GL_LINE_LOOP);
		for ( int i = 0; i < 360; i++ )
		{
			float a = (float) Math.toRadians(i);
			gl.glVertex2d(getX()+Math.sin(a)*radius, getY()+Math.cos(a)*radius);
		}
		gl.glEnd();
	}
}
