package lobos.andrew.game.scene;

import javax.media.opengl.GL;

public interface SceneObject {
	public boolean shouldRender();
	public void render(GL gl);
	public void setLocation(float x, float y);
	public void setParentLocation(float x, float y);
}
