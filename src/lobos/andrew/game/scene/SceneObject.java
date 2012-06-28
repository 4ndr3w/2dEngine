package lobos.andrew.game.scene;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import lobos.andrew.game.baseObjects.BoundingBox;
import lobos.andrew.game.physics.Force;

public interface SceneObject {
	public boolean shouldRender();
	public void render(GL gl, GLAutoDrawable renderable);
	public float getX();
	public float getY();
	public void setLocation(float x, float y);
	public void setParentLocation(float x, float y);
	public boolean isTouching(SceneObject obj);
	
	public BoundingBox getBoundingBox();
	public boolean boundingCheck(BoundingBox obj);
	public boolean isGravityAffected();
	public boolean isOutOfBounds();
	public void setGravityAffected(boolean state);
	public void setSolidFromSide(Surface side);
	public boolean isSolid();
	public Surface getSurfaceType();
	
	public void applyForce(Force f);
	public Force getForce();
}