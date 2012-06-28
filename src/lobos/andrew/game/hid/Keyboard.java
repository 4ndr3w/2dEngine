package lobos.andrew.game.hid;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import lobos.andrew.game.baseObjects.BoundingBox;
import lobos.andrew.game.core.Renderer;
import lobos.andrew.game.scene.Scene;

public class Keyboard implements KeyListener {
	private static Keyboard instance = null;
	private Keyboard()
	{
		 
	}
	
	public static Keyboard getInstance()
	{
		if ( instance == null )
			instance = new Keyboard();
		return instance;
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if ( e.getKeyChar() == 'b' )
			BoundingBox.renderBoxes = !BoundingBox.renderBoxes;
		
		Scene current = Renderer.getInstance().getCurrentScene();
		if ( current != null ) current.keyPressed(e);		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Scene current = Renderer.getInstance().getCurrentScene();
		if ( current != null ) current.keyReleased(e);		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		Scene current = Renderer.getInstance().getCurrentScene();
		if ( current != null ) current.keyTyped(e);		
	}

}
