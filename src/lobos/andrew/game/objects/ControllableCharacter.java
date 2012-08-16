package lobos.andrew.game.objects;

import lobos.andrew.game.scene.SceneObject;

public interface ControllableCharacter extends SceneObject {
	public void setLocation(float x, float y);
	public float getX();
	public float getY();
	
	public void moveRight();
	public void moveLeft();
	public void moveUp();
	public void moveDown();
	
	public void jump();
}
