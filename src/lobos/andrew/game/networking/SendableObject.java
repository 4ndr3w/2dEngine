package lobos.andrew.game.networking;

import java.util.HashMap;

public interface SendableObject {
	public float getX();
	public float getY();
	public int getInstanceID();
	public HashMap<String, String> getProperties();
}
